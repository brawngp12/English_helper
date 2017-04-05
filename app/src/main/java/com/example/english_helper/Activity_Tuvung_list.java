package com.example.english_helper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import com.example.english_helper.R.integer;

import android.speech.tts.TextToSpeech;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Tuvung_list extends ActionBarActivity{

	ListView mylistview1;
	Cursor mycurso;
	private EditText inputSearch;
	public TextToSpeech tts;
	Class_myAdapter adt;
	ImageButton btnclear;
	Class_database mydb= new Class_database();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		mylistview1 = (ListView)findViewById(R.id.list_word);
		mycurso = mydb.mydb.rawQuery("Select * FROM word ", null);
		polulatelistviewfromdb();
		mylistview1.setAdapter(adt);
		mylistview1.setOnItemClickListener(onItemClickListener);
		btnclear =(ImageButton)findViewById(R.id.btnclear);
		btnclear.setOnClickListener(SKclear);
		inputSearch = (EditText) findViewById(R.id.inputSearch);
		
		inputSearch.addTextChangedListener(new TextWatcher() {
		@Override
		public void onTextChanged(CharSequence cs, int arg1, int arg2,
				int arg3) {
			mycurso = mydb.mydb.rawQuery("Select * FROM word where sword like '" + cs.toString() + "%'", null);;
			polulatelistviewfromdb();
			mylistview1.setAdapter(adt);
			// When user changed the Text
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1,
				int arg2, int arg3) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
		}
		});
		
	}
	OnClickListener SKclear = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			inputSearch.setText(null);
		}
	};
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(tts!=null){
			tts.stop();
			tts.shutdown();
		}
	}
	void polulatelistviewfromdb()
	{
		startManagingCursor(mycurso);
		String[] fromm = new String[] {"sword","ssummary"};
		int [] too = new int [] {R.id.txtnghe, R.id.nghia};
		adt = new Class_myAdapter(this,R.layout.tuvung_item2, mycurso, fromm,too,1);
		mylistview1.setAdapter(adt);
	}	
	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent a2 = new Intent(Activity_Tuvung_list.this,Activity_Tuvung_item.class);
				a2.putExtra("tuvung",mycurso.getString(1));
				a2.putExtra("phienam",mycurso.getString(2));
				a2.putExtra("nghia1",mycurso.getString(3));
				a2.putExtra("nghia2",mycurso.getString(4));
				startActivity(a2);
	}	
	};

}

