package com.engineeringdigest.threadstate;

public class Test {
	public static void main(String[] args) {
		
		World world = new World(); 
		Thread thread = new Thread(world); //NEW
		thread.start();	//RUNNABLE
		
		for(int i=0; i<=10; i++) {
			System.out.println("Hello "+Thread.currentThread().getName());
		}
	}
}
