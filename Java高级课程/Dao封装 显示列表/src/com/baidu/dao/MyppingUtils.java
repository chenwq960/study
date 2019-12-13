package com.baidu.dao;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class MyppingUtils {
	private static Map<String, String> map = new ConcurrentHashMap<String,String>();
	
	static {
		SAXReader saxReader = new SAXReader();
		try {
			Document read = saxReader.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("mysql.xml"));
			Element rootElement = read.getRootElement();
			List<Element> elements = rootElement.elements();
			for (Element element : elements) {
				map.put(element.attributeValue("id"),element.getTextTrim());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	public static String getSql(String sql) {
		return map.get(sql);
	}
	
	
}
