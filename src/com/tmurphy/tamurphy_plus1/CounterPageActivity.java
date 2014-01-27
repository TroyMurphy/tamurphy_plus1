package com.tmurphy.tamurphy_plus1;

import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CounterPageActivity extends Activity {
	//safe because of the singleton class instantiation
	private List<Counter> cArray = CounterArray.getInstance();
	private Counter pageCounter;
	private Button plusOne;
	private Integer index;
	private TextView tvTITLE;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter_page);
		// Show the Up button in the action bar.
		setupActionBar();
		
		index = getIntent().getExtras().getInt("index");
		pageCounter = cArray.get(index);
		
		customizePage(pageCounter);
	}

	public void customizePage(Counter c){
		plusOne = (Button)findViewById(R.id.bplusOne);
		tvTITLE = (TextView)findViewById(R.id.tvCTITLE);
		//set the attributes
		tvTITLE.setText(c.getName());
		plusOne.setText(c.getCountAsString());	
	}
	//BUTTON FUNCTIONS CALLED FROM XML onClick
	//==========================================
	public void f_RESET(View resetButton){
		pageCounter.clearDateList();
		plusOne.setText(pageCounter.getCountAsString());
	}
	public void f_RENAME(View renameButton){
		AlertDialog renameCounter = this.renameAlertDialog();
		renameCounter.show();
	}
	
	private AlertDialog renameAlertDialog(){
		AlertDialog.Builder adb = new AlertDialog.Builder(CounterPageActivity.this);
		LayoutInflater inflater = CounterPageActivity.this.getLayoutInflater();
		adb.setView(inflater.inflate(R.layout.rename_dialog, null))
			.setNeutralButton("Cancel", null)
			.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				EditText dialogText = (EditText) ((AlertDialog) dialog).findViewById(R.id.etRENAME);
				String newtitle = dialogText.getText().toString();
				pageCounter.setName(newtitle);
				TextView titleName = (TextView)findViewById(R.id.tvCTITLE);
				titleName.setText(pageCounter.getName());
			}
		});
		return adb.create();
	}

	public void f_DELETE(View deleteButton){
		cArray.remove(pageCounter);
		finish();
		//finish should back up, but not quit the app
	}
	public void f_STATS(View statsButton){
		//start the intent
		//Toast.makeText(CounterPageActivity.this, "Clicked Stats", Toast.LENGTH_LONG).show();
		Intent intSTAT = new Intent(CounterPageActivity.this, StatsPage.class);
		intSTAT.putExtra("counterind", index);
		startActivity(intSTAT);
		
	}
	public void f_PLUSONE(View plusButton){
		pageCounter.addDate(new Date());
		//self refreshes count
		plusOne.setText(pageCounter.getCountAsString());
	}
	
	 // Set up the {@link android.app.ActionBar}.
	
	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.counter_page, menu);
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
