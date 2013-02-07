package edu.upenn.cis350;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PaletteView extends View {

	protected ArrayList<ShapeDrawable> squares;
	protected ArrayList<ShapeDrawable> rectangles;

	protected int[] colors;
	public static Paint p;
	protected Paint ptext;
	protected FontMetrics fm;
	protected final int SQUARE_WIDTH = 30;
	protected int TXT_WIDTH_THIN;
	protected int TXT_WIDTH_THICK;

	protected final int TXT_POS_THIN = 220;
	protected final int TXT_POS_THICK = 280;

	public PaletteView(Context context) {
		super(context);
		init();
	}

	public PaletteView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	protected void init() {
		fm = new FontMetrics();
		p = new Paint();
		setUpColorPalette();
		setUpThickThin();

	}

	private void setUpThickThin() {
		ptext = new Paint();
		ptext.setTextAlign(Paint.Align.CENTER);
		ptext.getFontMetrics(fm);
		TXT_WIDTH_THIN = (int) (ptext.measureText("thin") / 2);
		TXT_WIDTH_THICK = (int) (ptext.measureText("thick") / 2);
		int[] b = new int[]{TXT_POS_THIN, TXT_WIDTH_THIN, 
							TXT_POS_THICK, TXT_WIDTH_THICK };

		rectangles = new ArrayList<ShapeDrawable>();
		for (int i = 0; i<2; i++){
			rectangles.add(new ShapeDrawable(new RectShape()));
			rectangles.get(i).getPaint().setColor(Color.LTGRAY);
			rectangles.get(i).setBounds(b[2*i] - b[2*i+1] - 10, SQUARE_WIDTH, b[2*i] + b[2*i+ 1]+ 10, 30 + SQUARE_WIDTH );
		}
		
	}

	private void setUpColorPalette() {
		colors = new int[] { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW,
				Color.BLACK };
		squares = new ArrayList<ShapeDrawable>();
		for (int i = 0; i < 5; i++) {
			squares.add(new ShapeDrawable(new RectShape()));
			squares.get(i).setBounds(SQUARE_WIDTH * (i + 1), SQUARE_WIDTH,
					SQUARE_WIDTH * (i + 2), 30 + SQUARE_WIDTH);
			squares.get(i).getPaint().setColor(colors[i]);
		}
	}

	protected void onDraw(Canvas canvas) {

		// draw the square
		for (ShapeDrawable square : squares)
			square.draw(canvas);

		// draw thick + thin
		ptext.setTextSize(20);
		for (ShapeDrawable rect :rectangles)
			rect.draw(canvas);
		canvas.drawText("thin", TXT_POS_THIN,
				60 + (fm.ascent - fm.descent) / 2, ptext);
		canvas.drawText("thick", TXT_POS_THICK,
				60 + (fm.ascent - fm.descent) / 2, ptext);

	}

	public boolean onTouchEvent(MotionEvent e) {
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			int x = (int) e.getX();
			int y = (int) e.getY();

			if (y > SQUARE_WIDTH && y < 30 + SQUARE_WIDTH) {
				// check bounds of color palette
				for (int i = 0; i < 5; i++) {
					if (x > (SQUARE_WIDTH*(i + 1)) && 
						x < (SQUARE_WIDTH*(i + 2))) {
						p.setColor(colors[i]);
						invalidate();
						return true;
					}
				}
				// check bounds of thick/thin
				if (x > (TXT_POS_THIN - TXT_WIDTH_THIN - 10)
						&& x < (TXT_POS_THIN + TXT_WIDTH_THIN + 10)){
					p.setStrokeWidth(2);
					invalidate();
					return true;
				}
				if (x > (TXT_POS_THICK - TXT_WIDTH_THICK - 10)
						&& x < (TXT_POS_THICK + TXT_WIDTH_THICK + 10)){
					p.setStrokeWidth(6);
					invalidate();
					return true;
				}

			}

		}
		return false;
	}

}
