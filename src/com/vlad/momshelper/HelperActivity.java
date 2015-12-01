package com.vlad.momshelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelperActivity extends Activity {
	
	final String FILENAME="point_storage";
	
	int ballance=900;
	Button add;
	TextView points;
	EditText addPoints, passwd;
	String str;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_helper);
		//readFile();
		//ballance = Integer.parseInt(str);
		points = (TextView)findViewById(R.id.tvBallance);
		add = (Button)findViewById(R.id.bAdd);
		addPoints = (EditText)findViewById(R.id.etPoints);
		passwd = (EditText)findViewById(R.id.etPasswd);
		
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			String match = passwd.getText().toString();
			if (match.equals("family")){
				addPoints.setInputType(EditorInfo.TYPE_NUMBER_FLAG_SIGNED);;
				int adding = Integer.parseInt(addPoints.getText().toString());
				ballance=ballance+adding;
				points.setText("You got " + ballance + " points!");
			}
			else {
				points.setText("Wrong password :(");
			}
			}
		});
	}

	/*void readFile() {
		try {
		      BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(FILENAME)));
		      str = br.readLine();
		      }
		     catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
	
	
	void writeFile(int a) {
	    try {
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput(FILENAME, MODE_PRIVATE)));
	      bw.write(a);
	      bw.close();
	      } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	*/
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.helper, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
