package com.lenovo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Clion2 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		@SuppressWarnings({ "unused", "resource" })
		Socket socket = new Socket("127.0.0.1",9000);
		System.out.println("等待连接");
		InputStream input =socket.getInputStream();
		byte b [] =  new byte[1024];
		int i = 0;
		while(true) {
			while((i = input.read(b))!=-1) {
				System.out.println(new String(b,0,i));
			}
		}
	}
}
