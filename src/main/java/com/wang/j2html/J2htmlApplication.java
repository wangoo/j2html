package com.wang.j2html;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class J2htmlApplication {

    public static void main(String[] args) {


        SpringApplication.run(J2htmlApplication.class, args);
        String filePath = J2htmlApplication.class.getResource("/schema").getPath();
        File schemaDirectory  = new File(filePath);
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){
                    SchemaParser.parseMT(file);
                }
            }
        }



    }





}
