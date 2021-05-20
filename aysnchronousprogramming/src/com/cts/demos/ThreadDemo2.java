package com.cts.demos;


// Functional Interface and Lambda expression

public class ThreadDemo2 {

	public static void main(String[] args) {
		Thread newThread = new Thread(() -> {
		      
			for(int i=1;i<=5;i++)
			{
				System.out.println(i);
			}
				
		}	
				);
		newThread.start();

	}

}
