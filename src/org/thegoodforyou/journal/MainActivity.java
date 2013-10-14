package org.thegoodforyou.journal;

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
	EditText mnoteToSelfInput;
	EditText mtoDoInput;
	EditText mdietInput;
	EditText mexerciseInput;
	EditText mjournalInput;
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
		Button notetoselfsave =(Button) findViewById(R.id.noteToSelfSubmitButton);
		notetoselfsave.setOnClickListener(this);
		Button todosave =(Button) findViewById(R.id.toDoSubmitButton);
		todosave.setOnClickListener(this);
		Button dietsave =(Button) findViewById(R.id.dietSubmitButton);
		dietsave.setOnClickListener(this);
		Button exercisesave =(Button) findViewById(R.id.exerciseSubmitButton);
		exercisesave.setOnClickListener(this);
		Button journalsave =(Button) findViewById(R.id.journalSubmitButton);
		journalsave.setOnClickListener(this);
		mactionInput =(EditText)findViewById(R.id.actionInput);
		memotionInput =(EditText)findViewById(R.id.emotionInput);
		mnoteToSelfInput =(EditText)findViewById(R.id.noteToSelfInput);
		mtoDoInput =(EditText)findViewById(R.id.toDoInput);
		mdietInput =(EditText)findViewById(R.id.dietInput);
		mexerciseInput =(EditText)findViewById(R.id.exerciseInput);
		mjournalInput =(EditText)findViewById(R.id.journalInput);
		mtextOutput =(TextView)findViewById(R.id.textView);
		mtextOutput.setMovementMethod(new ScrollingMovementMethod());
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
				fileoutput.write("</td><td>action</td><td>".getBytes());
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
				fileoutput.write("</td><td>emotion</td><td>".getBytes());
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
		if (v.getId()==R.id.noteToSelfSubmitButton){
			String noteToSelf = mnoteToSelfInput.getText().toString();
			mtextOutput.setText("<tr><td>"+now+"</td><td>notetoself</td><td>"+noteToSelf+"</td></tr>"+"\n"+mtextOutput.getText().toString());
			mnoteToSelfInput.setText("");
			try {
				FileOutputStream fileoutput = openFileOutput(FILENAME,Context.MODE_APPEND);
				fileoutput.write("<tr><td>".getBytes());
				fileoutput.write(now.toString().getBytes());
				fileoutput.write("</td><td>notetoself</td><td>".getBytes());
				fileoutput.write(noteToSelf.getBytes());
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
		if (v.getId()==R.id.toDoSubmitButton){
			String toDo = mtoDoInput.getText().toString();
			mtextOutput.setText("<tr><td>"+now+"</td><td>todo</td><td>"+toDo+"</td></tr>"+"\n"+mtextOutput.getText().toString());
			mtoDoInput.setText("");
			try {
				FileOutputStream fileoutput = openFileOutput(FILENAME,Context.MODE_APPEND);
				fileoutput.write("<tr><td>".getBytes());
				fileoutput.write(now.toString().getBytes());
				fileoutput.write("</td><td>todo</td><td>".getBytes());
				fileoutput.write(toDo.getBytes());
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
		if (v.getId()==R.id.dietSubmitButton){
			String diet = mdietInput.getText().toString();
			mtextOutput.setText("<tr><td>"+now+"</td><td>diet</td><td>"+diet+"</td></tr>"+"\n"+mtextOutput.getText().toString());
			mdietInput.setText("");
			try {
				FileOutputStream fileoutput = openFileOutput(FILENAME,Context.MODE_APPEND);
				fileoutput.write("<tr><td>".getBytes());
				fileoutput.write(now.toString().getBytes());
				fileoutput.write("</td><td>diet</td><td>".getBytes());
				fileoutput.write(diet.getBytes());
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
		if (v.getId()==R.id.exerciseSubmitButton){
			String exercise = mexerciseInput.getText().toString();
			mtextOutput.setText("<tr><td>"+now+"</td><td>exercise</td><td>"+exercise+"</td></tr>"+"\n"+mtextOutput.getText().toString());
			mexerciseInput.setText("");
			try {
				FileOutputStream fileoutput = openFileOutput(FILENAME,Context.MODE_APPEND);
				fileoutput.write("<tr><td>".getBytes());
				fileoutput.write(now.toString().getBytes());
				fileoutput.write("</td><td>exercise</td><td>".getBytes());
				fileoutput.write(exercise.getBytes());
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
		if (v.getId()==R.id.journalSubmitButton){
			String journal = mjournalInput.getText().toString();
			mtextOutput.setText("<tr><td>"+now+"</td><td>journal</td><td>"+journal+"</td></tr>"+"\n"+mtextOutput.getText().toString());
			mjournalInput.setText("");
			try {
				FileOutputStream fileoutput = openFileOutput(FILENAME,Context.MODE_APPEND);
				fileoutput.write("<tr><td>".getBytes());
				fileoutput.write(now.toString().getBytes());
				fileoutput.write("</td><td>journal</td><td>".getBytes());
				fileoutput.write(journal.getBytes());
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
