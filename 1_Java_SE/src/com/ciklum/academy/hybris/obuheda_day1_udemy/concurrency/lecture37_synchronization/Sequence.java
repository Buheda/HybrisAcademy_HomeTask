package com.ciklum.academy.hybris.obuheda_day1_udemy.concurrency.lecture37_synchronization;

public class Sequence {
	private  int value = 0;
	
	public synchronized int getNext() {
		return ++value;
	}
}
