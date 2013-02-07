package edu.upenn.cis350;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class PaintBrushView extends View {

	private int x;
	private int y;
	


	private ArrayList<Line> lines;

	public PaintBrushView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();

	}

	public PaintBrushView(Context context) {
		super(context);
		init();

	}

	public void init() {
		lines = new ArrayList<Line>();
	}

	public boolean onTouchEvent(MotionEvent e) {

		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			Log.i("PaintBrushView", "ACTION DOWN");
			x = (int) e.getX();
			y = (int) e.getY();
			Line l = new Line(x, y, x, y, new Paint(PaletteView.p));
			lines.add(l);
			invalidate();
			return true;
		} else if (e.getAction() == MotionEvent.ACTION_MOVE) {
			Log.i("PaintBrushView", "ACTION MOVE");
			Line l = new Line(x, y, (x = (int) e.getX()), (y = (int) e.getY()),
					new Paint(PaletteView.p));
			lines.add(l);
			invalidate();
			return true;
		} else if (e.getAction() == MotionEvent.ACTION_UP) {
			Line l = new Line(x, y, (x = (int) e.getX()), (y = (int) e.getY()),
					new Paint(PaletteView.p));
			lines.add(l);
			invalidate();
			return true;
		}
		return false;
	}

	protected void onDraw(Canvas canvas) {
		for (Line l : lines)
			canvas.drawLine(l.getStartX(), l.getStartY(), l.getStopX(),
					l.getStopY(), l.getP());

	}

}
