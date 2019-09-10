package com.baidu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) {
		//创建文件路径
		File file = new File("D:/io3/stu.info");
		//创建写入对象的流
		ObjectOutputStream oos = null;
		//反序列化  将二进制读取为文件的操作
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			//创建对象 写入磁盘中		
			oos.writeObject(new Student("张三", 18,'男'));
			
			ois = new ObjectInputStream(new FileInputStream(file));
			Student stu = (Student) ois.readObject();
			System.out.println(stu);
			
		}catch (IOException e) {
			System.out.println(e.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
（1）创建类Student，有属性姓名name、年龄age、性别gender。（10分）
（2）在测试类中实例化1个Student对象stu，并且保存对象的姓名为张三、年龄为18、性别为男。（10分）
（3）将stu对象通过对象序列化存储到磁盘文件(D:/io3/stu.info)。（10分）
（4）再创建一个测试类，在main方法中通过对象反序列化技术读取二进制文件中的内容，还原stu对象信息，并输出到控制台。（10分）
（5）适当加入注释。（5分）
		*/
		
	}

}
