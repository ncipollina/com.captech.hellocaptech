package com.captech.hellocaptech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloCapTechActivity extends Activity {
	private HelloDataSource dataSource;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        dataSource = new HelloDataSource(this);
        dataSource.open();
        dataSource.logStart();
        dataSource.close();
        
        Button btnViewList = (Button)findViewById(R.id.btnView);
        btnViewList.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),TimeActivity.class);
				startActivityForResult(intent,0);
			}
        	
        });
    }
    
}