package com.example.english_helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class GrammarActivity extends ActionBarActivity implements
		OnClickListener {

	private TextView tieude1, tieude2, tvnoidung1, tvnoidung2, trang;
	ImageButton btnnext, btnprevious, btnadd, btnsub, btnchuong;
	int i = 0, j = 0;
	int sizenoidung = 15;
	public static Activity fa;
	int tieudelon = 19;
	private String[] chuong = {
			"1. Cấu trúc chung của một câu trong tiếng Anh",
			"2. Noun phrase(Danh từ)",
			"3. Verb phrase (Động từ)",
			"4. Sự hòa hợp giữa chủ ngữ và động từ",
			"5. Pronouns(Đại từ)",
			"6. Tân ngữ(complement/object)",
			"7. Động từ đặc biệt(need, dare, to be, get)",
			"8. Question(Câu hỏi)",
			"9. Lối nói phụ họa",
			"10.Negation(Câu phủ định)",
			"11.Imperatives(Câu mệnh lệnh)",
			"12.Modal Auxiliaries(Các trợ động từ)",
			"13.Conditionals(Câu điều kiện)",
			"14.Cách dùng một số trợ động từ",
			"15.Dùng trợ động từ để diễn đạt tình huống quá khứ (modal + perfective)",
			"16.Cách dùng should trong một số trường hợp cụ thể khác",
			"17.Tính từ và phó từ",
			"18.Linking verb(Liên từ)",
			"19.Các dạng so sánh của tính từ và phó từ",
			"20.Danh từ dùng làm tính từ",
			"21.Cách dùng Enough",
			"22.Much, many, a lot of và lots of – trong một số trường hợp khác",
			"23.Các cụm từ nối mang tính quan hệ nhân quả"};
	private String tieudenho1[] = {
			"",
			"",
			"1.2 Verb (động từ):",
			"1.4 Modifier (trạng từ):",
			"2.1 Danh từ đếm được và không đếm được (Count noun/ Non-count noun):",
			"2.3 Cách dùng quán từ xác định The",
			"2.3.2 Bảng sử dụng the và không sử dụng the trong một số trường hợp điển hình",
			"2.5 Cách sử dụng little, a little, few, a few",
			"3.1.1 Simple Present (thời hiện tại thường)",
			"3.1.3 Present Perfect (thời hiện tại hoàn thành)",
			"3.1.3.2 Cách dùng ALREADY và YET:",
			"3.1.4 Present Perfect Progressive (thời hiện tại hoàn thành tiếp diễn)",
			"3.2.2 Past Progresseive (thời quá khứ tiếp diễn):",
			"3.2.4 Past Perfect Progressive (thời quá khứ hoàn thành tiếp diễn):",
			"3.3.2 Near Future (tương lai gần):",
			"3.3.4 Future Perfect (thời tương lai hoàn thành):",
			"4.1 Các trường hợp chủ ngữ đứng tách khỏi động từ",
			"4.3 Cách sử dụng None và No",
			"4.5 V-ing làm chủ ngữ",
			"4.7 Cách sử dụng a number of, the number of:",
			"4.9 Cách dùng there is, there are",
			"5.1 Subject pronoun (đại từ nhân xưng chủ ngữ)",
			"5.3 Possessive pronoun (đại từ sở hữu)",
			"5.4 Reflexive pronoun (đại từ phản thân)",
			"6.1 động từ dùng làm tân ngữ",
			"6.1.2. Loại 2: động từ Verb-ing dùng làm tân ngữ",
			"6.1.4 Bốn động từ đặc biệt",
			"6.1.5.2 Adjective + preposition + verb-ing:",
			"6.1.6 động từ đi sau tính từ:",
			"7.1.1 Need dùng như một động từ thường:",
			"7.2.1 Dùng như một nội động từ",
			"7.3 Cách sử dụng to be trong một số trường hợp",
			"8.1 Câu hỏi Yes/ No",
			"8.2.2 Whom hoặc What: câu hỏi tân ngữ",
			"8.3 Câu hỏi phức (embedded question)",
			"9.1 Phụ hoạ câu khẳng định",
			"10. Câu phủ định (negation)",
			"10.2 Một số các câu hỏi ở dạng phủ định lại mang ý nghĩa khác (không dùng dấu ?):",
			"10.4 Phủ định kết hợp với so sánh",
			"10.6 Phủ định không dùng thể phủ định của động từ",
			"10.8 No matter",
			"11. Câu mệnh lệnh",
			"11.2 Mệnh lệnh gián tiếp:",
			"12. Các trợ động từ (Modal Auxiliaries)",
			"12.2 Câu nghi vấn dùng trợ động từ",
			"13. Câu điều kiện",
			"13.2 điều kiện không thể thực hiện được (điều kiện không có thực hay điều kiện dạng II, III)",
			"13.2.2 điều kiện không có thực trong quá khứ (dạng III)",
			"13.4 Cách sử dụng if trong một số trường hợp khác",
			"13.5.1 Wish ở tương lai:",
			"13.5.3 Wish ở quá khứ",
			"13.6.1 Ở thời hiện tại:",
			"13.7 Cách sử dụng used to, (to be/get) used to",
			"13.8.1 Loại câu có một chủ ngữ",
			"14.1 Cách sử dụng Would + like",
			"14.3 Cách sử dụng Should:",
			"14.5 Cách sử dụng have to",
			"15.1 Could, may, might + have + P2 = có lẽ đã",
			"15.3 Must have + P2 = chắc là đã, hẳn là đã",
			"16. Cách dùng should trong một số trường hợp cụ thể khác ",
			"17.1 Tính từ",
			"17.2.1 Adverb of maner:",
			"17.2.3 Adverb of time:",
			"18. Liên từ (linking verb)",
			"19.1 So sánh ngang bằng",
			"19.3 Phép so sánh không hợp lý",
			"19.4 Các tính từ và phó từ đặc biệt",
			"19.6 So sánh kép",
			"19.8 So sánh hơn kém không dùng than (giữa 2 đối tượng)",
			"20. Danh từ dùng làm tính từ",
			"21. Cách dùng Enough",
			"22.2 Phân biệt alot/ lots of/ plenty/ a great deal với many/ much",
			"22.4 Long & (for) a long time", "23.2 So that",
			"23.3.1 Dùng với tính từ và phó từ:",
			"23.3.3  Dùng với danh từ không đếm được:",
			"23.3.5 Dùng such trước tính từ + danh từ:",
			"23.4.5 Unless + positive"};
	private int noidung1[] = {R.drawable.part1, R.drawable.part100, R.drawable.part102,
			R.drawable.part104, R.drawable.part105, R.drawable.part107,
			R.drawable.part109, R.drawable.part111, R.drawable.part113,
			R.drawable.part115, R.drawable.part117, R.drawable.part119,
			R.drawable.part121, R.drawable.part123, R.drawable.part125,
			R.drawable.part127, R.drawable.part129, R.drawable.part131,
			R.drawable.part133, R.drawable.part135, R.drawable.part137,
			R.drawable.part139, R.drawable.part141, R.drawable.part143,
			R.drawable.part145, R.drawable.part147, R.drawable.part149,
			R.drawable.part151, R.drawable.part153, R.drawable.part155,
			R.drawable.part157, R.drawable.part159, R.drawable.part161,
			R.drawable.part163, R.drawable.part165, R.drawable.part167,
			R.drawable.part169, R.drawable.part171, R.drawable.part173,
			R.drawable.part175, R.drawable.part177, R.drawable.part179,
			R.drawable.part181, R.drawable.part183, R.drawable.part185,
			R.drawable.part187, R.drawable.part189, R.drawable.part191,
			R.drawable.part193, R.drawable.part195, R.drawable.part197,
			R.drawable.part199, R.drawable.part201, R.drawable.part203,
			R.drawable.part205, R.drawable.part207, R.drawable.part209,
			R.drawable.part211, R.drawable.part213, R.drawable.part215,
			R.drawable.part217, R.drawable.part219, R.drawable.part221,
			R.drawable.part223, R.drawable.part225, R.drawable.part227,
			R.drawable.part229, R.drawable.part231, R.drawable.part233,
			R.drawable.part235, R.drawable.part237, R.drawable.part239,
			R.drawable.part241, R.drawable.part243, R.drawable.part245,
			R.drawable.part247, R.drawable.part249, R.drawable.part251};
	private String tieudenho2[] = {
			"",
			"1.1 Subject (chủ ngữ):",
			"1.3 Complement (vị ngữ):",
			"",
			"2.2 Cách dùng quán từ không xác định a và an ",
			"2.3.1 Sau đây là một số trường hợp thông dụng dùng The theo quy tắc trên:",
			"2.4 Cách sử dụng another và other.",
			"2.6 Sở hữu cách",
			"3.1.2 Present Progressive (thời hiện tại tiếp diễn)",
			"3.1.3.1 Cách dùng SINCE và FOR:",
			"3.1.3.3 Thời hiện tại hoàn thành thường dược dùng với một số cụm từ chỉ thời gian như sau:",
			"3.2.1 Simple Past (thời quá khứ thường):",
			"3.2.3 Past Perfect (thời quá khứ hoàn thành):",
			"3.3.1 Simple Future (thời tương lai thường):",
			"3.3.3 Future Progressive (thời tương lai tiếp diễn):",
			"",
			"4.2 Các từ luôn đi với danh từ hoặc đại từ số ít",
			"4.4 Cách sử dụng cấu trúc either... or (hoặc...hoặc) và neither... nor(không...mà cũng không)",
			"4.6 Các danh từ tập thể",
			"4.8 Các danh từ luôn ở số nhiều",
			"",
			"5.2 Complement pronoun (đại từ nhân xưng tân ngữ)",
			"5.3.1 Possessive adjectives (Tính từ sở hữu)",
			"",
			"6.1.1. Loại 1: động từ nguyên thể làm tân ngữ (to + verb)",
			"6.1.3 Bảng dưới đây là những động từ mà tân ngữ sau nó có thể là một động từ nguyên thể hoặc một verb-ing mà ngữ nghĩa không thay đổi.",
			"6.1.5.1 Verb + preposition + verb-ing",
			"6.1.5.3 Noun + preposition + verb-ing:",
			"6.2.1 Trường hợp tân ngữ là động từ nguyên thể",
			"7.1.2 Need dùng như một trợ động từ",
			"7.2.2 Dùng như một ngoại động từ",
			"7.4 Cách sử dụng to get trong một số trường hợp:",
			"8.2.1 Who hoặc What: câu hỏi chủ ngữ",
			"8.2.3 When, Where, How và Why: Câu hỏi bổ ngữ",
			"8.4 Câu hỏi đuôi (tag questions)",
			"9.2 Phụ hoạ câu phủ định",
			"10.1 Some/any:",
			"10.3 Hai lần phủ định",
			"10.5 Cấu trúc phủ định song song",
			"10.7 Thể phủ định của một số động từ đặc biệt",
			"10.9 Cách dùng Not ... at all; at all",
			"11.1 Mệnh lệnh thức trực tiếp",
			"11.3 Dạng phủ định của câu mệnh lệnh",
			"12.1 Câu phủ định dùng trợ động từ",
			"",
			"13.1 điều kiện có thể thực hiện được (điều kiện có thực hay điều kiện dạng I)",
			"13.2.1 điều kiện không có thực ở hiện tại (dạng II)",
			"13.3 Cách sử dụng will, would, could, should trong một số trường hợp khác",
			"13.5 Cách sử dụng Hope và Wish.",
			"13.5.2 Wish ở hiện tại",
			"13.6 Cách sử dụng as if, as though (cứ như là, như thể là)",
			"13.6.2 Thời quá khứ:",
			"13.8 Cách sử dụng would rather",
			"13.8.2 Loại câu có hai chủ ngữ",
			"14.2 Cách sử dụng could/may/might:",
			"14.4 Cách sử dụng Must",
			"",
			"15.2 Should have + P2 = Lẽ ra phải, lẽ ra nên",
			"",
			"",
			"17.2 Phó từ",
			"17.2.2 Adverb of place:",
			"17.2.4 Adverb of frequency:",
			"",
			"19.2 So sánh hơn kém",
			"19.3.3 Dùng thêm those of cho các danh từ số nhiều:",
			"19.5 So sánh bội số",
			"19.7 Cấu trúc No sooner... than (Vừa mới ... thì đã...)",
			"19.9 So sánh bậc nhất (từ 3 đối tượng trở lên)",
			"20.1 Khi nào dùng danh từ làm tính từ, khi nào dùng tính từ của danh từ đó?",
			"22.1 Much & many",
			"22.3 More & most",
			"23.1 Because, Because of",
			"23.3 So và such.",
			"23.3.2 Dùng với danh từ đếm được số nhiều:",
			"23.3.4  Dùng với danh từ đếm được số ít:",
			"23.4 Một số cụm từ nối khác:",
			"23.4.5 Unless + positive = if ... not: Trừ phi, nếu không."};
	private int noidung2[] = {R.drawable.part1, R.drawable.part101, R.drawable.part103,
			R.drawable.part1, R.drawable.part106, R.drawable.part108,
			R.drawable.part110, R.drawable.part112, R.drawable.part114,
			R.drawable.part116, R.drawable.part118, R.drawable.part120,
			R.drawable.part122, R.drawable.part124, R.drawable.part126,
			R.drawable.part1, R.drawable.part130, R.drawable.part132,
			R.drawable.part134, R.drawable.part136, R.drawable.part1,
			R.drawable.part140, R.drawable.part142, R.drawable.part1,
			R.drawable.part146, R.drawable.part148, R.drawable.part150,
			R.drawable.part152, R.drawable.part154, R.drawable.part156,
			R.drawable.part158, R.drawable.part160, R.drawable.part162,
			R.drawable.part164, R.drawable.part166, R.drawable.part168,
			R.drawable.part170, R.drawable.part172, R.drawable.part174,
			R.drawable.part176, R.drawable.part178, R.drawable.part180,
			R.drawable.part182, R.drawable.part184, R.drawable.part1,
			R.drawable.part188, R.drawable.part190, R.drawable.part192,
			R.drawable.part194, R.drawable.part196, R.drawable.part198,
			R.drawable.part200, R.drawable.part202, R.drawable.part204,
			R.drawable.part206, R.drawable.part208, R.drawable.part1,
			R.drawable.part212, R.drawable.part1, R.drawable.part1,
			R.drawable.part218, R.drawable.part220, R.drawable.part222,
			R.drawable.part1, R.drawable.part226, R.drawable.part228,
			R.drawable.part230, R.drawable.part232, R.drawable.part234,
			R.drawable.part236, R.drawable.part238,R.drawable.part240,
			R.drawable.part242, R.drawable.part244, R.drawable.part246,
			R.drawable.part248, R.drawable.part250, R.drawable.part252};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fa=this;
		
		setContentView(R.layout.activity_grammar);
		tieude1 = (TextView) findViewById(R.id.tv_tieudenho1);
		tieude2 = (TextView) findViewById(R.id.tv_tieudenho2);
		trang = (TextView) findViewById(R.id.tv_trang);
		tvnoidung1 = (TextView) findViewById(R.id.tv_noidung_1);
		tvnoidung2 = (TextView) findViewById(R.id.tv_noidung_2);
		btnadd = (ImageButton) findViewById(R.id.btn_add);
		btnadd.setOnClickListener(this);
		btnsub = (ImageButton) findViewById(R.id.btn_sub);
		btnsub.setOnClickListener(this);
		btnnext = (ImageButton) findViewById(R.id.btn_nextpage);
		btnnext.setOnClickListener(this);
		btnprevious = (ImageButton) findViewById(R.id.btn_prevpage);
		btnprevious.setOnClickListener(this);
		btnchuong = (ImageButton) findViewById(R.id.btn_chuong);
		btnchuong.setOnClickListener(this);
		Intent itent = getIntent();
		Bundle b = itent.getExtras();
		if (b != null) {
			j = b.getInt("trang");
			i = j;
			String chuonga = b.getString("chuong");
			readData(noidung1[i]);
			tieude1.setText(tieudenho1[i]);
			tieude2.setText(tieudenho2[i]);
			readData2(noidung2[i]);
			setTitle(chuonga);
			trang.setText("" + i);
		} else {
			i = 1;
			trang.setText("1");
			readData(noidung1[1]);
			tieude1.setText(tieudenho1[1]);
			tieude2.setText(tieudenho2[1]);
			readData2(noidung2[1]);
			setTitle(chuong[0]);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.btn_add:
			if (sizenoidung < 27) {
				sizenoidung++;
				tieudelon++;

				tieude1.setTextSize(tieudelon);
				tieude2.setTextSize(tieudelon);
				tvnoidung1.setTextSize(sizenoidung);
				tvnoidung2.setTextSize(sizenoidung);

			}
			break;
		case R.id.btn_sub:
			if (sizenoidung > 14) {
				sizenoidung--;
				tieudelon--;

				tieude1.setTextSize(tieudelon);
				tieude2.setTextSize(tieudelon);
				tvnoidung1.setTextSize(sizenoidung);
				tvnoidung2.setTextSize(sizenoidung);
			}
			break;
		case R.id.btn_nextpage:
			j++;
			if (i < 76) {
				i++;
				readData(noidung1[i]);
				readData2(noidung2[i]);
				tieude1.setText(tieudenho1[i]);
				tieude2.setText(tieudenho2[i]);
				trang.setText("" + i);
			}
			i--;
			if (i > 0 && i < 3) {
				setTitle(chuong[0]);
			}
			if (i >= 3 && i < 7) {
				setTitle(chuong[1]);
			}
			if (i >= 7 && i < 15) {
				setTitle(chuong[2]);
			}
			if (i >= 15 && i < 20) {
				setTitle(chuong[3]);
			}
			if (i >= 20 && i < 23) {
				setTitle(chuong[4]);
			}
			if (i >= 23 && i < 28) {
				setTitle(chuong[5]);
			}
			if (i >= 28 && i < 31) {
				setTitle(chuong[6]);
			}
			if (i >= 31 && i < 34) {
				setTitle(chuong[7]);
			}
			if (i >= 34 && i < 35) {
				setTitle(chuong[8]);
			}
			if (i >= 35 && i < 40) {
				setTitle(chuong[9]);
			}
			if (i >= 40 && i < 42) {
				setTitle(chuong[10]);
			}
			if (i >= 42 && i < 44) {
				setTitle(chuong[11]);
			}
			if (i >= 44 && i < 53) {
				setTitle(chuong[12]);
			}
			if (i >= 53 && i < 56) {
				setTitle(chuong[13]);
			}
			if (i >= 56 && i < 58) {
				setTitle(chuong[14]);
			}
			if (i >= 58 && i < 59) {
				setTitle(chuong[15]);
			}
			if (i >= 59 && i < 62) {
				setTitle(chuong[16]);
			}
			if (i >= 62 && i < 63) {
				setTitle(chuong[17]);
			}
			if (i >= 63 && i < 68) {
				setTitle(chuong[18]);
			}
			if (i >= 68 && i < 69) {
				setTitle(chuong[19]);
			}
			if (i >= 69 && i < 70) {
				setTitle(chuong[20]);
			}
			if (i >= 70 && i < 72) {
				setTitle(chuong[21]);
			}
			if (i >= 72 && i < 77) {
				setTitle(chuong[22]);
			}
			i++;
			break;

		case R.id.btn_prevpage:
			j--;
			if (i >= 2) {
				i--;
				readData(noidung1[i]);
				readData2(noidung2[i]);
				tieude1.setText(tieudenho1[i]);
				tieude2.setText(tieudenho2[i]);
				trang.setText("" + i);
			} else {

				readData(noidung1[1]);
				readData2(noidung2[1]);
				tieude1.setText(tieudenho1[1]);
				tieude2.setText(tieudenho2[1]);
				trang.setText("" + 1);
			}
			i--;
			if (i > 0 && i < 3) {
				setTitle(chuong[0]);
			}
			if (i >= 3 && i < 7) {
				setTitle(chuong[1]);
			}
			if (i >= 7 && i < 15) {
				setTitle(chuong[2]);
			}
			if (i >= 15 && i < 20) {
				setTitle(chuong[3]);
			}
			if (i >= 20 && i < 23) {
				setTitle(chuong[4]);
			}
			if (i >= 23 && i < 28) {
				setTitle(chuong[5]);
			}
			if (i >= 28 && i < 31) {
				setTitle(chuong[6]);
			}
			if (i >= 31 && i < 34) {
				setTitle(chuong[7]);
			}
			if (i >= 34 && i < 35) {
				setTitle(chuong[8]);
			}
			if (i >= 35 && i < 40) {
				setTitle(chuong[9]);
			}
			if (i >= 40 && i < 42) {
				setTitle(chuong[10]);
			}
			if (i >= 42 && i < 44) {
				setTitle(chuong[11]);
			}
			if (i >= 44 && i < 53) {
				setTitle(chuong[12]);
			}
			if (i >= 53 && i < 56) {
				setTitle(chuong[13]);
			}
			if (i >= 56 && i < 58) {
				setTitle(chuong[14]);
			}
			if (i >= 58 && i < 59) {
				setTitle(chuong[15]);
			}
			if (i >= 59 && i < 62) {
				setTitle(chuong[16]);
			}
			if (i >= 62 && i < 63) {
				setTitle(chuong[17]);
			}
			if (i >= 63 && i < 68) {
				setTitle(chuong[18]);
			}
			if (i >= 68 && i < 69) {
				setTitle(chuong[19]);
			}
			if (i >= 69 && i < 70) {
				setTitle(chuong[20]);
			}
			if (i >= 70 && i < 72) {
				setTitle(chuong[21]);
			}
			if (i >= 72 && i < 77) {
				setTitle(chuong[22]);
			}
			i++;
			break;
		case R.id.btn_chuong:
			Intent in = new Intent(GrammarActivity.this, DialogsActivity.class);
			startActivity(in);
			//this.finish();
			break;
		}
	}

	public void readData(int file) {
		String data;
		InputStream in = getResources().openRawResource(file);
		InputStreamReader inreader = new InputStreamReader(in);
		BufferedReader bufreader = new BufferedReader(inreader);
		StringBuilder builder = new StringBuilder();
		if (in != null) {
			try {
				while ((data = bufreader.readLine()) != null) {
					builder.append(data);
					builder.append("\n");
				}
				in.close();
				tvnoidung1.setText(builder.toString());
			} catch (IOException ex) {
				Log.e("ERROR", ex.getMessage());
			}
		}
	}

	public void readData2(int file) {
		String data;
		InputStream in = getResources().openRawResource(file);
		InputStreamReader inreader = new InputStreamReader(in);
		BufferedReader bufreader = new BufferedReader(inreader);
		StringBuilder builder = new StringBuilder();
		if (in != null) {
			try {
				while ((data = bufreader.readLine()) != null) {
					builder.append(data);
					builder.append("\n");
				}
				in.close();
				tvnoidung2.setText(builder.toString());
			} catch (IOException ex) {
				Log.e("ERROR", ex.getMessage());
			}
		}
	}
}
