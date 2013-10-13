package org.thegoodforyou.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import android.os.Bundle;
//import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.text.format.Time;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	TextView mtextOutput;
	EditText mactionInput;
	EditText memotionInput;
	final static String FILENAME="GOOD.html";
	//File sdCard = Environment.getExternalStorageDirectory();
	//File dir = new File (sdCard.getAbsolutePath() + "/GOOD/");
	//String FILE = new String (dir.toString() + FILENAME);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//setup widgets
		setupWidgets();
		//make sdcard directory
		// if (!dir.exists()) {
		//	 dir.mkdirs();
		//	 } 
	// load text from file
		loadTextFromFile();
		
	}

	private void loadTextFromFile() {
		// TODO Auto-generated method stub
		File fileinput = new File(getFilesDir(), FILENAME);
		try {
			BufferedReader br= new BufferedReader(new FileReader(fileinput));
			
			String line;
			while ((line=br.readLine())!=null){
				mtextOutput.setText(line+"\n"+mtextOutput.getText());
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void setupWidgets() {
		// TODO Auto-generated method stub
		Button actionsave =(Button) findViewById(R.id.actionSubmitButton);
		actionsave.setOnClickListener(this);
		Button emotionsave =(Button) findViewById(R.id.emotionSubmitButton);
		emotionsave.setOnClickListener(this);
		mtextOutput =(TextView)findViewById(R.id.textView);
		mactionInput =(EditText)findViewById(R.id.actionInput);
		mtextOutput.setMovementMethod(new ScrollingMovementMethod());
		memotionInput =(EditText)findViewById(R.id.emotionInput);
	}


	@Override
	public void onClick(View v) {
		Time now = new Time();
		now.setToNow();
		if (v.getId()==R.id.actionSubmitButton){
			String action = mactionInput.getText().toString();
			mtextOutput.setText("<tr><td>"+now+"</td><td>action</td><td>"+action+"</td></tr>"+"\n"+mtextOutput.getText().toString());
			mactionInput.setText("");
			try {
				FileOutputStream fileoutput = openFileOutput(FILENAME,Context.MODE_APPEND);
				fileoutput.write("<tr><td>".getBytes());
				fileoutput.write(now.toString().getBytes());
				fileoutput.write("</td><td>".getBytes());
				fileoutput.write(action.getBytes());
				fileoutput.write("</td></tr>".getBytes());
				fileoutput.write("\n".getBytes());
				//FileOutputStream sdcardoutput = new FileOutputStream(new File(FILE), true);
				//sdcardoutput.write("<tr><td>".getBytes());
				//sdcardoutput.write(now.toString().getBytes());
				//sdcardoutput.write("</td><td>".getBytes());
				//sdcardoutput.write(action.getBytes());
				//sdcardoutput.write("</td></tr>".getBytes());
				//sdcardoutput.write("\n".getBytes());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		if (v.getId()==R.id.emotionSubmitButton){
			String emotion = memotionInput.getText().toString();
			mtextOutput.setText("<tr><td>"+now+"</td><td>emotion</td><td>"+emotion+"</td></tr>"+"\n"+mtextOutput.getText().toString());
			memotionInput.setText("");
			try {
				FileOutputStream fileoutput = openFileOutput(FILENAME,Context.MODE_APPEND);
				fileoutput.write("<tr><td>".getBytes());
				fileoutput.write(now.toString().getBytes());
				fileoutput.write("</td><td>".getBytes());
				fileoutput.write(emotion.getBytes());
				fileoutput.write("</td></tr>".getBytes());
				fileoutput.write("\n".getBytes());
		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}

}
// view handler

// button handler

// save text to file

// display text in app
