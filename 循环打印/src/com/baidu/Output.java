package com.baidu;

public class Output extends Thread{
	String mes = null;
	public void run() {
		while(true) {
			try {
				mes = Demo.abq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("-----------------"+mes);
			
			
		}
	}
	

}
