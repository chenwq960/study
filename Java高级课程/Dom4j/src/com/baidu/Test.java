package com.baidu;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
	public static void main(String[] args) throws DocumentException {
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read("src/app.xml");
		Element rootElement = read.getRootElement();
		System.out.println(rootElement.getName());

		List<Element> elements = rootElement.elements();
		// 第一层循环，获取根节点下的子元素
		for (Element element : elements) {
			System.out.println(element.attributeValue("name") + "\t" + element.attributeValue("postcode"));
			List<Element> elements2 = element.elements();
			// 获取第二节的子元素
			for (Element el : elements2) {
				List<Element> elements3 = el.elements();
				for (Element el3 : elements3) {
					System.out.println(el3.attributeValue("name") + "\t" + element.attributeValue("postcode"));
				}
			}
		}
	}
}
