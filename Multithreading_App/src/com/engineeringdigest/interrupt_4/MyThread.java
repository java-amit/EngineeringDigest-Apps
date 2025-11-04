package com.engineeringdigest.interrupt_4;

public class MyThread extends Thread{
	

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Thread is running");
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted: "+e);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		t1.start();
		t1.interrupt();
		
	}

}
