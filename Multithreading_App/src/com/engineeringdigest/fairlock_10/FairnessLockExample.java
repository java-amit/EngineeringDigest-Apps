package com.engineeringdigest.fairlock_10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//fairLock : all thread get chance to run
public class FairnessLockExample {

	private final Lock fairLock = new ReentrantLock(true);
	
	public void accessResources() {
		fairLock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+" acquired the lock.");
			Thread.sleep(1000);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
		finally {
			System.out.println(Thread.currentThread().getName()+" released the lock.");
			fairLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		FairnessLockExample example = new FairnessLockExample();
		
		Runnable task = new Runnable() {
			@Override
			public void run() {
				example.accessResources();
			}
		};
		
		Thread thread1 = new Thread(task, "Thread 1");
		Thread thread2 = new Thread(task, "Thread 2");
		Thread thread3 = new Thread(task, "Thread 3");
		
		try {
			thread1.start();
			Thread.sleep(50);
			thread2.start();
			Thread.sleep(50);
			thread3.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
