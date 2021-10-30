package com.udemy.ciklum.concurrency.lecture37_synchronization;

public class Sequence {
	private  int value = 0;
	
	public synchronized int getNext() {
		return ++value;
	}
}
