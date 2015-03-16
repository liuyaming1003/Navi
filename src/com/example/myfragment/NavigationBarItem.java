package com.example.myfragment;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;

public class NavigationBarItem extends CustomButton{
	protected float scale;
	public NavigationBarItem(Context context) {
		super(context);
		initItem(context);
		setBackgroundColor(Color.RED);
	}

	protected void initItem(Context context){
		scale = context.getResources().getDisplayMetrics().density;

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
		params.gravity = Gravity.CENTER_VERTICAL;
		setLayoutParams(params);
		int padding = dpToPx(5);
		setCompoundDrawablePadding(padding);
	}

	protected final int dpToPx(int dpValue){
		return (int)(dpValue * scale + 0.5f);
	}

	/*	@Override
	public void setBtnImgText(int imgId, String text, int lrtm) {
//		if(text == null || text.length() == 0){
//			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//			params.gravity = Gravity.CENTER_VERTICAL;
//			setLayoutParams(params);
//		}
		switch (lrtm) {
		case Gravity.LEFT:
		case Gravity.RIGHT:
		case Gravity.TOP:
		case Gravity.BOTTOM:
			break;
		default:
			break;
		}

		super.setBtnImgText(imgId, text, lrtm);
	}
	 */
}
