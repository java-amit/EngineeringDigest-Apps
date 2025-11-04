package com.engineeringdigest.unfairlock_9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//UnfairLock : may be any thread not get chance to run
public class UnfairLockExample {

	private final Lock unfairLock = new ReentrantLock();
	
	public void accessResources() {
		unfairLock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+" acquired the lock.");
			Thread.sleep(1000);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
		finally {
			System.out.println(Thread.currentThread().getName()+" released the lock.");
			unfairLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		UnfairLockExample example = new UnfairLockExample();
		
		Runnable task = new Runnable() {
			@Override
			public void run() {
				example.accessResources();
			}
		};
		
		Thread thread1 = new Thread(task, "Thread 1");
		Thread thread2 = new Thread(task, "Thread 2");
		Thread thread3 = new Thread(task, "Thread 3");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
