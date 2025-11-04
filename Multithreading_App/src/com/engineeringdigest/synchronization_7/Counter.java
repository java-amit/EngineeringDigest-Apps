package com.engineeringdigest.synchronization_7;

public class Counter {

	private int count=0;
//	private String name="";
//	
//	public String getName() {
//		return name;
//	}
//	
//	public Counter(String name) {
//		this.name=name;
//	}
	
	
	//synchronization : intrinsic lock (also called the monitor lock)
	public void increment() {
		synchronized (this) {  //this means current object (counter). Synchronization is intrinsic lock.
			count++;  //critical section
			//System.out.println(Thread.currentThread().getName()+" "+getClass().getName());
		}
	}
	
	public int getCount() {
		return count;
	}
	
}
