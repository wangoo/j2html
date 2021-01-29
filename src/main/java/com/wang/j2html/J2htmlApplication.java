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

        SchemaParser.parseMT(null);

    }

    public static Element createPage(Element parent ,JSONObject schema){

        Element layui_tab = new Element("div");
        layui_tab.addClass("layui-tab layui-tab-brief");
        Element layui_tab_titile = new Element("ul");
        layui_tab_titile.addClass("layui-tab-title");
        Element layui_tab_content= new Element("div");
        layui_tab_content.addClass("layui-tab-content");
        Set<java.util.Map.Entry<String, Object>>  entrySet = ((JSONObject)schema.get("properties")).entrySet();
        for (Iterator<java.util.Map.Entry<String, Object>> iterator = entrySet.iterator();iterator.hasNext();){
            Map.Entry<String,Object> entry = iterator.next();
            JSONObject page = (JSONObject) entry.getValue();
            Element li = new Element("li");
            li.text(page.get("title").toString());
            li.appendTo(layui_tab_titile);
            Element layui_tab_item = new Element("div");
            layui_tab_item.addClass("layui-tab-item");

            Element  sqquenceTable = new Element("table");
            sqquenceTable.addClass("tablelist2");
            sqquenceTable.appendTo(layui_tab_item);

            createSequence(sqquenceTable,(JSONObject) page);
            layui_tab_item.appendTo(layui_tab_content);

        }
        layui_tab_titile.appendTo(layui_tab);
        layui_tab_content.appendTo(layui_tab);
        layui_tab.appendTo(parent);
        parent.selectFirst(".layui-tab-title li").addClass("layui-this");
        parent.selectFirst(".layui-tab-item").addClass("layui-show");
        return parent;
    }


    public static Element createSequence(Element parent ,JSONObject schema){

        Set<java.util.Map.Entry<String, Object>>  entrySet = ((JSONObject)schema.get("properties")).entrySet();
        for (Iterator<java.util.Map.Entry<String, Object>> iterator = entrySet.iterator();iterator.hasNext();){
            Map.Entry<String,Object> entry = iterator.next();
            String key = entry.getKey();
            JSONObject  elements = (JSONObject) entry.getValue();
            if(key.startsWith("TAG")){
                Element  tr = new Element("tr");
                Element  td1 = new Element("td");
                td1.addClass("tabL");
                if(key.endsWith("a")){
                    JSONArray optionArray = elements.getJSONArray("option");
                    Element select = new Element("select");
                    for (int i = 0; i < optionArray.size(); i++) {
                        Object object = optionArray.get(i);
                        Element option = new Element("option");
                        option.val(object.toString());
                        option.text(object.toString());
                        option.appendTo(select);
                    }
                    select.appendTo(td1);
                }else{
                    td1.text(elements.get("title").toString());
                }

                td1.appendTo(tr);

                Element  td2 = new Element("td");
                String type ="";
                if("array".equals(type)){

                    JSONObject items = elements.getJSONObject("items");
                    type = items.get("type").toString();


                }else {
                    type = elements.get("type").toString();
                }


                 td2.append("<input type=\"text\" name=\""+key+"\">");


                if("array".equals(type)){

                    td2.append("<input type=\"button\" value=\"添加\" name=\""+key+"\">");
                    td2.append("<input type=\"button\" value=\"删除\" name=\""+key+"\">");
                }
                td2.appendTo(tr);
                tr.appendTo(parent);
            }else if(key.startsWith("subsequence")){

                String subsequenceType = elements.get("type").toString();
                Element subsequenceTitleTr = createSubSequenceTitleTr(elements.get("title").toString());
                subsequenceTitleTr.appendTo(parent);
                if("object".equals(subsequenceType)){
                        createSequence(parent,elements);
                }else if("array".equals(subsequenceType)){
                        createSequence(parent,elements.getJSONObject("items"));
                }



            }

        }

        return parent;
    }

    public static Element creatTag(Element parent ,JSONObject schema){


        return parent;
    }


    public static  Element createSubSequenceTitleTr(String text){
        Element subsequenceTitleTr = new Element("tr");
        Element subsequenceTitleTd = new Element("td");
        subsequenceTitleTd.addClass("tabL");
        subsequenceTitleTd.attr("colspan","4");
        subsequenceTitleTd.attr("style","font-weight: bold; text-align: center");
        subsequenceTitleTd.text(text);
        subsequenceTitleTd.appendTo(subsequenceTitleTr);
        return subsequenceTitleTr;
    }

    public static Element createBtn(){

        Element btn = new Element("input");
        btn.attr("type","button");
        return btn;
    }



}
