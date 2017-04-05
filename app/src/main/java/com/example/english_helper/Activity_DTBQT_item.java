package com.example.english_helper;

import java.util.Locale;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class Activity_DTBQT_item extends ActionBarActivity implements TextToSpeech.OnInitListener {
	String v1,v2,v3,nghia,vd;
	TextView tv1,tv2,tv3,tvnghia,tvex;
	ImageButton imb1,imb2,imb3,imbex;
	private TextToSpeech tts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dtbqt_item2);
		tv1=(TextView)findViewById(R.id.txt_dtbqt_3);
		tv2=(TextView)findViewById(R.id.txt_dtbqt_4);
		tv3=(TextView)findViewById(R.id.txt_dtbqt_5);
		tvnghia=(TextView)findViewById(R.id.txt_dtbqt_6);
		tvex=(TextView)findViewById(R.id.txt_dtbqt_vd);
		v1= getIntent().getStringExtra("v1");
		v2= getIntent().getStringExtra("v2");
		v3= getIntent().getStringExtra("v3");
		nghia= getIntent().getStringExtra("nghia");
		vd= getIntent().getStringExtra("vd");
		tv1.setText("* "+v1);
		tv2.setText("* "+v2);
		tv3.setText("* "+v3);
		tvnghia.setText("* "+nghia);
		tvex.setText(" EX: "+vd);
		
		tts = new TextToSpeech(this, this);
		imb1 = (ImageButton)findViewById(R.id.imageButton1);
		imb2 = (ImageButton)findViewById(R.id.ImageButton01);
		imb3 = (ImageButton)findViewById(R.id.ImageButton02);
		imbex = (ImageButton)findViewById(R.id.ImageButton03);
		imb1.setOnClickListener(SKnghe);
		imb2.setOnClickListener(SKnghe);
		imb3.setOnClickListener(SKnghe);
		imbex.setOnClickListener(SKnghe);
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
			if(v==imb1)
				tts.speak(v1, TextToSpeech.QUEUE_FLUSH, null);
			else
				if(v==imb2)
					tts.speak(v2, TextToSpeech.QUEUE_FLUSH, null);
				else
					if(v==imb3)
						tts.speak(v3, TextToSpeech.QUEUE_FLUSH, null);
					else
						tts.speak(vd, TextToSpeech.QUEUE_FLUSH, null);
		}
	};
}
