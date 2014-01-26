package com.tmurphy.tamurphy_plus1;


//import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Counter{

	//private static final long serialVersionUID = 1L;
	
	private String name;
	private ArrayList<Date> datelist;
	private Integer count;
	
	public Counter(String name, ArrayList<Date> datelist){
		super();
		this.name = name;
		this.datelist = datelist;
		this.count = 0;
	}
	public Counter(String name){
		super();
		this.name = name;
		this.datelist = new ArrayList<Date>();
		this.count = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Date> getDatelist() {
		return datelist;
	}
	public void setDatelist(ArrayList<Date> datelist) {
		this.datelist = datelist;
	}
	public void addDate(Date newdate){
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
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
