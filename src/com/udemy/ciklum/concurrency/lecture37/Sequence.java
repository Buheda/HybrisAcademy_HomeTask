package com.udemy.ciklum.concurrency.lecture37;

public class Sequence {
	private  int value = 0;
	
	public synchronized int getNext() {
		return ++value;
	}
}
