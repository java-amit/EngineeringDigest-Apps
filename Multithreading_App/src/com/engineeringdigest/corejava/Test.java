package com.engineeringdigest.corejava;

public class Test {
	public static void main(String[] args) {
		
		World world = new World();
		world.start();
		
		for(int i=0; i<=10; i++) {
			System.out.println("Hello "+Thread.currentThread().getName());
		}
	}
}
