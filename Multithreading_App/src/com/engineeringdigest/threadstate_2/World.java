package com.engineeringdigest.threadstate_2;

public class World implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println("world ! "+Thread.currentThread().getName());
		}
		
	}
	

}
