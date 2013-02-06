package edu.upenn.cis350;

import android.graphics.Paint;

public class Line {

	private int startX;
	private int startY;
	private int stopX;
	private int stopY;
	private Paint p;

	public Line(int startX, int startY, int stopX, int stopY, Paint p) {
		this.stopX = stopX;
		this.startY = startY;
		this.stopY = stopY;
		this.startX = startX;
		this.p = p;

	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public int getStopX() {
		return stopX;
	}

	public int getStopY() {
		return stopY;
	}

	public Paint getP() {
		return p;
	}


}
