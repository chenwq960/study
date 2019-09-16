package com.baidu;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Model {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket serversocket = new ServerSocket(9999);
		System.out.println("服务器等待连接");
		Socket socket = serversocket.accept();
		System.out.println("连接成功");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		InputStream input = socket.getInputStream();
		
		OutputStream output = socket.getOutputStream();
		byte b [] = new byte[1024];
		int i = 0;
		while(true) {
			output.write(scanner.next().getBytes());
			output.flush();
			
			i = input.read(b);
			System.out.println(new String(b,0,i));
			
			
			
		}
		
		
	}
}
