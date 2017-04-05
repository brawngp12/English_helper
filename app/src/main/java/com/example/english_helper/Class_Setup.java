package com.example.english_helper;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
 
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
/**
 * @author fredrik.persson
 */
public class Class_Setup extends Thread {
	Context m_context;
	File m_sdcard;
	String m_configdir = "";
	
	//ArrayAdapter <String> bai;
	//ListView lv;

	public Class_Setup(Context context){
		m_context = context;
		m_sdcard = Environment.getExternalStorageDirectory();
	}
	
	public void run(){
		File cfgdir = new File(m_sdcard+m_configdir);
		if(!cfgdir.exists()){
			cfgdir.mkdirs();

		}
		copyResources(R.raw.lesson);
	}
 
	public void copyResources(int resId){
		Log.i("Test", "Setup::copyResources");
		InputStream in = m_context.getResources().openRawResource(resId);
		String filename = m_context.getResources().getResourceEntryName(resId);
		
		File f = new File(m_sdcard+m_configdir,"lesson.sqlite");
		
		if(!f.exists()){
			try {
				OutputStream out = new FileOutputStream(new File(m_sdcard+m_configdir,"lesson.sqlite"));
				byte[] buffer = new byte[1024];
				int len;
				while((len = in.read(buffer, 0, buffer.length)) != -1){
					out.write(buffer, 0, len);
				}
				in.close();
				out.close();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
		}
	}
	
	
	public void readData()
	 {	Class_database mydb=new Class_database();
		
	int ch=34;
	 String data,data2=null;
	 InputStream in = null;
//	 InputStream in= getResources().openRawResource(R.raw.nghe);
	 InputStreamReader inreader=new InputStreamReader(in);
	 BufferedReader bufreader=new BufferedReader(inreader);
	 mydb.mydb.execSQL("CREATE TABLE IF NOT EXISTS nghe(_id int,tenbai nvarchar(200))");	
	 mydb.mydb.execSQL("CREATE TABLE IF NOT EXISTS nghe_nd(_id int,cau nvarchar(200))");	
	 if(in!=null)
	 {
	 try
	 {
		 int i=0;
	 while((data=bufreader.readLine())!=null)
	 {
		 i++;
		 String s = "INSERT INTO nghe(_id,tenbai) VALUES (" +i+","+(char)ch+data + (char)ch +")";
		 mydb.mydb.execSQL(s);
	 }
	 in.close();
	}
	 catch(IOException ex){
	 Log.e("ERROR", ex.getMessage());
	 }
	 }
	 
	 //
	 
	 InputStream in1 = null;
	//	 InputStream in1= getResources().openRawResource(R.raw.nghe1);
	 InputStreamReader inreader1=new InputStreamReader(in1);
	 BufferedReader bufreader1=new BufferedReader(inreader1);
	 if(in!=null)
	 {
	 try
	 {
		 int i=0;
	 while((data=bufreader1.readLine())!=null)
	 {
		 if(data.equals("#"))
		 {
			 i++;
		 }
		 else
		 {
			 String s = "INSERT INTO nghe_nd(_id,cau) VALUES (" +i+","+(char)ch+data + (char)ch +")";
			 mydb.mydb.execSQL(s);
		 }
	 }
	 in1.close();
	}
	 catch(IOException ex){
	 Log.e("ERROR", ex.getMessage());
	 }
	 }
	}
}