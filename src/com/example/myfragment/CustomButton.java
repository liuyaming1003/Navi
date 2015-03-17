package com.example.myfragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Button;

public class CustomButton extends Button{
	private enum ButtonStyle{
		Normal_Style,                   /*正常*/
		Switch_Style                    /*按下切换图片*/
	}
	private ButtonStyle style = ButtonStyle.Normal_Style;/*默认正常情况*/
	private int imgGravity;                              /*记录图片显示位置*/
	private Drawable normalDrawable = null;              /*图片正常*/
	private Drawable pressDrawable = null;               /*图片按下*/
	
	private boolean isSwitch = false;                    /*是否切换图片*/
	private Drawable switchDrawable = null;              /*切换图片*/  
	private OnSwitchListener switchListener = null;      /*监听切换*/
	
	public CustomButton(Context context) {
		super(context);
		
		setBackgroundColor(Color.TRANSPARENT);
	}
	
	/**
	 * 设置切换图片, style 为 Switch_Style
	 * @Title        CustomButton 
	 * @Description  TODO
	 * @param        @param normalImgId  正常图片
	 * @param        @param switchImgId  切换图片
	 * @param        @param text         文子信息
	 * @param        @param gravity      图片位置
	 * @return       void 
	 * @throws       none
	 */
	public void setSwitchImgText(int normalImgId, int switchImgId, String text, int gravity){
		imgGravity = gravity;
		normalDrawable = getResources().getDrawable(normalImgId);
		switchDrawable = getResources().getDrawable(switchImgId);
		style = ButtonStyle.Switch_Style;
		
		setText(text);
		setDrawable(normalDrawable);
	}
	
	/**
	 * 设置监听, Switch_Style 下有效
	 * @Title        CustomButton 
	 * @Description  TODO
	 * @param        @param switchListener
	 * @return       void 
	 * @throws       none
	 */
	public void setOnSwitchListener(OnSwitchListener switchListener){
		this.switchListener = switchListener;
	}
	
	/**
	 * 重置Button状态, Switch_Style 下有效
	 * @Title        CustomButton 
	 * @Description  TODO
	 * @param        
	 * @return       void 
	 * @throws       none
	 */
	public void setOnSwitchNormal(){
		setDrawable(normalDrawable);
		isSwitch = false;
		if(this.switchListener != null){
			switchListener.switchBtn(this, isSwitch);
		}
	}
	
	/**
	 * 设置图片信息
	 * @Title        CustomButton 
	 * @Description  TODO
	 * @param        @param normalImgId
	 * @param        @param text
	 * @param        @param gravity
	 * @return       void 
	 * @throws       none
	 */
	public void setBtnImgText(int normalImgId, String text, int gravity){
		imgGravity = gravity;
		normalDrawable = getResources().getDrawable(normalImgId);
		
		style = ButtonStyle.Normal_Style;
		
		setText(text);
		setDrawable(normalDrawable);
	}
	
	/**
	 * 设置图片信息
	 * @Title        CustomButton 
	 * @Description  TODO
	 * @param        @param normalImgId
	 * @param        @param pressImgId
	 * @param        @param text
	 * @param        @param gravity
	 * @return       void 
	 * @throws       none
	 */
	public void setBtnImgText(int normalImgId, int pressImgId, String text, int gravity){
		imgGravity = gravity;
		normalDrawable = getResources().getDrawable(normalImgId);
		pressDrawable = getResources().getDrawable(pressImgId);
		
		style = ButtonStyle.Normal_Style;
		
		setText(text);
		setDrawable(normalDrawable);
	}
	
	private void setDrawable(Drawable drawable){
		if(drawable == null){
			return;
		}
		drawable.setBounds(0, 0, normalDrawable.getMinimumWidth(), normalDrawable.getMinimumHeight());
		switch (imgGravity) {
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
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (style) {
		case Normal_Style:
			if(event.getAction() == MotionEvent.ACTION_DOWN){
				setDrawable(pressDrawable);
			}else if(event.getAction() == MotionEvent.ACTION_UP){
				setDrawable(normalDrawable);
			}
			break;
		case Switch_Style:
			if(event.getAction() == MotionEvent.ACTION_UP){
				isSwitch = !isSwitch;
				if(isSwitch == true){
					setDrawable(switchDrawable);
				}else{
					setDrawable(normalDrawable);
				}
				if(this.switchListener != null){
					switchListener.switchBtn(this, isSwitch);
				}
			}
			break;
		default:
			break;
		}
		
		return super.onTouchEvent(event);
	}
	
	public interface OnSwitchListener{
		public void switchBtn(final CustomButton button, final boolean isSwitch);
	}
}
