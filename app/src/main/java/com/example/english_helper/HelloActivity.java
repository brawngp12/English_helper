package com.example.english_helper;

import com.example.english_helper.HelloActivity;
import com.example.english_helper.MainActivity;
import com.example.english_helper.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HelloActivity extends ActionBarActivity {
	MediaPlayer nhacnen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello);
		setTitle("EnglishPlus");

		nhacnen = MediaPlayer.create(HelloActivity.this, R.raw.chaomung);
		nhacnen.start();

		Thread bamgio = new Thread() {
			public void run() {
				try {
					sleep(4000);

				} catch (Exception e) {

				} finally {
					Intent activitymoi = new Intent(getApplicationContext(),
							MainActivity.class);
					startActivity(activitymoi);
				}
			}
		};
		bamgio.start();
	}

	protected void onPause() {
		super.onPause();
		nhacnen.release();
		finish();

	}
}
