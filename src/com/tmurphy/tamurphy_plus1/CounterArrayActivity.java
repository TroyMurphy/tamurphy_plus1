package com.tmurphy.tamurphy_plus1;

import java.util.Collections;
import java.util.Comparator;
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

public class CounterArrayActivity extends Activity {
	//now this array does not ever need to be passed as it's a forced singleton
	private List<Counter> cArray = CounterArray.getInstance();
	private ArrayAdapter<Counter> cAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter_array);
		
		//testing function
		populateListView();
		
	}
	@Override
	protected void onResume(){
		super.onResume();
		sortCArray();
		populateListView();
	}

	public void sortCArray() {
		Collections.sort(cArray, new Comparator<Counter>(){
			public int compare(Counter c1, Counter c2) {
				return c2.getCount().compareTo(c1.getCount());
			}
		});
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
		cAdapter = new CustomAdapter();
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
					intentSETC.putExtra("index", indexpos) ;
					startActivity(intentSETC);
					
					//String message = "You clicked position" + v.getTag();
					//Toast.makeText(CounterArrayActivity.this, message, Toast.LENGTH_LONG).show();
				}
			});
			
	
			return itemView;
		}		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.counter_array, menu);
		return true;
	}

}
