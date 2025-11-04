package com.engineeringdigest.threadstate_2;

public class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("RuNNIng");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("sopln "+e);
			e.printStackTrace();
		}
		System.out.println("normal execution RuNNIng");
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();  //NEW
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());  //RUNNABLE
		Thread.sleep(100);	
		System.out.println(t1.getState());	//TIMED_WAITING
		t1.join(1000);;;;  //main thread wait for th1 will execute and  then fully th1 terminated
		System.out.println(t1.getState());  //TERMINATED
	}

}
