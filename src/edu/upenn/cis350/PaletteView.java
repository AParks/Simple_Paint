package edu.upenn.cis350;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PaletteView extends View {

	protected ArrayList<ShapeDrawable> squares;
	protected int[] colors;
	protected Paint p;

	public PaletteView(Context context) {
		super(context);
		init();
	}

	public PaletteView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	protected void init() {
		p = new Paint();
		colors = new int[] { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW,
				Color.BLACK };
		squares = new ArrayList<ShapeDrawable>();

		for (int i = 0; i < 5; i++) {
			squares.add(new ShapeDrawable(new RectShape()));
			squares.get(i).setBounds(30 *(i + 1), 30, 30 * (i + 2), 60);
			squares.get(i).getPaint().setColor(colors[i]);
		}

	}

	protected void onDraw(Canvas canvas) {

		// draw the square
		for (ShapeDrawable square : squares)
			square.draw(canvas);
	}

	public boolean onTouchEvent(MotionEvent e) {
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			int x = (int) e.getX();
			int y = (int) e.getY();
			for (int i = 0; i < 5; i++) {

				if (x > (20 *(i + 1)) && x < (20 *(i + 2)) && y > 20 && y < 40) {
					p.setColor(colors[i]);
					return true;
				}
			}

		}
		return false;
	}

}
