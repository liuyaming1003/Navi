package com.example.myfragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.Button;

public class CustomButton extends Button {
	public CustomButton(Context context) {
		super(context);
		
		setBackgroundColor(Color.TRANSPARENT);
	}
	
	public void setBtnImgText(int imgId, String text, int lrtm){
		Drawable drawable= getResources().getDrawable(imgId);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		setText(text);
		switch (lrtm) {
		case Gravity.LEFT:
			setCompoundDrawables(drawable, null, null, null);
			break;
		case Gravity.RIGHT:
			setCompoundDrawables(null, null, drawable, null);
			break;
		case Gravity.TOP:
			setCompoundDrawables(null, drawable, null, null);
			break;
		case Gravity.BOTTOM:
			setCompoundDrawables(null, null, null, drawable);
			break;
		default:
			setBackgroundDrawable(drawable);
			break;
		}
	}
}
