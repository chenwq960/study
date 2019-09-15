package com.baidu;

public class Input extends Thread{
	static int num = 1;
	String mes = "Good";
	public void run() {
		while(true) {
			try {
				Demo.abq.put(mes+num+"");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(mes+"\t"+num+"-----------------------");
		}
	}

}
