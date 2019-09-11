package com.lenovo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
	public static void main(String[] args)  throws IOException {
		show();
	}
	public static void show(){
		
		try(BufferedReader br = new BufferedReader(new FileReader("c:\\新建文本文档.txt"))) {
			String reg = "[\\w]+@\\w+\\.[a-z]+";
			Pattern pattern = Pattern.compile(reg);
			String line = null;
			while((line = br.readLine())!=null) {
				Matcher m = pattern.matcher(line);
				while(m.find()) {
					System.out.println(m.group());
				}
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
		
	}

}
