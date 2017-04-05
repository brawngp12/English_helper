package com.example.english_helper;


import java.util.Locale;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Tuvung_item extends ActionBarActivity implements TextToSpeech.OnInitListener {

	String tuvung,phienam,nghia1,nghia2;
	TextView t1,t2,t3,t4;
	ListView lv;
	ImageButton btnghe;
	private TextToSpeech tts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tuvung_item1);
		t1=(TextView)findViewById(R.id.txtword);
		t2=(TextView)findViewById(R.id.txtphienam);
		tuvung= getIntent().getStringExtra("tuvung");
		phienam= getIntent().getStringExtra("phienam");
		nghia1= getIntent().getStringExtra("nghia1");
		t1.setText(tuvung);
		t2.setText("("+phienam+")");
		btnghe = (ImageButton)findViewById(R.id.btnnghe_word);
		ArrayAdapter <String> ad = new ArrayAdapter <String>(Activity_Tuvung_item.this,android.R.layout.simple_list_item_1);
		ad.add(nghia1);
		lv=(ListView)findViewById(R.id.lv1);
		lv.setAdapter(ad);
		tts = new TextToSpeech(this, this);
		btnghe.setOnClickListener(SKnghe);
	}
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(tts!=null){
			tts.stop();
			tts.shutdown();
		}
	}
	
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if(status  !=TextToSpeech.ERROR)
		{
			tts.setLanguage(Locale.US);
		}
	}
	OnClickListener SKnghe = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		    tts.speak(tuvung, TextToSpeech.QUEUE_FLUSH, null);
		}
	};

	
}
