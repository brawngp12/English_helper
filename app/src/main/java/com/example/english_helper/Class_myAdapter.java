package com.example.english_helper;

import java.io.IOException;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification.Action;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Class_myAdapter extends SimpleCursorAdapter  implements TextToSpeech.OnInitListener{

	Activity context;
	int layout;
	Cursor c;
	String [] from;
	int[] to;
	int i=0;
	private TextToSpeech tts;
	public Class_myAdapter(Activity context, int layout, Cursor c, String[] from,int[] to, int i) {
		super(context, layout, c, from, to);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.layout= layout;
		this.c = c;
		this.from=from;
		this.to=to;
		tts = new TextToSpeech(context, this);
		this.i=i;
	}
	ImageButton btn;
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if(status  !=TextToSpeech.ERROR)
		{
			tts.setLanguage(Locale.US);
		}
	}
	public View getView(int position, View convertView,ViewGroup parent) {	
		if(position<c.getCount()){
			LayoutInflater inflater=
			context.getLayoutInflater();
			convertView=inflater.inflate(layout, null,true);
			this.c.moveToPosition(position);
			if(i==1)
			{
				tuvung(position,convertView,parent);
			}
			else{
				if(i==2)
				{
					dtbqt(position,convertView,parent);
				}
				else
					if(i==3){
						myenglish(position,convertView,parent);
					}
			}}
			return convertView;	
	}
	public void tuvung(int position, View convertView,ViewGroup parent)
	{
		String tanh = this.c.getString(1);
        String nghia = this.c.getString(4);
		TextView tv1 = (TextView)convertView.findViewById(R.id.txtnghe);
		tv1.setText(tanh);
		TextView tv2 = (TextView)convertView.findViewById(R.id.nghia);
		tv2.setText(nghia);
		final ImageButton btn = (ImageButton)convertView.findViewById(R.id.btnnghe2);
		btn.setTag(tanh);

		btn.setOnClickListener(SKnghe);
	}
	
	public void myenglish(int position, View convertView,ViewGroup parent)
	{
		String tanh = this.c.getString(1);
        String nghia = this.c.getString(3)+" "+this.c.getString(2);
		TextView tv1 = (TextView)convertView.findViewById(R.id.txtnghe);
		tv1.setText(tanh);
		TextView tv2 = (TextView)convertView.findViewById(R.id.nghia);
		tv2.setText(nghia);
		final ImageButton btn = (ImageButton)convertView.findViewById(R.id.btnnghe2);
		btn.setTag(tanh);
		btn.setOnClickListener(SKnghe);
	}
	
	
	public void dtbqt(int position, View convertView,ViewGroup parent){
		String v1,v2,v3,nghia;
		v1=this.c.getString(1);
		v2=this.c.getString(2);
		v3=this.c.getString(3);
		nghia=this.c.getString(4);
		TextView tv1 = (TextView)convertView.findViewById(R.id.txt_dtbqt1);
		tv1.setText(v1+"-"+v2+"-"+v3);
		TextView tv2 = (TextView)convertView.findViewById(R.id.txt_dtbqt2);
		tv2.setText(nghia);
		btn = (ImageButton)convertView.findViewById(R.id.btnnghe2);
		//btn.setTag(tv1.getText().toString());
	}
	
	OnClickListener SKnghe = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			v.setBackgroundResource(R.drawable.nghe2);
			final String pos = (String)v.getTag();
			tts.speak(pos, TextToSpeech.QUEUE_FLUSH, null);
			v.setBackgroundResource(R.drawable.nghe1);
		}
		
		
	};
	
	
}
