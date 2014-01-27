package com.tmurphy.tamurphy_plus1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class StatsPage extends Activity {

	private List<Counter> cArray = CounterArray.getInstance();
	private Counter pageCounter;
	private Integer index;
	private TextView tvTITLE;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats_page);
		// Show the Up button in the action bar.
		setupActionBar();
		
		index = getIntent().getExtras().getInt("index");
		pageCounter = cArray.get(index);
		
		customizePage(pageCounter);
	}
	
	private void customizePage(Counter c){
		tvTITLE = (TextView)findViewById(R.id.tvSTATSTITLE);
		tvTITLE.setText(c.getName());
	}

	//XML FUNCTIONS HERE
	//=============================
	public void f_HourlyStats(View hourlybutton){
		String msgOut = "Hourly Stats:\n";
		TextView tvoutput = (TextView)findViewById(R.id.tvDISPSTAT);
		tvoutput.setText(msgOut);
	}
	public void f_DailyStats(View hourlybutton){
		String msgOut = "Daily Stats:\n";
		TextView tvoutput = (TextView)findViewById(R.id.tvDISPSTAT);
		tvoutput.setText(msgOut);

	}
	public void f_WeeklyStats(View hourlybutton){
		String msgOut = "Weekly Stats:\n";
		TextView tvoutput = (TextView)findViewById(R.id.tvDISPSTAT);
		tvoutput.setText(msgOut);

	}
	public void f_MonthlyStats(View hourlybutton){
		String msgOut = "Monthly Stats:\n";
		TextView tvoutput = (TextView)findViewById(R.id.tvDISPSTAT);
		tvoutput.setText(msgOut);

	}
	
	
	
	
	 // Set up the {@link android.app.ActionBar}.
	
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stats_page, menu);
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

}
