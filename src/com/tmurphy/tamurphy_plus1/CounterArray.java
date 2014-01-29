package com.tmurphy.tamurphy_plus1;

import java.util.ArrayList;

import com.google.gson.Gson;

public class CounterArray extends ArrayList<Counter> {
	//a singleton class of counter array to ensure only one array exists
	//private static final String DATABASE = "carray.save";
	private static CounterArray singletonCArray;
	
	//singleton constructor
	private CounterArray(){}
	
	//singleton getInstance method to create new CounterArray
	public static CounterArray getInstance(){
		if (singletonCArray == null){
			singletonCArray = new CounterArray();
		}
		return singletonCArray;
	}
	
}

