package edu.upenn.cis350;
import android.os.AsyncTask;
import android.widget.TextView;


public class BackgroundTask extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void onPostExecute(String result){
		//update views in the UI
		//TextView tv = (TextView) findViewById(R.id.display_id);
		//tv.setText(result);
	}

}
