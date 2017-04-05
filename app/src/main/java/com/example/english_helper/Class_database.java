package com.example.english_helper;

import java.io.File;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class Class_database {
	
	public static final String  DATABASE_FILE_PATH = "/sdcard";
    public static final String  DATABASE_NAME = "lesson.sqlite";
    SQLiteDatabase mydb = SQLiteDatabase.openOrCreateDatabase
    		(DATABASE_FILE_PATH + File.separator + DATABASE_NAME, null);
}
