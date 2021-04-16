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
        modifyRegexp("11A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CurrencyCode>[${a}]{3})$");
        modifyRegexp("12A","^:(?<Qualifier>[${c}]{4})\\/(?<DataSo`urceScheme>([${c}]{0,8})?)\\/(?<InstrumentCodeorDescription>[${x}]{1,30})$");
        modifyRegexp("12B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{0,8})?)\\/(?<InstrumentTypeCode>[${c}]{4}$)");
        modifyRegexp("12C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CFICode>[${c}]{6})$");
        modifyRegexp("13A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<NumberId>[${c}]{3})$");
        modifyRegexp("13B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{0,8})?)\\/(?<Number>[${x}]{1,30})$");
        modifyRegexp("13J","^:(?<Qualifier>[${c}]{4})\\/\\/(?<ExtendedNumberId>[${c}]{5})$");
        modifyRegexp("13K","^:(?<Qualifier>[${c}]{4})\\/\\/(?<NumberId>[${c}]{3})\\/(?<Quantity>${d})$");
       // modifyRegexp("16R","");
      //  modifyRegexp("16S","");
        modifyRegexp("17B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Flag>[${a}]{1})$");
        modifyRegexp("19A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Sign>[N]?)(?<CurrencyCode>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("19B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CurrencyCode>[${a}]{3})(?<Amount>${d})$");
       // modifyRegexp("20","");
        modifyRegexp("20C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Reference>[${x}]{1,16})$");
        modifyRegexp("20D","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Reference>[${x}]{1,25})$");
        modifyRegexp("20U","^:(?<Qualifier>[${c}]{4})\\/\\/(?<UTIReference>[${x}]{1,52})$");
      //  modifyRegexp("21","");
        modifyRegexp("22F","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{0,8})?)\\/(?<Indicator>[${c}]{4})$");
        modifyRegexp("22H","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Indicator>[${c}]{4})$");
      //  modifyRegexp("23","");
        modifyRegexp("23G","^(?<Function>[${c}]{4})(?<Subfunction>(\\/[${c}]{4})?)$");
        modifyRegexp("24B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<ReasonCode>[${c}]{4}$)");
        modifyRegexp("25D","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<StatusCode>[${c}]{4})$");
       // modifyRegexp("26H","");
        modifyRegexp("28E","^(?<PageNumber>[${n}]{1,5})\\/(?<ContinuationIndicator>[${c}]{4})$");
        modifyRegexp("29A","^(?<Narrative>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("29B","^(?<Narrative>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("30","^(?<Date>[${n}]{6})$");
        modifyRegexp("31F","^(?<Date>[${n}]{6})(?<Period Date>(\\/[${n}]{6})?)(?<PeriodDetails>(\\/\\/[${x}]{1,35})?)$");
        modifyRegexp("31L","^(?<Date>[${n}]{6})$");
        modifyRegexp("31P","^(?<Date>[${n}]{6})(?<Place>([${x}]{1,29})?)$");
        modifyRegexp("31X","^((?<Date>[${n}]{6})((?<Time>[${n}]{4}))?)?(?<Code>([${a}]{7})?)$");
        modifyRegexp("32A","^(?<Date>[${n}]{6})(?<Currency>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("32B","^(?<Currency>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("33S","^(?<Code>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("33T","^(?<Currency>[${a}]{3})(?<Price>${d})$");
        modifyRegexp("34B","^(?<Currency>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("35A","^(?<Type>[${a}]{3})(?<Quantity>${d})$");
        modifyRegexp("35B","^(?<IdentificationofSecurity>(ISIN [${c}]{12})?)(?<crlf>(\\r\\n)?)(?<DescriptionofSecurity>(([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})?)$");
        modifyRegexp("35H","^(?<Sign>[N]?)(?<Currency>[${a}]{3})(?<Quantity>${d})$");
        modifyRegexp("35N","^(?<Type>[${a}]{3})(?<Quantity>${d})$");
        modifyRegexp("35S","^(?<Type>[${a}]{3})(?<Quantity>${d})$");
        modifyRegexp("36B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<QuantityTypeCode>[${c}]{4})\\/(?<Quantity>${d})$");
        modifyRegexp("36C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<QuantityCode>[${c}]{4})$");
        modifyRegexp("36E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<QuantityTypeCode>[${c}]{4})\\/(?<Sign>[N]?)(?<Quantity>${d})$");
        modifyRegexp("37A","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37B","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37C","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37D","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37E","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37F","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37J","^(?<Rate>${d})$");
        modifyRegexp("57A","^(?<PartyIdentifier>(\\/[${a}]{1})?(\\/[${x}]{1,34})?)(?<crlf>(\\r\\n)?)(?<IdentifierCode>[${a}]{4}[${a}]{2}[${c}]{2}([${c}]{3})?)$");
        modifyRegexp("57B","^(?<PartyIdentifier>(\\/[${a}]{1})?(\\/[${x}]{1,34})?)(?<crlf>(\\r\\n)?)(?<Location>(([${x}]{1,35}){1})?)$");
        modifyRegexp("57D","^(?<PartyIdentifier>(\\/[${a}]{1})?(\\/[${x}]{1,34})?)(?<crlf>(\\r\\n)?)(?<NameandAddress>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("69A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date1>[${n}]{8})\\/(?<Date2>[${n}]{8})$");
        modifyRegexp("69B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date1>[${n}]{8})(?<Time1>[${n}]{6})\\/(?<Date2>[${n}]{8})(?<Time2>[${n}]{6})$");
        modifyRegexp("69C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date>[${n}]{8})\\/(?<DateCode>[${c}]{4})$");
        modifyRegexp("69D","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date>[${n}]{8})(?<Time>[${n}]{6})\\/(?<DateCode>[${c}]{4})$");
        modifyRegexp("69E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<DateCode>[${c}]{4})\\/(?<Date>[${n}]{8})$");
        modifyRegexp("69F","^:(?<Qualifier>[${c}]{4})\\/\\/(?<DateCode>[${c}]{4})\\/(?<Date>[${n}]{8})(?<Time>[${n}]{6})$");
        modifyRegexp("69J","^:(?<Qualifier>[${c}]{4})\\/\\/(?<DateCode>[${c}]{4})$");
        modifyRegexp("70C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("70D","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>([${x}]{1,35}\\r\\n){0,5}([${x}]{1,35}){1})$");
        modifyRegexp("70E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>([${x}]{1,35}\\r\\n){0,9}([${x}]{1,35}){1})$");
        modifyRegexp("70F","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>[${z}]{1,8000})$");
        modifyRegexp("70G","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>([${x}]{1,35}\\r\\n){0,9}([${z}]{1,35}){1})$");
        modifyRegexp("70H","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>[${z}]{1,2500})$");
        modifyRegexp("72","^(?<Narrative>([${x}]{1,35}\\r\\n){0,5}([${x}]{1,35}){1})$");
        modifyRegexp("77D","^(?<Narrative>([${x}]{1,35}\\r\\n){0,5}([${x}]{1,35}){1})$");
        modifyRegexp("80C","");
        modifyRegexp("83C","");
        modifyRegexp("87A","");
        modifyRegexp("87D","");
        modifyRegexp("90A","");
        modifyRegexp("90B","");
        modifyRegexp("90E","");
        modifyRegexp("90F","");
        modifyRegexp("90J","");
        modifyRegexp("90K","");
        modifyRegexp("90L","");
        modifyRegexp("92A","");
        modifyRegexp("92B","");
        modifyRegexp("92C","");
        modifyRegexp("92D","");
        modifyRegexp("92F","");
        modifyRegexp("92H","");
        modifyRegexp("92J","");
        modifyRegexp("92K","");
        modifyRegexp("92L","");
        modifyRegexp("92M","");
        modifyRegexp("92N","");
        modifyRegexp("92P","");
        modifyRegexp("92R","");
        modifyRegexp("93A","");
        modifyRegexp("93B","");
        modifyRegexp("93C","");
        modifyRegexp("93D","");
        modifyRegexp("94B","");
        modifyRegexp("94C","");
        modifyRegexp("94D","");
        modifyRegexp("94E","");
        modifyRegexp("94F","");
        modifyRegexp("94G","");
        modifyRegexp("94H","");
        modifyRegexp("94L","");
        modifyRegexp("95C","");
        modifyRegexp("95L","");
        modifyRegexp("95P","");
        modifyRegexp("95Q","");
        modifyRegexp("95R","");
        modifyRegexp("95S","");
        modifyRegexp("95U","");
        modifyRegexp("95V","");
        modifyRegexp("97A","");
        modifyRegexp("97B","");
        modifyRegexp("97C","");
        modifyRegexp("97E","");
        modifyRegexp("98A","");
        modifyRegexp("98B","");
        modifyRegexp("98C","");
        modifyRegexp("98E","");
        modifyRegexp("98F","");
        modifyRegexp("98J","");
        modifyRegexp("98K","");
        modifyRegexp("99A","");
        modifyRegexp("99B","");
    }

    public static  void modifyRegexp(String tagName ,String newRegexp){
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
                    List<Element> tagList = root.selectNodes("//Tag[@name='"+tagName+"']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String oldRegexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp",newRegexp);
                        System.out.println(tagName+":"+oldRegexp);
                        System.out.println(tagName+":"+newRegexp);
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
