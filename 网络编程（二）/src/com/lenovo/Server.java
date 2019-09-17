package com.lenovo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	static List<Socket> list = new ArrayList<Socket>();
	public static void main(String[] args) throws Exception {
		@SuppressWarnings({ "unused", "resource" })
		ServerSocket server = new ServerSocket(9000);
		
		WriterThread wt = new WriterThread();
		wt.start();
		
		
		while(true) {
			@SuppressWarnings("unused")
			Socket socket = server.accept();
			list.add(socket);
			System.out.println("连接成功："+socket);
			
		}
	}
	public static void show(String line) {
		if(list!=null) {
			for (Socket socket : list) {
				OutputStream os;
				try {
					os = socket.getOutputStream();
					os.write(line.getBytes());
					os.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		}
	}
	

}
