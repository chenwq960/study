package com.baidu;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Demo {
	public static void main(String[] args) {	
		Demo demo = new Demo();
		
		//����list�Y����춴惦��txt�ļ�
		List list = new ArrayList();
		//����hashset�惦  �ļ��A
		Set set = new HashSet();
		FileOutputStream fos = null;
		BufferedReader br = null;
		
		FileOutputStream output = null;
		System.out.println("Ոݔ��Ҫ�������ļ��A���Q");
		Scanner scanner = new Scanner(System.in);
		String absolute = scanner.next();
		File dir = new File(new File("d:\\"),absolute);
		try {
			System.out.println("�ļ��A�����ɹ���Ոݔ��Ҫ�����ļ��ă���");
			//BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file,absolute))));
			fos = new FileOutputStream(dir);
//			OutputStreamWriter change = new OutputStreamWriter(fos);
//			BufferedWriter buf = new BufferedWriter(change);
			int message  = scanner.nextInt();	
			fos.write(message);
			System.out.println("�ļ�����ɹ�");
			System.out.println("---------------------�ıP����txt�ļ����ļ��A��----------------");
			System.out.println(dir);
			
			
			
			//demo.fun(new File("d:\\java"),list,set);
			File dirMes []= new File("d:\\").listFiles();
			for (File j : dirMes) {
				if(j.getName().endsWith(".txt"))
					list.add(j);
				if(j.isDirectory())
					set.add(j);
			}	
			//list�����е�Ԫ�؞�
			Iterator it = list.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
				
			}
			System.out.println("--------------------�����ļ��A��------------------------------");
			Iterator iterator = set.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
			
			//�xȡһ���ļ�
			System.out.println("Ոݔ��һ���ļ��������xȡ��ӡ֮���لh��");
			String absolutewj = scanner.next();
			File wj = new File("D:\\",absolutewj);
			br = new BufferedReader(new FileReader(wj));
			int i = 0 ;
			char a [] = new char[1024];
			while((i = br.read(a))!=-1) {
				System.out.println(new String(a,0,i));
			}
			//�h���ļ�
			wj.delete();
			
		}catch (IOException e) {
			System.out.println(e.toString());
		}finally {
			try {
				if(output!=null)
					output.close();
			}catch (IOException e) {
				System.out.println(e.toString());
			}
			
			try {
				if(fos!=null)
					fos.close();
			}catch (IOException e) {
				System.out.println(e.toString());
			}
			try {
				if(br!=null)
					br.close();
			}catch (IOException e) {
				System.out.println(e.toString());
			}
			
		}
		
		
	}
	
	//ʹ���f�w��ӡ�ҳ����^���ļ����ļ��A
//	public void fun(File dir,List list,Set set) {
//		set.add(dir);
//		//System.out.println(dir);
//		File[] mes =dir.listFiles();
//		for(int i = 0 ; i <mes.length; i ++) {
//			if(mes[i].isDirectory()) {
//				fun(mes[i],list,set);
//				
//			}else {
//				if(mes[i].getName().endsWith(".txt")) {
//					list.add(mes[i]);
//				}
//			}
//				
//			
//		}
//		
//	}
}
