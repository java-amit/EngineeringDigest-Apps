package com.engineeringdigest.corejava;

public class World extends Thread{
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println("world ! "+Thread.currentThread().getName());
		}
		
	}
	

}
