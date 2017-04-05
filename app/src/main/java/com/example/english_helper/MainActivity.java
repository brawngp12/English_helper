package com.example.english_helper;

import com.example.english_helper.MainActivity;
import com.example.english_helper.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	MediaPlayer nhacnen;
	Button b1, b2, b3, b4, b5, b6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Class_Setup setup = new Class_Setup(this);
		setup.run();
		b1 = (Button) findViewById(R.id.btn_grammar);
		b2 = (Button) findViewById(R.id.btnBQT);
		b3 = (Button) findViewById(R.id.btn_vocabulary);
		b4 = (Button) findViewById(R.id.btn1000);
		b5 = (Button) findViewById(R.id.btn_exit);
		b6 = (Button) findViewById(R.id.btn_introduction);

		b1.setOnClickListener(XLSK);
		b2.setOnClickListener(XLSK);
		b3.setOnClickListener(XLSK);
		b4.setOnClickListener(XLSK);
		b5.setOnClickListener(XLSK);
		b6.setOnClickListener(XLSK);
		nhacnen = MediaPlayer.create(MainActivity.this, R.raw.chonchucnang);
		nhacnen.start();
	}

	OnClickListener XLSK = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent a2;
			if (v == b1) {
				a2 = new Intent(MainActivity.this, GrammarActivity.class);
					startActivity(a2);
			} else {
				if (v == b2) {
					a2 = new Intent(MainActivity.this, Activity_DTBQT_list.class);
					startActivity(a2);
				} else if (v == b3) {
					a2 = new Intent(MainActivity.this, Activity_Tuvung_list.class);
					startActivity(a2);
				} else {
					if (v == b4) {
						a2 = new Intent(MainActivity.this, Activity_Cau_list.class);
						startActivity(a2);
					} else {
						if (v == b5) {
							Thread bamgio = new Thread() {
								public void run() {
									nhacnen = MediaPlayer.create(MainActivity.this, R.raw.camon);
									nhacnen.start();
									try {
										sleep(3000);
									} catch (Exception e) {
									} finally {
										finish();
									}
								}
							};
							bamgio.start();
						} else {
							if (v == b6) {
								a2 = new Intent(MainActivity.this, Activity_myenglish.class);
								startActivity(a2);
							}
						}
					}
				}
			}
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Info");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent a2;
		a2 = new Intent(MainActivity.this, AboutActivity.class);
		startActivity(a2);
		return super.onOptionsItemSelected(item);
	}
	
}
