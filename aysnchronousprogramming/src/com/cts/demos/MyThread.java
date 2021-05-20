package com.cts.demos;
// Runnable is the Functional Interface as it is having only one abstract method run.

public class MyThread implements Runnable {

	@Override
	public void run() {
		for(int i=1;i<=5;i++)
			{
				System.out.println(i);
			}

	}

	
		
	

}
