package com.captech.hellocaptech;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Toast;


public class TimeActivity extends ListActivity {
	private HelloDataSource dataSource;
	DateFormat format = DateFormat.getDateTimeInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new ArrayList<String>());
		setListAdapter(adapter);

		new AddTimes().execute();
		
		Button btnReturn = (Button)findViewById(R.id.btnReturn);
		btnReturn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				setResult(Activity.RESULT_OK);
				finish();
			}
			
		});
	}
	
	class AddTimes extends AsyncTask<Void,String,Void>{

		@Override
		protected Void doInBackground(Void... arg0) {
			dataSource = new HelloDataSource(TimeActivity.this);
			dataSource.open();
			
			List<Long> times = dataSource.getAllTimes();
			
			for(Long time : times){
				publishProgress(format.format(time));
			}
			dataSource.close();
			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			((ArrayAdapter)getListAdapter()).add(values[0]);
		}
	}

}
