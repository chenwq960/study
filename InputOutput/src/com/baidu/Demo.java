package com.baidu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {
	public static void main(String[] args) throws IOException {
		
		
		Demo demo = new Demo();
		demo.intputstreamweiter();
		
		List<String> list = new ArrayList<String>();
		File file = new File("d:\\day");
		demo.Seach(file,list);
		
		Iterator<String> it = list.listIterator();
		
		
		System.out.println("便利制定目录下所有的Java文件");
		while(it.hasNext()) 
			System.out.println(it.next());
	}
	//转换流的应用
	public void intputstreamweiter() {
		File file = new File("c:\\ran.txt");
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			
			bw.write("陈文庆在练习转换流");
			bw.close();
			br = new BufferedReader(new FileReader(file));
			System.out.println(br.readLine());
			
			
		} catch (IOException e) {
			System.out.println(e.toString());
		}finally {
			try {
				if(br!=null)
					br.close();
				
			} catch (IOException e2) {
				System.out.println(e2.toString());
			}
		}
		
		
//		FileReader read = new FileReader(file);
//		BufferedReader buf = new BufferedReader(read);
//		System.out.println(buf.readLine());
	}
	
	//搜索某个盘符下所有的Java文件   使用递归
	public void Seach(File file,List<String> list) {
		@SuppressWarnings("static-access")
		File [] dir = file.listFiles();
		for(int i = 0 ; i < dir.length; i ++) {
			if(dir[i].isDirectory()) 
				Seach(dir[i],list);
			else 
				if(dir[i].getName().endsWith(".java")) 
					list.add(dir[i].getAbsolutePath());	
		}
	}
	
	
}
