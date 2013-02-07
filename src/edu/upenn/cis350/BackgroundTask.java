package edu.upenn.cis350;
import java.util.Calendar;

import android.os.AsyncTask;
import android.widget.TextView;


public class BackgroundTask extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... arg0) {
	    Calendar cal = Calendar.getInstance();
	    int sec = cal.get(cal.SECOND);
	    int min = cal.get(cal.MINUTE);
	    int hour = cal.get(cal.HOUR);

	    
		return null;
	}
	
	protected void onPostExecute(String result){
		
	}

}
