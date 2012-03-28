package com.captech.hellocaptech;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	public static final String TABLE_HELLO = "Hellos";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_HELLO = "hello_time";
	
	private static final String DATABASE_NAME = "HelloCapTech.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_HELLO + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_HELLO
			+ " integer not null);";
	
	public MySQLiteHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
