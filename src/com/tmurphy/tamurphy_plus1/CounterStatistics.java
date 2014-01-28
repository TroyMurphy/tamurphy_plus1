package com.tmurphy.tamurphy_plus1;

import java.util.Calendar;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class CounterStatistics extends Activity {
	
	private List<Counter> cArray = CounterArray.getInstance();
	private Counter pageCounter;
	private Integer index;
	private TextView tvTITLE;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter_statistics);
		// Show the Up button in the action bar.
		setupActionBar();
		index = getIntent().getExtras().getInt("index");
		pageCounter = cArray.get(index);
		
		customizePage(pageCounter);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.counter_statistics, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	private void customizePage(Counter c){
		tvTITLE = (TextView)findViewById(R.id.tvSTATSTITLE);
		tvTITLE.setText(c.getName());
	}

	//XML FUNCTIONS HERE
	//=============================
	public void f_HourlyStats(View hourlybutton){
		
		String msgOut = "Hourly Stats\n";
		Integer dateIndex = 0;
		Integer dateCount = 1;
		Calendar cal1, cal2;
		
		//Toast.makeText(StatsPage.this, msgOut, Toast.LENGTH_LONG).show();
		while (dateIndex+1 < pageCounter.getCount()){
			cal1 = pageCounter.getDate(dateIndex);
			msgOut += pageCounter.getDateString(dateIndex, true, false, true, true) + " -- ";
			dateIndex++;
			cal2 = pageCounter.getDate(dateIndex);
			while(dateIndex+1 < pageCounter.getCount() && cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR)==cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.HOUR_OF_DAY) ==cal2.get(Calendar.HOUR_OF_DAY)){
				dateCount++;
				dateIndex++;
				cal2=pageCounter.getDate(dateIndex);
			}
			if(dateIndex+1 == pageCounter.getCount()){
				cal2 = pageCounter.getDate(dateIndex);
				if(cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR)==cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.HOUR_OF_DAY) ==cal2.get(Calendar.HOUR_OF_DAY)){
					dateCount++;
					msgOut += dateCount + "\n";
				}
				else{
					msgOut += pageCounter.getDateString(dateIndex, true, false, true, true) + " -- 1\n";	
				}
				
			}
			else {
				msgOut += dateCount + "\n";
			}
		}
		
		TextView tvoutput = (TextView)findViewById(R.id.tvDISPSTAT);
		tvoutput.setText(msgOut);
		
	}
	public void f_DailyStats(View hourlybutton){
		
		String msgOut = "Daily Stats\n";
		Integer dateIndex = 0;
		Integer dateCount = 1;
		Calendar cal1, cal2;
		
		//Toast.makeText(StatsPage.this, msgOut, Toast.LENGTH_LONG).show();
		while (dateIndex+1 < pageCounter.getCount()){
			cal1 = pageCounter.getDate(dateIndex);
			msgOut += pageCounter.getDateString(dateIndex, true, false, true, false) + " -- ";
			dateIndex++;
			cal2 = pageCounter.getDate(dateIndex);
			while(dateIndex+1 < pageCounter.getCount() && cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR)==cal2.get(Calendar.DAY_OF_YEAR)){
				dateCount++;
				dateIndex++;
				cal2=pageCounter.getDate(dateIndex);
			}
			if(dateIndex+1 == pageCounter.getCount()){
				cal2 = pageCounter.getDate(dateIndex);
				if(cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR)==cal2.get(Calendar.DAY_OF_YEAR)){
					dateCount++;
					msgOut += dateCount + "\n";
				}
				else{
					msgOut += pageCounter.getDateString(dateIndex, true, false, true, false) + " -- 1\n";	
				}
				
			}
			else {
				msgOut += dateCount + "\n";
			}
		}
		
		TextView tvoutput = (TextView)findViewById(R.id.tvDISPSTAT);
		tvoutput.setText(msgOut);

	}
	public void f_WeeklyStats(View hourlybutton){
		
		String msgOut = "Weekly Stats\n";
		Integer dateIndex = 0;
		Integer dateCount = 1;
		Calendar cal1, cal2;
		
		//Toast.makeText(StatsPage.this, msgOut, Toast.LENGTH_LONG).show();
		while (dateIndex+1 < pageCounter.getCount()){
			cal1 = pageCounter.getDate(dateIndex);
			msgOut += pageCounter.getDateString(dateIndex, true, true, true, false) + " -- ";
			dateIndex++;
			cal2 = pageCounter.getDate(dateIndex);
			while(dateIndex+1 < pageCounter.getCount() && cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.WEEK_OF_YEAR)==cal2.get(Calendar.WEEK_OF_YEAR)){
				dateCount++;
				dateIndex++;
				cal2=pageCounter.getDate(dateIndex);
			}
			if(dateIndex+1 == pageCounter.getCount()){
				cal2 = pageCounter.getDate(dateIndex);
				if(cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR)==cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.WEEK_OF_YEAR) ==cal2.get(Calendar.WEEK_OF_YEAR)){
					dateCount++;
					msgOut += dateCount + "\n";
				}
				else{
					msgOut += pageCounter.getDateString(dateIndex, true, true, true, false) + " -- 1\n";	
				}
				
			}
			else {
				msgOut += dateCount + "\n";
			}
		}
		
		TextView tvoutput = (TextView)findViewById(R.id.tvDISPSTAT);
		tvoutput.setText(msgOut);

	}
	public void f_MonthlyStats(View hourlybutton){
		
		String msgOut = "Monthly Stats\n";
		Integer dateIndex = 0;
		Integer dateCount = 1;
		Calendar cal1, cal2;
		
		//Toast.makeText(StatsPage.this, msgOut, Toast.LENGTH_LONG).show();
		while (dateIndex+1 < pageCounter.getCount()){
			cal1 = pageCounter.getDate(dateIndex);
			msgOut += pageCounter.getDateString(dateIndex, true, false, false, false) + " -- ";
			dateIndex++;
			cal2 = pageCounter.getDate(dateIndex);
			while(dateIndex+1 < pageCounter.getCount() && cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR)==cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.HOUR_OF_DAY) ==cal2.get(Calendar.HOUR_OF_DAY)){
				dateCount++;
				dateIndex++;
				cal2=pageCounter.getDate(dateIndex);
			}
			if(dateIndex+1 == pageCounter.getCount()){
				cal2 = pageCounter.getDate(dateIndex);
				if(cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH) && cal1.get(Calendar.HOUR_OF_DAY) ==cal2.get(Calendar.HOUR_OF_DAY)){
					dateCount++;
					msgOut += dateCount + "\n";
				}
				else{
					msgOut += pageCounter.getDateString(dateIndex, true, false, false, false) + " -- 1\n";	
				}
			}
			else {
				msgOut += dateCount + "\n";
			}
		}
		
		TextView tvoutput = (TextView)findViewById(R.id.tvDISPSTAT);
		tvoutput.setText(msgOut);

	}

}
