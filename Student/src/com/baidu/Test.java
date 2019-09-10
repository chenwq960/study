package com.baidu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) {
		//�����ļ�·��
		File file = new File("D:/io3/stu.info");
		//����д��������
		ObjectOutputStream oos = null;
		//�����л�  �������ƶ�ȡΪ�ļ��Ĳ���
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			//�������� д�������		
			oos.writeObject(new Student("����", 18,'��'));
			
			ois = new ObjectInputStream(new FileInputStream(file));
			Student stu = (Student) ois.readObject();
			System.out.println(stu);
			
		}catch (IOException e) {
			System.out.println(e.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
��1��������Student������������name������age���Ա�gender����10�֣�
��2���ڲ�������ʵ����1��Student����stu�����ұ�����������Ϊ����������Ϊ18���Ա�Ϊ�С���10�֣�
��3����stu����ͨ���������л��洢�������ļ�(D:/io3/stu.info)����10�֣�
��4���ٴ���һ�������࣬��main������ͨ���������л�������ȡ�������ļ��е����ݣ���ԭstu������Ϣ�������������̨����10�֣�
��5���ʵ�����ע�͡���5�֣�
		*/
		
	}

}
