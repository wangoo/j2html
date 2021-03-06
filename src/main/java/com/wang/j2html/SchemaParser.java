package com.wang.j2html;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SchemaParser {

    public static void parseMT(File file){
        SAXReader saxReader  = new SAXReader();
        try {
             Document document = saxReader.read(file);
             Element root = document.getRootElement();

             List<Element> sequenceList = root.selectNodes("//Sequence");
             if(sequenceList.isEmpty()){
                 return ;
             }

            org.jsoup.nodes.Element parent = new org.jsoup.nodes.Element("div");
             org.jsoup.nodes.Element layui_tab = new org.jsoup.nodes.Element("div");
            layui_tab.addClass("layui-tab layui-tab-brief");
            org.jsoup.nodes.Element layui_tab_titile = new org.jsoup.nodes.Element("ul");
            layui_tab_titile.addClass("layui-tab-title");
            org.jsoup.nodes.Element layui_tab_content= new org.jsoup.nodes.Element("div");
            layui_tab_content.addClass("layui-tab-content");

            for (int i = 0; i < sequenceList.size(); i++) {
                  Element sequnceElement= sequenceList.get(i);
                  Attribute description = sequnceElement.attribute("description");
                  String  opt = sequnceElement.attributeValue("opt");
                  String sequenceName = sequnceElement.attributeValue("name");
                 String repeat = sequnceElement.attributeValue("repeat");

                StringBuilder desc_zh_cn = new StringBuilder(16) ;
                if("M".equalsIgnoreCase(opt)){
                    desc_zh_cn.append("必填");
                }else{
                    desc_zh_cn.append("选填");
                }
                if("true".equalsIgnoreCase(repeat)){
                    desc_zh_cn.append("循环");
                }
                desc_zh_cn.append("分页"+sequenceName);


                org.jsoup.nodes.Element li = new org.jsoup.nodes.Element("li");
                li.text(desc_zh_cn.toString());
                li.appendTo(layui_tab_titile);

                org.jsoup.nodes.Element layui_tab_item = new org.jsoup.nodes.Element("div");
                layui_tab_item.addClass("layui-tab-item");

                org.jsoup.nodes.Element sequenceTable = new org.jsoup.nodes.Element("table");
                sequenceTable.addClass("tablelist2");
                sequenceTable.attr("sequencename",sequenceName);
                sequenceTable.attr("opt",opt);

                if(repeat!=null&&"true".equals(repeat)){

                    org.jsoup.nodes.Element subsequenceTitleTr = createSubSequenceTitleTr(desc_zh_cn.toString(),opt);
                    org.jsoup.nodes.Element td = subsequenceTitleTr.select("td").first();
                    td.append("<input class=\"addSequence\" type=\"button\" value=\"添加\" >");
                    td.append("<input class=\"deleteSequence\" type=\"button\" value=\"删除\" >");
                    subsequenceTitleTr.appendTo(sequenceTable);
                }

                sequenceTable.appendTo(layui_tab_item);
                createSequence(sequenceTable,sequnceElement);
                layui_tab_item.appendTo(layui_tab_content);


            }
            layui_tab_titile.appendTo(layui_tab);
            layui_tab_content.appendTo(layui_tab);
            layui_tab.selectFirst(".layui-tab-title li").addClass("layui-this");
            layui_tab.selectFirst(".layui-tab-item").addClass("layui-show");
            layui_tab.appendTo(parent);
           // System.out.println(parent.html());


            String templateHtmlPath = J2htmlApplication.class.getResource("/template").getPath();
            List<String> templateHtmlAllLines = Files.readAllLines(Paths.get(new File(templateHtmlPath).getAbsolutePath(),"/template.html"),StandardCharsets.UTF_8);
            for (int i = 0; i < templateHtmlAllLines.size(); i++) {
                String s = templateHtmlAllLines.get(i);
                boolean result =  s.contains("${template}");
                s = s.replace("${template}",parent.html());
                s = s.replace("${messagetype}",root.getName().toLowerCase());
                templateHtmlAllLines.set(i,s);
                if(result){
                  //  System.out.println(s);
                }
            }
            String userDir = System.getProperty("user.dir");
            Files.write(Paths.get(userDir,"/src/main/resources/template",root.getName().toLowerCase()+".html"),templateHtmlAllLines,StandardCharsets.UTF_8);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static org.jsoup.nodes.Element createSequence(org.jsoup.nodes.Element parent , org.dom4j.Element sequnceElement){


        for(Iterator<Element> iterator = sequnceElement.elementIterator();iterator.hasNext();){
            Element element = iterator.next();
            String elementName = element.getName();
            String name = element.attributeValue("name");
            String repeat = element.attributeValue("repeat");
            String opt = element.attributeValue("opt");
            org.jsoup.nodes.Element notNullSpan = new org.jsoup.nodes.Element("span");
            if("M".equals(opt)){
                notNullSpan.addClass("notnull");
                notNullSpan.text("*");
            }
            if("Tag".equals(elementName)){
                org.jsoup.nodes.Element tr = new org.jsoup.nodes.Element("tr");
                tr.attr("tagname",name);
                tr.attr("opt",opt);
                org.jsoup.nodes.Element td1 = new org.jsoup.nodes.Element("td");
                td1.addClass("tabL");
                if(name.endsWith("a")){
                    List<Element> elements = element.selectNodes("option/Tag");
                    org.jsoup.nodes.Element select = new org.jsoup.nodes.Element("select");
                    select.addClass("tagselect");
                    for (int i = 0; i < elements.size(); i++) {
                        Element e = elements.get(i);
                        String name1 = e.attributeValue("name");
                        String format = e.attributeValue("format");
                        org.jsoup.nodes.Element option = new org.jsoup.nodes.Element("option");
                        option.val(name1);
                        option.append(name1).append("  ("+format+")");
                        option.appendTo(select);
                    }
                    select.appendTo(td1);
                    notNullSpan.appendTo(td1);
                    td1.appendTo(tr);

                    for (int i = 0; i < elements.size(); i++) {
                        Element tagElement = elements.get(i);
                        String name1 = tagElement.attributeValue("name");
                        org.jsoup.nodes.Element td2 = new org.jsoup.nodes.Element("td");
                        td2.attr("tagname",name1);
                        String format = tagElement.attributeValue("format");
                        if(format!=null){
                            td2.attr("format",format);
                        }

                        String regexp = tagElement.attributeValue("regexp");
                        if(regexp!=null){
                            td2.attr("regexp",regexp);
                        }
                        List<Element> contentElements =  tagElement.selectNodes("content");
                        appendTagContent(contentElements,td2,name1);
                        if("true".equals(repeat)){
                            td2.append("<input class=\"addTag\" type=\"button\" value=\"添加\" >");
                            td2.append("<input class=\"deleteTag\"  type=\"button\" value=\"删除\" >");
                        }
                        td2.appendTo(tr);
                    }

                }else{

                    String format = element.attributeValue("format");
                    if(format!=null){
                        tr.attr("format",format);
                    }
                    String regexp = element.attributeValue("regexp");
                    if(regexp!=null){
                        tr.attr("regexp",regexp);
                    }
                    td1.append(name).append("  ("+format+")").append(notNullSpan.toString());
                    td1.appendTo(tr);
                    org.jsoup.nodes.Element td2 = new org.jsoup.nodes.Element("td");


                    List<Element> contentElements =  element.selectNodes("content");
                    appendTagContent(contentElements,td2,name);
                    if("true".equals(repeat)){
                        td2.append("<input class=\"addTag\" type=\"button\" value=\"添加\" >");
                        td2.append("<input class=\"deleteTag\"  type=\"button\" value=\"删除\" >");
                    }
                    td2.appendTo(tr);
                }
                tr.appendTo(parent);
            }else if(elementName.equals("SubSequence")){
                org.jsoup.nodes.Element tr = new org.jsoup.nodes.Element("tr");
                tr.attr("subSequenceName",name);
                tr.attr("opt",opt);
                org.jsoup.nodes.Element td = new org.jsoup.nodes.Element("td");
                td.attr("colspan","4");
                org.jsoup.nodes.Element table = new org.jsoup.nodes.Element("table");
                String description = element.attributeValue("description");

                StringBuilder desc_zh_cn = new StringBuilder(16) ;
                if("M".equalsIgnoreCase(opt)){
                    desc_zh_cn.append("必填");
                }else{
                    desc_zh_cn.append("选填");
                }
                if("true".equalsIgnoreCase(repeat)){
                    desc_zh_cn.append("循环");
                }
                desc_zh_cn.append("子分页"+name);

                org.jsoup.nodes.Element subsequenceTitleTr = createSubSequenceTitleTr(desc_zh_cn.toString(),opt);
                if("true".equals(repeat)){
                    org.jsoup.nodes.Element repeatTd = subsequenceTitleTr.select("td").first();
                    repeatTd.append("<input class=\"addSubSequence\" type=\"button\" value=\"添加\" >");
                    repeatTd.append("<input  class=\"deleteSubSequence\" type=\"button\" value=\"删除\" >");
                }
                subsequenceTitleTr.addClass("delimiter");
                subsequenceTitleTr.addClass("content_show");
                subsequenceTitleTr.appendTo(table);
                createSequence(table,element);
                org.jsoup.nodes.Element subsequenceTitleTrEnd =createSubSequenceTitleTr(desc_zh_cn.toString()+" 结束",null);
                subsequenceTitleTrEnd.addClass("delimiter");
                subsequenceTitleTrEnd.addClass("content_show");
                subsequenceTitleTrEnd.appendTo(table);
                table.appendTo(td);
                td.appendTo(tr);
                tr.appendTo(parent);
            }
        }



        return parent;
    }


    private static void appendTagContent(List<Element> contentElements,org.jsoup.nodes.Element td2,String tagName){
        for (int i = 0; i < contentElements.size(); i++) {
            Element e = contentElements.get(i);
            String contentType = e.attributeValue("type");
            String contentText = e.getText().trim();
            String contentName = e.attributeValue("contentName");
            String contentPrefix = e.attributeValue("prefix");
            if("fval".equals(contentType)){
                org.jsoup.nodes.Element label = new org.jsoup.nodes.Element("label");
                label.addClass("tag-data");
                //crlf 即回车换行
                label.text(contentText.replaceAll("crlf",""));
                label.attr("data-content",contentText);
                if(contentPrefix!=null&&contentPrefix.length()>0){
                    label.attr("data-contentprefix",contentPrefix);
                }
                label.appendTo(td2);
            }else if("enum".equals(contentType)){
                org.jsoup.nodes.Element select = new org.jsoup.nodes.Element("select");
                select.addClass("tag-data");
                select.attr("data-content","");
                if(contentPrefix!=null&&contentPrefix.length()>0){
                    select.attr("data-contentprefix",contentPrefix);
                }
                select.append("<option value=''>请选择</option>");
                if(contentName!=null&&contentName.length()>0){
                    select.addClass("tag-data").attr("contentName",contentName);
                }
                if (contentText.length()>0) {
                    List<String> optionValues = JSON.parseArray(contentText,String.class);
                    for (int j = 0; j < optionValues.size(); j++) {
                        String value = optionValues.get(j);
                         org.jsoup.nodes.Element option = new org.jsoup.nodes.Element("option");
                         option.val(String.valueOf(value));
                         option.text(String.valueOf(value));
                         option.appendTo(select);


                    }
                }
                select.appendTo(td2);

            }else if("enum-data".equals(contentType)){
                String datafor = e.attributeValue("datafor");
                org.jsoup.nodes.Element select = new org.jsoup.nodes.Element("select");
                select.addClass("tag-data");
                select.addClass("enum-data");
                select.attr("data-content","");
                if(contentPrefix!=null&&contentPrefix.length()>0){
                    select.attr("data-contentprefix",contentPrefix);
                }
                select.attr("datafor",datafor);
                select.append("<option value=''>请选择</option>");
                JSONObject optionValues = JSON.parseObject(contentText,JSONObject.class, Feature.OrderedField);
                Set<Map.Entry<String, Object>> entrySet = optionValues.entrySet();
                for (Iterator<Map.Entry<String, Object>> iterator1 = entrySet.iterator(); iterator1.hasNext(); ) {
                    Map.Entry<String,Object> entry = iterator1.next();
                    String key = entry.getKey();
                    JSONArray values = (JSONArray) entry.getValue();
                    org.jsoup.nodes.Element option = new org.jsoup.nodes.Element("option");
                    option.val(String.valueOf(key));
                    StringBuilder enumdata =new StringBuilder(200);
                    for (int j = 0; j <values.size() ; j++) {
                        enumdata.append(values.get(j)).append(",");
                    }
                    if(values.size()>0){
                        enumdata.deleteCharAt(enumdata.length()-1);
                    }
                    option.attr("data-enumdata", enumdata.toString());
                    option.text(String.valueOf(key));
                    option.appendTo(select);
                }
                select.appendTo(td2);
            }else if("textarea".equals(contentType)){
                String cols = e.attributeValue("cols");
                String rows = e.attributeValue("rows");
                org.jsoup.nodes.Element textarea = new org.jsoup.nodes.Element("textarea");
                textarea.addClass("tag-data");
                textarea.addClass("textareaStyle");
                textarea.addClass("lineChar_"+cols+"x");
                textarea.attr("data-content","");
                textarea.attr("wrap","soft");
                textarea.attr("cols",String.valueOf(Integer.parseInt(cols)+20));
                textarea.attr("rows",rows);
                if(contentPrefix!=null&&contentPrefix.length()>0){
                    textarea.attr("data-contentprefix",contentPrefix);
                }
                String  characterSet = e.attributeValue("characterSet");
                if(characterSet!=null){
                    textarea.attr("data-characterset",characterSet);
                }
                textarea.attr("data-cols",cols);
                textarea.attr("data-rows",rows);
                textarea.appendTo(td2);
            }else if("CurrencyCode".equals(contentType)){
                org.jsoup.nodes.Element select = new org.jsoup.nodes.Element("select");
                select.addClass("tag-data");
                select.attr("data-content","");
                select.append("<option value=''>请选择</option>");
                select.append("<option value='AUD'>AUD</option>");
                select.append("<option value='CAD'>CAD</option>");
                select.append("<option value='CNY'>CNY</option>");
                select.append("<option value='HKD'>HKD</option>");
                select.append("<option value='JPY'>JPY</option>");
                select.append("<option value='GBP'>GBP</option>");
                select.append("<option value='USD'>USD</option>");
                select.append("<option value='EUR'>EUR</option>");
                select.appendTo(td2);
            }else if("date".equals(contentType)||"datetime".equals(contentType)){
                String dateFormat = e.attributeValue("format");
                org.jsoup.nodes.Element input = new org.jsoup.nodes.Element("input");
                input.addClass("tag-data");
                input.addClass("Wdate");
                input.attr("type","text");
                input.attr("data-content","");
                if(contentPrefix!=null&&contentPrefix.length()>0){
                    input.attr("data-contentprefix",contentPrefix);
                }
                if(!StringUtils.isEmpty(dateFormat)){
                    input.attr("onClick","WdatePicker({dateFmt:'"+dateFormat+"'})");
                }else if("date".equals(contentType)){
                    input.attr("onClick","WdatePicker({dateFmt:'yyyyMMdd'})");
                }else if("datetime".equals(contentType)){
                    input.attr("onClick","WdatePicker({dateFmt:'yyyyMMddHHmmss'})");

                }
                input.appendTo(td2);
            }else{
                org.jsoup.nodes.Element input = new org.jsoup.nodes.Element("input");
                input.addClass("tag-data");

                if("decimal".equals(contentType)){
                    input.addClass("decimal");
                }

                if(contentName!=null&&contentName.length()>0){
                    input.attr("contentName",contentName);
                }
                input.attr("type","text");
                input.attr("name",tagName);
                String  maxlength = e.attributeValue("maxlength");
                if(maxlength!=null){
                    input.attr("maxlength",maxlength);
                }

                String  fixedlength = e.attributeValue("fixedlength");
                if(fixedlength!=null){
                    input.attr("maxlength",fixedlength);
                    input.attr("minlength",fixedlength);
                }
                String  characterSet = e.attributeValue("characterSet");
                if(characterSet!=null){
                    input.attr("data-characterset",characterSet);
                }
                input.attr("data-content","");
                if(contentPrefix!=null&&contentPrefix.length()>0){
                    input.attr("data-contentprefix",contentPrefix);
                }
                input.appendTo(td2);
            }
        }

    }

    private static org.jsoup.nodes.Element createSubSequenceTitleTr(String text, String opt){
        org.jsoup.nodes.Element subsequenceTitleTr = new org.jsoup.nodes.Element("tr");
        org.jsoup.nodes.Element subsequenceTitleTd = new org.jsoup.nodes.Element("td");
        subsequenceTitleTd.addClass("tabL");
        subsequenceTitleTd.attr("colspan","4");
        subsequenceTitleTd.attr("style","font-weight: bold; text-align: center");

        org.jsoup.nodes.Element textElement = subsequenceTitleTd.text(text);
        if("M".equals(opt)){
            org.jsoup.nodes.Element notNullSpan = new org.jsoup.nodes.Element("span");
            notNullSpan.addClass("notnull");
            notNullSpan.text("*");
            textElement.append(notNullSpan.toString());
        }
        subsequenceTitleTd.appendTo(subsequenceTitleTr);
        return subsequenceTitleTr;
    }



}
