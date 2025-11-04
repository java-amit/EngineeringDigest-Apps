package com.engineeringdigest.leave_useof_processor_yield_5;


public class MyThread extends Thread{
	
	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName() +" is RunninG");
			Thread.yield(); //Hint to thread scheduler that running thread want to give chance to other thread.
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		t1.start();
		t2.start();
		
	}

}
