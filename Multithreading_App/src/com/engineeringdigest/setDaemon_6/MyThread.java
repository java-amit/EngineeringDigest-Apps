package com.engineeringdigest.setDaemon_6;
/* 
 Daemon Thread: Run in background and jvm not wait for complete.
*/

public class MyThread extends Thread{
	
	@Override
	public void run() {
		while(true) { //infinite loop
			System.out.println("Hello World !");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		t1.setDaemon(true);
		t1.start();
		System.out.println("Main done");
	}

}
