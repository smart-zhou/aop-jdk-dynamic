package com.yc256.proxy.config;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ConfigurationScanner
 *
 * @author Smart Zhou
 */
public class ConfigurationScanner {

    /**
     *
     * @param configuration 配置文件名
     * @throws Throwable
     */
    public void scan(String configuration) throws Throwable {
        // 读取xml文件,获取document对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbd = dbf.newDocumentBuilder();
        Document doc = dbd.parse(new FileInputStream(configuration));
        scan(doc);
    }

    public void scan(Document doc) throws Throwable {
        // 获取AopConfiguration对象
        XPathFactory f = XPathFactory.newInstance();
        XPath path = f.newXPath();
        List<AopConfiguration> configurations = new ArrayList<>();
        NodeList beans = (NodeList) path.evaluate("beans/bean", doc, XPathConstants.NODESET);
        if (beans != null) {
            for (int i = 0; i < beans.getLength(); i++) {
                Node bean = beans.item(i);
                System.out.println("NodeName:" + bean.getNodeName());
                NamedNodeMap attr = bean.getAttributes();
                System.out.println("该节点的属性个数 " + attr.getLength());
                //遍历元素的属性
                AopConfiguration configuration = new AopConfiguration();
                for (int j = 0; j < attr.getLength(); j++) {
                    Node item = attr.item(j);
                    String name = item.getNodeName();
                    switch (name) {
                        case "basePackage":
                            configuration.setBasePackage(item.getNodeValue());
                            break;
                        case "aopBeanClass":
                            configuration.setAopBeanClass(item.getNodeValue());
                            break;
                        case "beforeMethod":
                            configuration.setBeforeMethod(item.getNodeValue());
                            break;
                        case "afterMethod":
                            configuration.setAfterMethod(item.getNodeValue());
                            break;
                        default:
                            System.out.print("   属性  名称:" + item.getNodeName());
                            System.out.print("   值:" + item.getNodeValue());
                            System.out.print("   类型:" + item.getNodeType());
                            System.out.println();
                            break;
                    }
                }
                configurations.add(configuration);
            }
        }
        // 解析AopConfiguration对象,创建AopWatcher对象
    }

}
