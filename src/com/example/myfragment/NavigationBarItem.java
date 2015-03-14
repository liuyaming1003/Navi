package com.example.myfragment;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;

public class NavigationBarItem extends CustomButton{
	protected float scale;
	public NavigationBarItem(Context context) {
		super(context);
		initItem(context);
	}
	
	protected void initItem(Context context){
		scale = context.getResources().getDisplayMetrics().density;
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
		params.gravity = Gravity.CENTER_VERTICAL;
		setLayoutParams(params);
		System.out.println("scale = " + scale + " text*****************");
		int padding = dpToPx(10);
		setCompoundDrawablePadding(padding);
	}
	
	protected final int dpToPx(int dpValue){
		return (int)(dpValue * scale + 0.5f);
	}
	
	@Override
	public void setBtnImgText(int imgId, String text, int lrtm) {
		switch (lrtm) {
		case Gravity.LEFT:
		case Gravity.RIGHT:
		case Gravity.TOP:
		case Gravity.BOTTOM:
			break;
		default:
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
			params.gravity = Gravity.CENTER_VERTICAL;
			setLayoutParams(params);
			break;
		}
		
		super.setBtnImgText(imgId, text, lrtm);
	}
}
