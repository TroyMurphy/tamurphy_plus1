package com.tmurphy.tamurphy_plus1;

import java.util.ArrayList;

public interface CounterArrayInterface {
	//All counters in the array are given a static index on creation
	public void addCounter(Counter newCounter);
	public void removeCounter(int index);
	public void resetCounter(int index);
	public ArrayList<Counter> getCArray();
	public Counter getCounter(int index);
	public void sortArray();
}
	
