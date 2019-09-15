package com.baidu;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

public class Demo {
	static SynchronousQueue<String> abq = new SynchronousQueue<String>();
	//static LinkedBlockingDeque<String> abq = new LinkedBlockingDeque<String>(3);
	//static ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(1);
	public static void main(String[] args) {
		Input input = new Input();
		Output output = new Output();
		input.start();
		output.start();
	}

}
