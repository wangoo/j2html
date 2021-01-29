package com.wang.j2html;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SchemaParser {

    public static void parseMT(File file){
        SAXReader saxReader  = new SAXReader();
        try {
             Document document = saxReader.read(J2htmlApplication.class.getClassLoader().getClass().getResource("/schema/MT500.xml"));
             Element root = document.getRootElement();

             List<Element> sequenceList = root.selectNodes("//Sequence");

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
                  Attribute opt = sequnceElement.attribute("opt");
                    String sequenceName = sequnceElement.attributeValue("name");


                org.jsoup.nodes.Element li = new org.jsoup.nodes.Element("li");
                li.text(description.getValue());
                li.appendTo(layui_tab_titile);

                org.jsoup.nodes.Element layui_tab_item = new org.jsoup.nodes.Element("div");
                layui_tab_item.addClass("layui-tab-item");

                org.jsoup.nodes.Element sequenceTable = new org.jsoup.nodes.Element("table");
                sequenceTable.addClass("tablelist2");


                Attribute repeat = sequnceElement.attribute("repeat");
                if(repeat!=null&&"true".equals(repeat.getValue())){

                    org.jsoup.nodes.Element subsequenceTitleTr = J2htmlApplication.createSubSequenceTitleTr(description.getValue());
                    org.jsoup.nodes.Element td = subsequenceTitleTr.select("td").first();
                    td.append("<input type=\"button\" value=\"添加\" name=\""+sequenceName+"\">");
                    td.append("<input type=\"button\" value=\"删除\" name=\""+sequenceName+"\">");
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
            System.out.println(parent.html());
        } catch (DocumentException e) {

        }
    }

    public static org.jsoup.nodes.Element createSequence(org.jsoup.nodes.Element parent , org.dom4j.Element sequnceElement){


        for(Iterator<Element> iterator = sequnceElement.elementIterator();iterator.hasNext();){
            Element element = iterator.next();
            String elementName = element.getName();
            String name = element.attributeValue("name");
            String repeat = element.attributeValue("repeat");
            if("Tag".equals(elementName)){
                org.jsoup.nodes.Element tr = new org.jsoup.nodes.Element("tr");
                org.jsoup.nodes.Element td1 = new org.jsoup.nodes.Element("td");
                td1.addClass("tabL");
                if(name.endsWith("a")){

                    List<Element> elements = element.selectNodes("option/Tag");
                    org.jsoup.nodes.Element select = new org.jsoup.nodes.Element("select");
                    for (int i = 0; i < elements.size(); i++) {
                        Element e = elements.get(i);
                        String name1 = e.attributeValue("name");
                        org.jsoup.nodes.Element option = new org.jsoup.nodes.Element("option");
                        option.val("TAG"+name1);
                        option.text("TAG"+name1);
                        option.appendTo(select);
                    }
                    select.appendTo(td1);
                }else{
                    td1.text(name);
                }
                td1.appendTo(tr);
                org.jsoup.nodes.Element td2 = new org.jsoup.nodes.Element("td");

                td2.append("<input type=\"text\" name=\""+name+"\">");

                if("true".equals(repeat)){

                    td2.append("<input type=\"button\" value=\"添加\" name=\""+name+"\">");
                    td2.append("<input type=\"button\" value=\"删除\" name=\""+name+"\">");
                }
                td2.appendTo(tr);
                tr.appendTo(parent);

            }else if(elementName.equals("SubSequence")){

                String description = element.attributeValue("description");
                org.jsoup.nodes.Element subsequenceTitleTr = J2htmlApplication.createSubSequenceTitleTr(description);
                if("true".equals(repeat)){
                    org.jsoup.nodes.Element td = subsequenceTitleTr.select("td").first();
                    td.append("<input type=\"button\" value=\"添加\" name=\""+name+"\">");
                    td.append("<input type=\"button\" value=\"删除\" name=\""+name+"\">");
                }
                subsequenceTitleTr.appendTo(parent);

                createSequence(parent,element);

                org.jsoup.nodes.Element subsequenceTitleTrEnd = J2htmlApplication.createSubSequenceTitleTr("End of "+description);
                subsequenceTitleTrEnd.appendTo(parent);
            }


        }


        return parent;
    }




}
