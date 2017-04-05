package com.example.english_helper;

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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Activity_DTBQT_list extends ActionBarActivity {

	Class_database mydb= new Class_database();
	ListView mylistview1;
	Cursor mycurso;
	private EditText inputSearch;
	public TextToSpeech tts;
	Class_myAdapter adt;
	ImageButton btnclear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		mylistview1 = (ListView)findViewById(R.id.list_word);
		mycurso = mydb.mydb.rawQuery("Select * FROM irregular_verbs ", null);
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
			mycurso = mydb.mydb.rawQuery("Select * FROM irregular_verbs where infinitive like '" + cs.toString() + "%'", null);;
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
	void polulatelistviewfromdb()
	{
		startManagingCursor(mycurso);
		String[] fromm = new String[] {"infinitive","vi_content"};
		int [] too = new int [] {R.id.txtnghe, R.id.nghia};
		adt = new Class_myAdapter(this,R.layout.dtbqt_item1, mycurso, fromm,too,2);
		mylistview1.setAdapter(adt);
	}
	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			Intent a2 = new Intent(Activity_DTBQT_list.this,Activity_DTBQT_item.class);
			a2.putExtra("v1",mycurso.getString(1));
			a2.putExtra("v2",mycurso.getString(2));
			a2.putExtra("v3",mycurso.getString(3));
			a2.putExtra("nghia",mycurso.getString(4));
			a2.putExtra("vd",mycurso.getString(5));
			startActivity(a2);
}	
};
}
