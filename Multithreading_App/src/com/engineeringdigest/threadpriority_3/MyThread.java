package com.engineeringdigest.threadpriority_3;

public class MyThread extends Thread{
	
	
	
	public MyThread(String string) {
		super(string);
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName()+" - Priority: "+Thread.currentThread().getPriority()+"- count"+i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread l = new MyThread("Low Priority Thread");
		MyThread m = new MyThread("Medium Priority Thread");
		MyThread h = new MyThread("High Priority Thread");
		l.setPriority(Thread.MIN_PRIORITY);  //Any priority thread can be executed first (priority se koi lena dena nhi hota)
		m.setPriority(Thread.NORM_PRIORITY);
		h.setPriority(Thread.MAX_PRIORITY);
		l.start();
		m.start();
		h.start();
		
	}

}
