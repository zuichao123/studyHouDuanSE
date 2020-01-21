package com.fang.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;

/**
 * XML
 *      可扩展标记语言，简称XML
 *      特点：
 *          1、与操作系统无关；
 *          2、实现不同系统之间的数据交换；
 *          3、由一系列的标签元素组成；
 *      基本语法：
 *          <标签名 属性名="属性值">元素内容</标签名>
 *      注意事项：
 *          1、属性值用双引号包裹；
 *          2、一个标签可以有多个属性；
 *          3、属性值中不能包含特殊字符；
 *          4、XML标签区分大小写的；
 *          5、必须有正确的嵌套结构；
 *          6、同级标签以缩进对齐；
 *          7、标签名称可以包含字母、数组或者其他的字符；
 *          8、标签名称不能以数字或者标点符号开始；
 *          9、标签名称不能包含空格；
 *
 *      dom4j 是一款强大的java XML API，性能优异，功能强大，使用简单。
 *
 */

public class XmlTest {
    public static void main(String[] args) {
        read();
//        add();
//        update();
//        delete();
    }

    public static void update() {
        try {
            // 1、实例化SAXReader对象
            SAXReader saxReader = new SAXReader();
            // 2、读取XML文件，生成Document
            Document document = saxReader.read("E:\\ideaIC\\studyHouDuan\\JavaBasic\\src\\main\\java\\com\\fang\\xml\\book.xml");
            // 3、获取根节点元素
            Element root = document.getRootElement();
            // 4、迭代根节点
            Iterator<Element> rootIter = root.elementIterator();
            while(rootIter.hasNext()) {
                Element element = rootIter.next();
                element.addAttribute("type", "计算机");
            }
            // 5、将修改之后的document对象写入book.xml
            OutputStream outputStream = new
                    FileOutputStream("E:\\ideaIC\\studyHouDuan\\JavaBasic\\src\\main\\java\\com\\fang\\xml\\book.xml");
            XMLWriter xmlWriter = new XMLWriter(outputStream);
            xmlWriter.write(document);
            xmlWriter.close();
            outputStream.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        try {
            // 1、实例化SAXReader对象
            SAXReader saxReader = new SAXReader();
            // 2、读取XML文件，生成Document
            Document document = saxReader.read("E:\\ideaIC\\studyHouDuan\\JavaBasic\\src\\main\\java\\com\\fang\\xml\\book.xml");
            // 3、获取根节点元素
            Element root = document.getRootElement();
            // 4、迭代根节点
            Iterator<Element> rootIter = root.elementIterator();
            while(rootIter.hasNext()) {
                Element element = rootIter.next();
                String id = element.attributeValue("id");
                if(id.equals("2")) {
                    element.getParent().remove(element);
                }
            }
            // 5、将修改后的document对象写入book.xml
            OutputStream outputStream = new
                    FileOutputStream("E:\\ideaIC\\studyHouDuan\\JavaBasic\\src\\main\\java\\com\\fang\\xml\\book.xml");
            XMLWriter xmlWriter = new XMLWriter(outputStream);
            xmlWriter.write(document);
            xmlWriter.close();
            outputStream.close();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void add() {
        try {
            // 1、实例化SAXReader对象
            SAXReader saxReader = new SAXReader();
            // 2、读取XML文件，生成Document
            Document document = saxReader.read("E:\\ideaIC\\studyHouDuan\\JavaBasic\\src\\main\\java\\com\\fang\\xml\\book.xml");
            // 3、获取根节点元素
            Element root = document.getRootElement();
            // 4、给根节点添加book节点
            Element book = root.addElement("book");
            // 5、给book添加id属性
            book.addAttribute("id", "3");
            // 6、给book添加那么属性
            Element name = book.addElement("name");
            name.addText("MySQL数据库");
            book.addElement("author").addText("汤姆");
            book.addElement("price").addText("60.5");
            // 7、将修改后的document对象写入book.xml
            OutputStream outputStream = new
                    FileOutputStream("E:\\ideaIC\\studyHouDuan\\JavaBasic\\src\\main\\java\\com\\fang\\xml\\book.xml");
            XMLWriter xmlWriter = new XMLWriter(outputStream);
            xmlWriter.write(document);
            xmlWriter.close();
            outputStream.close();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void read() {
        try {
            // 1、实例化SAXReader对象
            SAXReader saxReader = new SAXReader();
            // 2、读取XML文件，生成Document
            Document document = saxReader.read("E:\\ideaIC\\studyHouDuan\\JavaBasic\\src\\main\\java\\com\\fang\\xml\\book.xml");
            // 3、获取根节点元素
            Element root = document.getRootElement();
            System.out.println(root); // 根节点
            System.out.println(root.getName()); // 标签名
            // 4、迭代根节点
            Iterator<Element> iterator = root.elementIterator();
            while (iterator.hasNext()){
                Element element = iterator.next();
                String id = element.attributeValue("id");
                System.out.println("\tid:"+id);
                // 5、继续迭代
                Iterator<Element> iterator2 = element.elementIterator();
                while(iterator2.hasNext()){
                    Element attribute = iterator2.next();
                    String name = attribute.getName();
                    String value = attribute.getText();
                    System.out.println("\t"+name+":"+value);
                }
                System.out.println("");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
