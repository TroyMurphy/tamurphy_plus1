package com.tmurphy.tamurphy_plus1;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CounterArrayActivity extends Activity {
	//now this array does not ever need to be passed as it's a forced singleton
	private List<Counter> cArray = CounterArray.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter_array);
		
		//testing function
		populateListView();
		
	}

	public void f_NEWC(View addbutton){
		EditText etTITLE = (EditText)findViewById(R.id.etTITLENAME);
		String title = etTITLE.getText().toString();
		cArray.add(new Counter(title));
		etTITLE.setText("");
		populateListView();
	}
	
	private void populateListView() {
		//Called by OnCreate, On Resume, and on the add counter button
		ArrayAdapter<Counter> cAdapter = new CustomAdapter();
		ListView list = (ListView) findViewById(R.id.lvALLCOUNTERS);
		list.setAdapter(cAdapter);
	}
//Custom List View from http://www.youtube.com/watch?v=WRANgDgM2Zg
	
	private class CustomAdapter extends ArrayAdapter<Counter> {
		public CustomAdapter(){
			super(CounterArrayActivity.this, R.layout.item_counter, cArray);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itemView = convertView;
			if (itemView == null){
				itemView = getLayoutInflater().inflate(R.layout.item_counter, parent, false);
			}
			
			//find the counter to work with
			Counter currentCounter = cArray.get(position);
			//Fill the view
			TextView cTitle = (TextView)itemView.findViewById(R.id.counterTitle);
			cTitle.setText(currentCounter.getName());
			
			TextView cCount = (TextView)itemView.findViewById(R.id.counterCount);
			cCount.setText(currentCounter.getCount().toString());
			
			Button buttonGTC = (Button)itemView.findViewById(R.id.bGTC);
			//tag will later be used to launch the counterpage activity
			buttonGTC.setTag(position);
			
			buttonGTC.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intentSETC = new Intent(CounterArrayActivity.this, CounterPageActivity.class);
					Integer indexpos = (Integer)v.getTag();
					intentSETC.putExtra("index", indexpos);
					startActivity(intentSETC);
					
					//String message = "You clicked position" + v.getTag();
					//Toast.makeText(CounterArrayActivity.this, message, Toast.LENGTH_LONG).show();
				}
			});
			
	
			return itemView;
		}
		
		
		
	}
	
	
	
	
	public void f_GTC(View GTCbutton){
		Toast.makeText(getApplicationContext(), "Making Counter", Toast.LENGTH_LONG).show();
		
		EditText etName = (EditText)findViewById(R.id.bNEWC);
		etName.setText("");
		//String title = etName.getText().toString();
		//Counter newCounter = new Counter(title);
		//cArray.addCounter(newCounter);
		
		//Toast.makeText(getApplicationContext(), cArray.toString(), Toast.LENGTH_LONG).show();
		
		//cArrayAdapter = new CustomAdapter();
	}
	
	//Following derived from stackoverflow.com/questions/8662494/android-baseadapter-and-getlayoutinflater-on=seperate-class-file
	/*public class CustomAdapter extends ArrayAdapter<Counter>{
		public CustomAdapter(){
			super(CounterArrayActivity.this, R.layout.activity_counterbutton, cArray.getCArray());
		}
		@Override
		public View getView(int index, View convertView, ViewGroup parent){
			View newView = convertView;
			//define the view if it doesn't exist
			Counter counterToViewify = cArray.getCounter(index);
			if (convertView == null){
				LayoutInflater layinf = getLayoutInflater();
				newView = layinf.inflate(R.layout.activity_counterbutton, null);
				
				TextView tvTitle = (TextView)findViewById(R.id.counterTitle);
				tvTitle.setText(counterToViewify.getName());				
				
				TextView tvCounter = (TextView)findViewById(R.id.counterCount);
				tvCounter.setText(counterToViewify.getCount().toString());
				
				Button counterbutton = (Button)findViewById(R.id.bGTC);
				counterbutton.setTag(index);
			}
			return newView;
		}
	}
	
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.counter_array, menu);
		return true;
	}

}
