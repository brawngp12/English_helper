package com.example.english_helper;

import android.app.Dialog;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Spinner;

public class Activity_Cau_list extends ActionBarActivity {

	ListView mylistview1;
	Cursor mycurso;
	private EditText inputSearch;
	public TextToSpeech tts;
	Class_myAdapter adt;
	ImageButton btnclear;
	Class_database mydb= new Class_database();
	//private dem inputdem;


//	//them cau
//	Dialog dlg;
//	Button btnadd1,btnrefresh;
//	int id=0;
//	String english = null,vietnamese = null;
//	EditText ed1,ed2;
//	Spinner sp;
//	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		mylistview1 = (ListView)findViewById(R.id.list_word);
		mycurso = mydb.mydb.rawQuery("Select _id,english,tag,catalog,vietnamese FROM phrases ", null);
		polulatelistviewfromdb();
		mylistview1.setAdapter(adt);
		//mylistview1.setOnItemClickListener(onItemClickListener);
		btnclear =(ImageButton)findViewById(R.id.btnclear);
		btnclear.setOnClickListener(SKclear);
		inputSearch = (EditText) findViewById(R.id.inputSearch);
		
		inputSearch.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2,
									  int arg3) {
				mycurso = mydb.mydb.rawQuery("Select _id,english,tag,catalog,vietnamese FROM phrases where english like '" + cs.toString() + "%'", null);
				;
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
		String[] fromm = new String[] {"english","vietnamese"};
		int [] too = new int [] {R.id.txtnghe, R.id.nghia};
		adt = new Class_myAdapter(this,R.layout.tuvung_item2, mycurso, fromm,too,1);
		mylistview1.setAdapter(adt);
	}

/*	public void ADD(){
//		dlg = new Dialog(this);
//		dlg.setContentView(R.layout.cau_add);
//		dlg.setTitle("Add");
//		dlg.show();
//		btnadd1 = (Button)dlg.findViewById(R.id.btnadd1);
//		btnadd1.setEnabled(false);
//		btnrefresh= (Button)dlg.findViewById(R.id.btnrefresh);
//		btnadd1.setOnClickListener(XLSK1);
//		btnrefresh.setOnClickListener(XLSK1);
//		ed1=(EditText)dlg.findViewById(R.id.editText1);
//		ed2=(EditText)dlg.findViewById(R.id.editText2);
//		sp=(Spinner)dlg.findViewById(R.id.spinner1);
//		ed1.addTextChangedListener(textchange);
//		ed2.addTextChangedListener(textchange);
//	}
//
//	TextWatcher textchange = new TextWatcher() {
//
//		@Override
//		public void onTextChanged(CharSequence s, int start, int before, int count) {
//			// TODO Auto-generated method stub
//		}
//
//		@Override
//		public void beforeTextChanged(CharSequence s, int start, int count,
//									  int after) {
//			// TODO Auto-generated method stub
//
//		}
//
//		@Override
//		public void afterTextChanged(Editable s) {
//			// TODO Auto-generated method stub
//			if(ed1.getText().length()>0 && ed2.getText().length()>0){
//				btnadd1.setEnabled(true);
//			}
//			else{
//				btnadd1.setEnabled(false);
//			}
//		}
//	};
//	OnClickListener XLSK1 = new OnClickListener() {
//
//		@Override
//		public void onClick(View v) {
//			if(v==btnadd1)
//			{
//				int ch=34;
//				id++;
//				english = ed1.getText().toString();
//				vietnamese=ed2.getText().toString();
//				String s = "INSERT INTO phrases(_id,english,vietnamese) VALUES" +
//						" (" +id+","+(char)ch+english + (char)ch +"," +
//						(char)ch+vietnamese + (char)ch +","+ (char)ch +")";
//				mydb.mydb.execSQL(s);
//				mycurso = mydb.mydb.rawQuery("Select * FROM phrases ", null);
//				polulatelistviewfromdb();
//				mylistview1.setSelection(id);
//			}
//			ed1.setText(null);
//			ed2.setText(null);
//
//		}
//	};
//	public boolean onCreateOptionsMenu(Menu menu) {
//		menu.add("Add");
//		return super.onCreateOptionsMenu(menu);
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		ADD();
//		return super.onOptionsItemSelected(item);
	}
*/
}
