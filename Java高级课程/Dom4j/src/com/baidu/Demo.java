package com.baidu;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo {
	public static void main(String[] args) throws DocumentException {
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read("src/application.xml");
		//获取根元素
		Element rootElement = read.getRootElement();
		System.out.println(read.getRootElement().getName());
		Set<String> set = new TreeSet<String>();
		
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
//			System.out.println(element.getName());
			List<Element> elements2 = element.elements();
			for (Element el : elements2) {
				set.add(el.getData().toString());
			}
		}
		//存储到set集合中
		set.forEach(System.out::println);
	}
}
