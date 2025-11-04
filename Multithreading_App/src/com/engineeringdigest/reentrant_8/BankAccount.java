package com.engineeringdigest.reentrant_8;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

	private int balance=100;
	private final Lock lock = new ReentrantLock(); //ReentrantLock class implementing Lock interface.
	
	public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() +" attending to withdraw "+amount);
		try {
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				if(balance>=amount) {
					try {
						System.out.println(Thread.currentThread().getName() +" procedding with withdraw");
						Thread.sleep(10000);
						balance=balance-amount;
						System.out.println(Thread.currentThread().getName() +" completed withdraw. Remainning balance: "+balance);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					finally {
						lock.unlock();
					}
				}
				else {
					System.out.println(Thread.currentThread().getName() +" insuffficient balance");
				}
			}
			else {
				System.out.println(Thread.currentThread().getName() +" could not acquire the lock, will try later");
				
			}
		}
		catch (Exception e) {
			Thread.currentThread().interrupt();
		}
		if(Thread.currentThread().isInterrupted()) {
			System.out.println("--");
		}
	}
}
