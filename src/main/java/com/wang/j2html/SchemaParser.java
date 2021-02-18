package com.wang.j2html;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
                  String  opt = sequnceElement.attributeValue("opt");
                    String sequenceName = sequnceElement.attributeValue("name");


                org.jsoup.nodes.Element li = new org.jsoup.nodes.Element("li");
                li.text(description.getValue());
                li.appendTo(layui_tab_titile);

                org.jsoup.nodes.Element layui_tab_item = new org.jsoup.nodes.Element("div");
                layui_tab_item.addClass("layui-tab-item");

                org.jsoup.nodes.Element sequenceTable = new org.jsoup.nodes.Element("table");
                sequenceTable.addClass("tablelist2");
                sequenceTable.attr("sequencename",sequenceName);
                sequenceTable.attr("opt",opt);
                Attribute repeat = sequnceElement.attribute("repeat");
                if(repeat!=null&&"true".equals(repeat.getValue())){

                    org.jsoup.nodes.Element subsequenceTitleTr = J2htmlApplication.createSubSequenceTitleTr(description.getValue(),opt);
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
                        org.jsoup.nodes.Element option = new org.jsoup.nodes.Element("option");
                        option.val(name1);
                        option.text(name1);
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
                        List<Element> contentElements =  tagElement.selectNodes("content");
                        appendTagContent(contentElements,td2,name1);
                        if("true".equals(repeat)){
                            td2.append("<input class=\"addTag\" type=\"button\" value=\"添加\" >");
                            td2.append("<input class=\"deleteTag\"  type=\"button\" value=\"删除\" >");
                        }
                        td2.appendTo(tr);
                    }

                }else{
                    td1.text(name).append(notNullSpan.toString());
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
                org.jsoup.nodes.Element tbody = new org.jsoup.nodes.Element("tbody");
                tbody.attr("subSequenceName",name);
                tbody.attr("opt",opt);
                String description = element.attributeValue("description");
                org.jsoup.nodes.Element subsequenceTitleTr = J2htmlApplication.createSubSequenceTitleTr(description,opt);
                if("true".equals(repeat)){
                    org.jsoup.nodes.Element td = subsequenceTitleTr.select("td").first();
                    td.append("<input class=\"addSubSequence\" type=\"button\" value=\"添加\" >");
                    td.append("<input  class=\"deleteSubSequence\" type=\"button\" value=\"删除\" >");
                }
                subsequenceTitleTr.appendTo(tbody);
                createSequence(tbody,element);
                org.jsoup.nodes.Element subsequenceTitleTrEnd = J2htmlApplication.createSubSequenceTitleTr("End of "+description,null);
                subsequenceTitleTrEnd.appendTo(tbody);
                tbody.appendTo(parent);
            }
        }



        return parent;
    }


    public static void appendTagContent(List<Element> contentElements,org.jsoup.nodes.Element td2,String tagName){
        for (int i = 0; i < contentElements.size(); i++) {
            Element e = contentElements.get(i);
            String contentType = e.attributeValue("type");
            String contentText = e.getText();
            String contentName = e.attributeValue("contentName");
            String contentPrefix = e.attributeValue("prefix");
            if("fval".equals(contentType)){
                org.jsoup.nodes.Element label = new org.jsoup.nodes.Element("label");
                label.addClass("tag-data");
                label.text(contentText);
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
                        org.jsoup.nodes.Element option = new org.jsoup.nodes.Element("option");
                        String value = optionValues.get(j);
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
                    option.attr("data-enumdata", enumdata.deleteCharAt(enumdata.length()-1).toString());
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
                textarea.attr("data-content","");
                if(contentPrefix!=null&&contentPrefix.length()>0){
                    textarea.attr("data-contentprefix",contentPrefix);
                }
                textarea.attr("data-cols",cols);
                textarea.attr("data-rows",rows);
                textarea.appendTo(td2);
            }
            else{

                org.jsoup.nodes.Element input = new org.jsoup.nodes.Element("input");
                input.addClass("tag-data");
                input.attr("type","text");
                input.attr("name",tagName);
                input.attr("data-content","");
                if(contentPrefix!=null&&contentPrefix.length()>0){
                    input.attr("data-contentprefix",contentPrefix);
                }
                input.appendTo(td2);
            }
        }

    }



}
