package com.engineeringdigest.synchronization_7;

public class Test {

	public static void main(String[] args) {
		Counter counter1 = new Counter();
		Counter counter2 = new Counter();
		MyThread t1 = new MyThread(counter1);
		MyThread t2 = new MyThread(counter2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
		}
		System.out.println(counter1.getCount());
		System.out.println(counter2.getCount());
	}
}
