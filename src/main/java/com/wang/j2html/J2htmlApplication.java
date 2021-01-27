package com.wang.j2html;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        try {


            System.out.println(J2htmlApplication.class.getClassLoader().getClass().getResource("/schema/mt500_schema.json").getPath());

            BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(J2htmlApplication.class.getClassLoader().getClass().getResource("/schema/mt500_schema.json").getPath())));



            StringBuilder jsonBuilder = new StringBuilder();
            while(true){
                String string = bufferedReader.readLine();
                if(string==null){
                    break;
                }
               jsonBuilder.append(string);
            }
            System.out.println(jsonBuilder.toString());
            JSONObject schema = JSON.parseObject(jsonBuilder.toString());
             JSONObject jsonObject =  (JSONObject)schema.get("properties");
            System.out.println(jsonObject.toJSONString());


        } catch (IOException e) {
            System.out.println("file not exist");
        }
    }

    public Element parser(Element root ,JSONObject schema){


        String type =(String)schema.get("type");
        JSONObject properties = schema.getJSONObject("properties");
        if("array".equals(type)){

            JSONArray items = schema.getJSONArray("items");
            for (int i = 0; i < items.size() ; i++) {
                JSONObject jsonObject =(JSONObject) items.get(i);
                parser(root,jsonObject);
            }

        }else if("object".equals(type)){
            Element collapse  =  new Element("div");
            collapse.addClass("layui-collapse");

            Set<Map.Entry<String,Object>> keySet = properties.entrySet();
            for (Iterator<Map.Entry<String,Object>> iterator = keySet.iterator();iterator.hasNext();){
                Map.Entry<String,Object> entry = iterator.next();
                String key = entry.getKey();
                JSONObject jsonObject =(JSONObject) properties.get(key);
                parser(root,jsonObject);
            }
        }else{
            Element content  =  new Element("div");

        }

        return root;

    }

}
