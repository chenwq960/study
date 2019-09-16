package com.baidu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) throws  IOException {
		@SuppressWarnings("resource")
		Socket socket = new Socket("127.0.0.1", 9999);
		System.out.println("等待连接");
		InputStream input = socket.getInputStream();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		OutputStream output = socket.getOutputStream();
		@SuppressWarnings("unused")
		InputStream intput = socket.getInputStream();
		
		byte b [] = new byte[1024];
		
		int i = 0;
		while(true) {
			 i = input.read(b);
			 System.out.println(new String(b,0,i));
			 
			output.write(scanner.next().getBytes());
			output.flush();
			
			
		}
		
	}
}
