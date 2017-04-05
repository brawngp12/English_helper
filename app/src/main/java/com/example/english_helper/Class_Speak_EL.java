package com.example.english_helper;

import java.util.Locale;

import android.content.Context;
import android.speech.tts.TextToSpeech;

public class Class_Speak_EL  implements TextToSpeech.OnInitListener {
	Context c;
	String string;
	public TextToSpeech tts;
	public Class_Speak_EL(Context context, String s)
	{
		this.c=context;
		this.string =s;
	}
	public void speak()
	{
		tts = new TextToSpeech(c, this);
		tts.speak(string, TextToSpeech.QUEUE_FLUSH, null);
	}
	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if(status  !=TextToSpeech.ERROR)
		{
			tts.setLanguage(Locale.US);
		}
	}
	
	
}
