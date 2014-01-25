package com.tmurphy.tamurphy_plus1;

import java.util.ArrayList;

public class CounterArray implements CounterArrayInterface {
	//a singleton class of counter array to ensure only one array exists
	private static CounterArray singletonCArray;
	private static final String DATABASE = "plus1.save";
	private ArrayList<Counter> allCounters;
	
	//singleton constructor
	private CounterArray(){}
	
	//singleton getInstance method to create new CounterArray
	public static CounterArray getInstance(){
		if (singletonCArray == null){
			singletonCArray = new CounterArray();
		}
		return singletonCArray;
	}
	
	@Override
	public void addCounter(Counter newCounter) {
		// TODO Auto-generated method stub
		this.allCounters.add(newCounter);
	}

	@Override
	public void removeCounter(int index) {
		// TODO Auto-generated method stub
		this.allCounters.remove(index);
	}

	@Override
	public void resetCounter(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Counter> getCArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Counter getCounter(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sortArray() {
		// TODO Auto-generated method stub

	}

	public void saveToFiles(){
		// TODO implement save method
	}
}
