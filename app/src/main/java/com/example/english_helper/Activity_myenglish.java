package com.example.english_helper;

import java.text.BreakIterator;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Activity_myenglish extends ActionBarActivity {

	ListView mylistview1;
	Cursor mycurso;
	private EditText inputSearch;
	public TextToSpeech tts;
	Class_myAdapter adt;
	ImageButton btnclear;
	Button btnadd,btnrefresh;
	int id=0,id_update=0;
	Spinner sp;
	Class_database mydb= new Class_database();
	Dialog dlg;
	EditText ed1,ed2;
	
	View view1;
	
	String english = null,vietnamese = null,type = null;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		
		String s = "CREATE TABLE if not exists myenglish (_id int,english nvarchar(500),vietnamese nvarchar(500),type varchar(10))";
		mydb.mydb.execSQL(s);
		mylistview1 = (ListView)findViewById(R.id.list_word);
		mycurso = mydb.mydb.rawQuery("Select * FROM myenglish ORDER BY english ASC ", null);
		if(mycurso.moveToFirst())
		{
			mycurso.moveToLast();
			id=mycurso.getInt(0);
			polulatelistviewfromdb();
			mylistview1.setAdapter(adt);
		}
		
		mylistview1.setOnItemClickListener(onItemClickListener);
		btnclear =(ImageButton)findViewById(R.id.btnclear);
		btnclear.setOnClickListener(SKclear);
		inputSearch = (EditText) findViewById(R.id.inputSearch);
	
		inputSearch.addTextChangedListener(new TextWatcher() {
		@Override
		public void onTextChanged(CharSequence cs, int arg1, int arg2,
				int arg3) {
			mycurso = mydb.mydb.rawQuery("Select * FROM myenglish where english like ORDER BY english ASC '" + cs.toString() + "%'", null);;
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
		String[] fromm = new String[] {};
		int [] too = new int [] {};
		adt = new Class_myAdapter(this,R.layout.tuvung_item2, mycurso, fromm,too,3);
		mylistview1.setAdapter(adt);
	}
	int ii=0;
	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				id_update=mycurso.getInt(0);
				vietnamese = mycurso.getString(2);
				english = mycurso.getString(1);
				ii=position;
				update();
	}	
	};
	
	public void update(){
		dlg = new Dialog(this);
		dlg.setContentView(R.layout.myenglish_add);
		dlg.setTitle("Delete - Update");
		dlg.show();
		btnadd = (Button)dlg.findViewById(R.id.btnadd);
		btnadd.setText("UPDATE");
		btnadd.setEnabled(false);
		btnrefresh= (Button)dlg.findViewById(R.id.btnrefresh);
		btnrefresh.setText("DELETE");
		btnadd.setOnClickListener(XLSK2);
		btnrefresh.setOnClickListener(XLSK2);
		ed1=(EditText)dlg.findViewById(R.id.editText1);
		ed2=(EditText)dlg.findViewById(R.id.editText2);
		sp=(Spinner)dlg.findViewById(R.id.spinner1);
		ed1.addTextChangedListener(textchange);
		ed2.addTextChangedListener(textchange);
		ed1.setText(mycurso.getString(1));
		ed2.setText(mycurso.getString(2));
		
	}
	OnClickListener XLSK2 = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v==btnadd)
			{
				int ch=34;
				english = ed1.getText().toString();
				vietnamese=ed2.getText().toString();
				type=sp.getSelectedItem().toString();	
				String s = "Update myenglish Set " +
						"_id = " + (char)ch+ id_update + (char)ch  + "," +
						"english="+ (char)ch +english + (char)ch  + "," +
						"vietnamese="+(char)ch+ vietnamese + (char)ch +","+
						"type = " +  (char)ch + type + (char)ch +
						"Where (_id = "+ id_update +")";
				mydb.mydb.execSQL(s);
			}
			else{
				String s = "Delete from myenglish " +
						"where _id ="+ id_update;
				mydb.mydb.execSQL(s);
			}
			mycurso = mydb.mydb.rawQuery("Select * FROM myenglish ORDER BY english ASC ", null);
			polulatelistviewfromdb();
			mylistview1.setSelection(ii);
			dlg.cancel();
		}
	};

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Add");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		ADD();
		return super.onOptionsItemSelected(item);
	}
	public void ADD(){
		dlg = new Dialog(this);
		dlg.setContentView(R.layout.myenglish_add);
		dlg.setTitle("Add");
		dlg.show();
		btnadd = (Button)dlg.findViewById(R.id.btnadd);
		btnadd.setEnabled(false);
		btnrefresh= (Button)dlg.findViewById(R.id.btnrefresh);
		btnadd.setOnClickListener(XLSK1);
		btnrefresh.setOnClickListener(XLSK1);
		ed1=(EditText)dlg.findViewById(R.id.editText1);
		ed2=(EditText)dlg.findViewById(R.id.editText2);
		sp=(Spinner)dlg.findViewById(R.id.spinner1);
		ed1.addTextChangedListener(textchange);
		ed2.addTextChangedListener(textchange);
	}
	

	TextWatcher textchange = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub		
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			if(ed1.getText().length()>0 && ed2.getText().length()>0){
				btnadd.setEnabled(true);
			}
			else{
				btnadd.setEnabled(false);
			}
		}
	};
	
	OnClickListener XLSK1 = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v==btnadd)
			{
				int ch=34;
				id++;
				english = ed1.getText().toString();
				vietnamese=ed2.getText().toString();
				type=sp.getSelectedItem().toString();	
				String s = "INSERT INTO myenglish(_id,english,vietnamese,type) VALUES" +
						" (" +id+","+(char)ch+english + (char)ch +"," +
						(char)ch+vietnamese + (char)ch +","+ (char)ch + type + (char)ch +")";
				mydb.mydb.execSQL(s);
				mycurso = mydb.mydb.rawQuery("Select * FROM myenglish ORDER BY english ASC", null);
				polulatelistviewfromdb();
				mylistview1.setSelection(id);
			}
			ed1.setText(null);
			ed2.setText(null);
				
			
		}
	};

	
}
