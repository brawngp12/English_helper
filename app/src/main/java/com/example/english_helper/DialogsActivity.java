package com.example.english_helper;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class DialogsActivity extends ActionBarActivity {
	String itemValue;
	private String chuong[] = {
			"nội dung",
			"1. Cấu trúc chung của một câu trong tiếng Anh:",
			"2. Noun phrase (ngữ danh từ)",
			"3. Verb phrase (ngữ động từ)",
			"4. Sự hòa hợp giữa chủ ngữ và động từ",
			"5. đại từ",
			"6. Tân ngữ (complement / object) và các vấn đề liên quan",
			"7. Một số động từ đặc biệt (need, dare, to be, get)",
			"8. Câu hỏi",
			"9. Lối nói phụ họa",
			"10. Câu phủ định (negation)",
			"11. Câu mệnh lệnh",
			"12. Các trợ động từ (Modal Auxiliaries)",
			"13. Câu điều kiện",
			"14. Cách dùng một số trợ động từ hình thái ở thời hiện tại",
			"15. Dùng trợ động từ để diễn đạt tình huống quá khứ (modal + perfective)",
			"16. Cách dùng should trong một số trường hợp cụ thể khác",
			"17. Tính từ và phó từ",
			"18. Liên từ (linking verb)",
			"19. Các dạng so sánh của tính từ và phó từ",
			"20. Danh từ dùng làm tính từ",
			"21. Cách dùng Enough",
			"22. Much, many, a lot of và lots of – trong một số trường hợp khác",
			"23. Các cụm từ nối mang tính quan hệ nhân quả"};
	String[] trang = { "Trang", "1", "4", "8", "16", "21", "24", "29", "32",
			"35", "36", "41", "43", "45", "54", "57", "59", "60", "63", "64",
			"69", "70", "71", "73"};
	Intent i1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialogs);
		setTitle("Mục Lục");
		final ListView lv = (ListView) findViewById(R.id.lv_dialog);

		CustomList_nguphap adapter = new CustomList_nguphap(
				DialogsActivity.this, chuong, trang);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				if (position == 1) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					i1.putExtra("trang", 1);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					startActivity(i1);
				}
				if (position == 2) {

					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 4);
					startActivity(i1);
				}
				if (position == 3) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 8);
					startActivity(i1);
				}
				if (position == 4) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 16);
					startActivity(i1);
				}
				if (position == 5) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 21);
					startActivity(i1);
				}
				if (position == 6) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 24);
					startActivity(i1);
				}
				if (position == 7) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 29);
					startActivity(i1);
				}
				if (position == 8) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 32);
					startActivity(i1);
				}
				if (position == 9) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					i1.putExtra("trang", 34);
					startActivity(i1);
				}
				if (position == 10) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 36);
					startActivity(i1);
				}
				if (position == 11) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 41);
					startActivity(i1);
				}
				if (position == 12) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 43);
					startActivity(i1);
				}
				if (position == 13) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 45);
					startActivity(i1);
				}
				if (position == 14) {
					Intent i1 = new Intent(DialogsActivity.this,
							GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 54);
					startActivity(i1);
				}
				if (position == 15) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					i1.putExtra("trang", 57);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					startActivity(i1);
				}
				if (position == 16) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 59);
					startActivity(i1);
				}
				if (position == 17) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 60);
					startActivity(i1);
				}
				if (position == 18) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 63);
					startActivity(i1);
				}
				if (position == 19) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					i1.putExtra("trang", 64);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					startActivity(i1);
				}
				if (position == 20) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					i1.putExtra("trang", 69);
					startActivity(i1);
				}
				if (position == 21) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 70);
					startActivity(i1);
				}
				if (position == 22) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 71);
					startActivity(i1);
				}
				if (position == 23) {
					i1 = new Intent(DialogsActivity.this, GrammarActivity.class);
					itemValue = (String) lv.getItemAtPosition(position);
					i1.putExtra("chuong", itemValue);
					i1.putExtra("trang", 73);
					startActivity(i1);
				}
				GrammarActivity.fa.finish();
				DialogsActivity.this.finish();
				
			}
		});
	}
}
