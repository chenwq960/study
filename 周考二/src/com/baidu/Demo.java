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
		
		//創建list結合用於存儲。txt文件
		List list = new ArrayList();
		//創建hashset存儲  文件夾
		Set set = new HashSet();
		FileOutputStream fos = null;
		BufferedReader br = null;
		
		FileOutputStream output = null;
		System.out.println("請輸入要創建的文件夾名稱");
		Scanner scanner = new Scanner(System.in);
		String absolute = scanner.next();
		File dir = new File(new File("d:\\"),absolute);
		try {
			System.out.println("文件夾創建成功，請輸入要寫入文件的內容");
			//BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file,absolute))));
			fos = new FileOutputStream(dir);
//			OutputStreamWriter change = new OutputStreamWriter(fos);
//			BufferedWriter buf = new BufferedWriter(change);
			int message  = scanner.nextInt();	
			fos.write(message);
			System.out.println("文件寫入成功");
			System.out.println("---------------------改盤符下txt文件和文件夾有----------------");
			System.out.println(dir);
			
			
			
			//demo.fun(new File("d:\\java"),list,set);
			File dirMes []= new File("d:\\").listFiles();
			for (File j : dirMes) {
				if(j.getName().endsWith(".txt"))
					list.add(j);
				if(j.isDirectory())
					set.add(j);
			}	
			//list集合中的元素為
			Iterator it = list.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
				
			}
			System.out.println("--------------------所有文件夾有------------------------------");
			Iterator iterator = set.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
			
			//讀取一個文件
			System.out.println("請輸入一個文件，將他讀取打印之後再刪除");
			String absolutewj = scanner.next();
			File wj = new File("D:\\",absolutewj);
			br = new BufferedReader(new FileReader(wj));
			int i = 0 ;
			char a [] = new char[1024];
			while((i = br.read(a))!=-1) {
				System.out.println(new String(a,0,i));
			}
			//刪除文件
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
	
	//使用遞歸打印找出所謂的文件和文件夾
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
