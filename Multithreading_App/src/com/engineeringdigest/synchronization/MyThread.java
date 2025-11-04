package com.engineeringdigest.synchronization;


public class MyThread extends Thread{
	
	private Counter counter;  //instance variable with constructor approach
	
	public MyThread(Counter counter) {
		this.counter=counter;
	}
	
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			counter.increment();
		}
	}
	
	

}
