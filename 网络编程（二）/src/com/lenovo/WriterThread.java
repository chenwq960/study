package com.lenovo;

import java.util.Scanner;

public class WriterThread extends Thread{
	public void run() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.next();
			Server.show(line);
		}
		
	}
}
