package com.wang.j2html;

import org.apache.commons.text.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MT5XXRegexpGenerate {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(J2htmlApplication.class, args);
        String filePath = J2htmlApplication.class.getResource("/schema").getPath();
        File schemaDirectory  = new File(filePath);


        if(schemaDirectory.isDirectory()){
            TreeMap<String,String> regexpMap = new TreeMap<>();
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        if(tagName.endsWith("a")){
                            continue;
                        }
                        String regexp = tagElement.attributeValue("regexp");
                        regexpMap.putIfAbsent(tagName,regexp);
                    }
                }
            }
           final FileWriter fileWriter = new FileWriter("MT5XXRegexpUtils.java");
             regexpMap.forEach((k,v)->{
                 if(v==null){
                     return;
                 }
                 System.out.println(k+":"+v);
                 v.replaceAll("\\/","/");
                 String set_x = "(\\w)(/)(\\-)(\\?)(\\:)(\\()(\\))(\\.)(\\,)(\\')(\\+)(\\r)(\\ )";
                 String set_y = "(A-Z)(\\d)(\\.)(\\,)(\\-)(\\()(\\))(/)(\\=)(\\')(\\+)(\\:)(\\?)(\\!)(\")(\\%)(\\&)(\\*)(\\<)(\\>)(\\;)(\\ )";
                 String set_z = "(\\w)(\\.)(\\,)(\\-)(\\()(\\))(/)(\\=)(\\')(\\+)(\\:)(\\?)(\\!)(\")(\\%)(\\&)(\\*)(\\<)(\\>)(\\;)(\\{)(\\@)(\\#)(\\_)(\\r)(\\ )";
                 String set_c = "\\w";
                 String set_n = "\\d";
                 String set_a = "(A-Za-z)";
                 String set_d ="[1-9]*[0-9]{1},[0-9]{0,2}";


                 v=v.replaceAll("\\$\\{x}",StringEscapeUtils.escapeJava(set_x)).replaceAll("\\$\\{y}",StringEscapeUtils.escapeJava(set_y)).replaceAll("\\$\\{z}",StringEscapeUtils.escapeJava(set_z))
                         .replaceAll("\\$\\{c}",StringEscapeUtils.escapeJava(set_c)).replaceAll("\\$\\{n}",StringEscapeUtils.escapeJava(set_n)).replaceAll("\\$\\{a}",StringEscapeUtils.escapeJava(set_a)).replaceAll("\\$\\{d}",StringEscapeUtils.escapeJava(set_d));
//                 v=v.replaceAll(Matcher.quoteReplacement("{x}"),set_x).replaceAll(Matcher.quoteReplacement("{y}"),set_y).replaceAll(Matcher.quoteReplacement("{z}"),set_z)
//                         .replaceAll(Matcher.quoteReplacement("{c}"),set_c).replaceAll(Matcher.quoteReplacement("{n}"),set_n).replaceAll(Matcher.quoteReplacement("{a}"),set_a).replaceAll(Matcher.quoteReplacement("{d}"),set_d);
                 try {
                     fileWriter.write("public static final Pattern pattern_"+k+"= Pattern.compile(\""+StringEscapeUtils.escapeJava(v)+"\");\r\n");
                     fileWriter.flush();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                     //private static final Pattern pattern = Pattern.compile("^:[0-9]{2}[A-Za]?:");

             });
        }
    }



}
