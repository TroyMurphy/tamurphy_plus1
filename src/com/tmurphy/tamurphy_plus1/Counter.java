package com.tmurphy.tamurphy_plus1;


//import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.annotation.SuppressLint;

public class Counter{

	//private static final long serialVersionUID = 1L;
	
	private String name;
	private ArrayList<Calendar> datelist;
	private Integer count;
	
	public Counter(String name, ArrayList<Calendar> datelist){
		super();
		this.name = name;
		this.datelist = datelist;
		this.count = 0;
	}
	public Counter(String name){
		super();
		this.name = name;
		this.datelist = new ArrayList<Calendar>();
		this.count = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Calendar> getDatelist() {
		return datelist;
	}
	public void setDatelist(ArrayList<Calendar> datelist) {
		this.datelist = datelist;
		this.refreshCount();
	}
	public void clearDateList(){
		this.datelist= new ArrayList<Calendar>();
		this.refreshCount();
	}
	public Calendar getDate(int index){
		return this.datelist.get(index);
	}
	
	@SuppressLint("SimpleDateFormat")
	public String getDateString(int index, boolean month,boolean week, boolean date, boolean hour){
		SimpleDateFormat sdf;
		if(hour){
			sdf = new SimpleDateFormat("yyyy MMM dd HH':00'");
		}
		else if(week){
			sdf = new SimpleDateFormat("yyyy MMM' Week 'W");
		}
		else if(date){
			sdf = new SimpleDateFormat("yyyy MMM dd");			
		}
		else{
			sdf = new SimpleDateFormat("yyyy MMM");			
		}
		return sdf.format(getDate(index).getTime());
	}
	
	public void addDate(Calendar newdate){
		this.datelist.add(newdate);
		this.refreshCount();
	}
	public void refreshCount(){
		this.count = datelist.size();
	}
	public String getCountAsString(){
		return count.toString();
	}
	public Integer getCount() {
		this.refreshCount();
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
}
