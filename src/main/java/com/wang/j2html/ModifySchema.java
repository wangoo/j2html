package com.wang.j2html;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ModifySchema {
    public static void main(String[] args) {
        modify92J();
    }
    public static void  modify92J(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='92J']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${c}]{4}\\/[${a}]{3}${d}(\\/[${c}]{4})?$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify92C(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='92C']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${x}]{1,24}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify25D(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='25D']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${c}]{4}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }
    public static void  modify99A(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='99A']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("format",":4!c//[N]3!n");
                        System.out.println(tagName+":"+format);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify95S(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='95S']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${c}]{4}\\/[${a}]{2}\\/[${x}]{1,30}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify92A(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='92A']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/\\/[N]?${d}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify19A(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='19A']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("format",":4!c//[N]3!a15d");
                        System.out.println(tagName+":"+format);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify99B(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='99B']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");

                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/\\/[${n}]{3}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify98B(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='98B']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");

                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${c}]{4}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify35B(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='35B']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        tagElement.addAttribute("regexp","^(ISIN [${c}]{12})?\\r\\n(([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})?$");

                        List<Element> contentList  = tagElement.selectNodes("./content[last()]");

                        Element contenntELement = contentList.get(0);
                        String contentTypt = contenntELement.attributeValue("type");
                        if("textarea".equals(contentTypt)){
                            contenntELement.addAttribute("prefix","lf");
                        }

                        List<Element> firstContentList  = tagElement.selectNodes("./content[position()=1]");
                        Element firstContentELement = firstContentList.get(0);
                        String  firstContentLength = firstContentELement.attributeValue("fixedlength");
                        System.out.println(firstContentLength);
                        firstContentELement.addAttribute("fixedlength","17");
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify95L(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='95L']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");

                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/\\/[${c}]{18}[${n}]{2}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify95C(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='95C']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");

                        tagElement.addAttribute("regexp","^:[${c}]{4}//[${a}]{2}$");
                        System.out.println(tagName+":"+regexp);
                    }

                   XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }
    public static void  modify16R16SFormat(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='16R']|//Tag[@name='16S']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        tagElement.addAttribute("format","16c");
                        //System.out.println(tagName);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }
}
