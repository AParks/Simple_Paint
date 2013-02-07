package edu.upenn.cis350;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		((Chronometer) findViewById(R.id.chronometer1)).start();		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onClearButtonClick(View view) {
		PaintBrushView canvas = (PaintBrushView) findViewById(R.id.paintBrush);
		canvas.init();
		canvas.invalidate();
	}

	public void startChronometer(View view) {
		
	}

}
