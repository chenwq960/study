
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Father{
	String name;
	String sex;
	
	Lock lock = new ReentrantLock();
	Condition con = lock.newCondition();
	Boolean flag = false;
	public void input(String name,String sex) {
		lock.lock();
		if(flag)
			try {this.con.await();} catch (InterruptedException e) {e.printStackTrace();}
		this.name = name;
		this.sex = sex;
		
		flag = true;
		this.con.signal();
		lock.unlock();
	}
	public void output() {
		lock.lock();
		if(!flag)
		try {this.con.await();} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println(name+"\t\t"+sex);
		flag = false;
		this.con.signal();
		lock.unlock();
	}
	
}

class Input implements Runnable{
	Father f;
	public Input(Father f) {
		this.f = f;
	}
	Boolean flag = true;
	public void run() {
		while(true) {
			if(flag) {
				f.input("陈文庆","男");
				flag = !flag;
			}else {
				f.input("make", "women");
				flag = !flag;
			}
		}
			
		
	}
}

class Output implements Runnable{
	Father f;
	public Output(Father f) {
		this.f = f;
	}
	public void run() {
		while(true) {
			f.output();
		}
		
	}
}

public class Demo { 
	
	public static void main(String[] args) {
		Father f = new Father();
		Thread thre = new Thread(new Output(f));
		Thread thread = new Thread(new Input(f));
		thre.start();
		thread.start();
		
	}

}
