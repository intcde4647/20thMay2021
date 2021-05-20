package com.cts.demos;

public class ThreadDemo1 {

	public static void main(String[] args) {
		
		//MyThread mt=new MyThread();
        //Thread thread=new Thread(mt);
        Thread newThread=new Thread(new MyThread());
        
        
        newThread.start();
	}

}
