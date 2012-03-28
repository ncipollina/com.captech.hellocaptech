package com.captech.hellocaptech;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class HelloDataSource {
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = {MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_HELLO};
	private static final String LOG_STATEMENT = "INSERT INTO " + MySQLiteHelper.TABLE_HELLO
			+ " VALUES(null, %d)";
	
	public HelloDataSource(Context context){
		dbHelper = new MySQLiteHelper(context);
	}
	
	public void open() throws SQLException{
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public void logStart(){
		database.execSQL(String.format(LOG_STATEMENT, new Date().getTime()));
	}
	
	public List<Long> getAllTimes(){
		List<Long> times = new ArrayList<Long>();
		
		Cursor cursor = database.query(MySQLiteHelper.TABLE_HELLO, allColumns,
				null, null, null, null, MySQLiteHelper.COLUMN_HELLO);
		cursor.moveToFirst();
		
		while(!cursor.isAfterLast()){
			times.add(cursor.getLong(1));
			cursor.moveToNext();
		}
		
		return times;
	}
}
