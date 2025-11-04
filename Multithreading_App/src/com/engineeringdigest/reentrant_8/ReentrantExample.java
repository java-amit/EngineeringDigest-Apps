package com.engineeringdigest.reentrant_8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//reentrant lock can be apply many time: "as many lock those many unlock"
public class ReentrantExample {

	private final Lock lock = new ReentrantLock();
	
	public void outerMethod() {
		lock.lock();
		try {
			System.out.println("Outer method");
			innerMethod();
		} finally {
			lock.unlock();
		}
	}

	public void innerMethod() {
		lock.lock();
		try {
			System.out.println("Inner method");
			innerMethod();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ReentrantExample example = new ReentrantExample();
		example.outerMethod();
	}
}
