package com.example.myfragment.fragment;

import com.example.myfragment.R;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public abstract class NavigationFragment extends FragmentViewController {
	private Button leftBtn;
	private Button rightBtn;
	private TextView titleTv;
	protected boolean isCanBack = true;
	
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

		leftBtn = (Button)view.findViewById(R.id.left_button);
		if(leftBtn != null){
			leftBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					leftBar(v);
				}
			});
		}

		rightBtn = (Button)view.findViewById(R.id.right_button);
		if(rightBtn != null){
			rightBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					rightBar(v);
				}
			});
		}

		titleTv = (TextView)view.findViewById(R.id.title_textview);
		if(titleTv != null){

		}


		super.onViewCreated(view, savedInstanceState);
	}

	/**
	 * 设置左边按钮文字
	 * @param text
	 */
	protected void setLeftText(String text){
		if(leftBtn != null){
			leftBtn.setText(text);
		}
	}

	/**
	 * 设置左边按钮图片
	 * @param drawableId 当为-1时隐藏按钮
	 */
	protected void setLeftBg(int drawableId){
		if(leftBtn != null){
			if(drawableId == -1){
				isCanBack = false;
				leftBtn.setVisibility(View.INVISIBLE);
			}else{
				Drawable drawable= getResources().getDrawable(drawableId);
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
				leftBtn.setCompoundDrawables(drawable, null, null, null);
			}
		}
	}

	/**
	 * 设置右边按钮文字
	 * @param text
	 */
	protected void setRightText(String text){
		if(rightBtn != null){
			rightBtn.setText(text);
		}
	}

	/**
	 * 设置右边按钮图片
	 * @param drawableId
	 */
	protected void setRightBg(int drawableId){
		if(rightBtn != null){
			if(drawableId == -1){
				rightBtn.setVisibility(View.INVISIBLE);
			}else{
				Drawable drawable= getResources().getDrawable(drawableId);
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
				rightBtn.setCompoundDrawables(drawable, null, null, null);
			}
		}
	}

	/**
	 * 设置中间按钮文字
	 * @param text
	 */
	protected void setTitleText(String text){
		if(titleTv != null){
			titleTv.setText(text);
		}
	}

	public void leftBar(View view){
		pop();
	}
	public void rightBar(View view){
		popToRoot();
	}
}
