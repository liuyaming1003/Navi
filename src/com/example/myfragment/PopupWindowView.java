package com.example.myfragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class PopupWindowView {
	private PopupWindow popupWindow;

	/**
	 * 弹出PopupWindow
	 * @Title        PopupWindowView 
	 * @Description  TODO
	 * @param        @param atView    位置atView
	 * @param        @param showView  弹出的视图
	 * @param        @param width     popupWindow 宽度
	 * @param        @param height    popupWindow 高度
	 * @param        @param gravity   弹出视图相对于屏幕的位置，参考 @class Gravity
	 * @param        @param atViewGravity 相对于atView的位置, 支持四个方向 LEFT RIGHT TOP BOTTOM
	 * @param        @return
	 * @return       PopupWindow      返回popupWindow,用户处理视图隐藏
	 * @throws       none
	 */
	public PopupWindow show(View atView, View showView, int width, int height, int gravity, int atViewGravity){
		return show(atView, showView, width, height, gravity, atViewGravity, 0);
	}

	/**
	 * 弹出PopupWindow 
	 * @Title        PopupWindowView 
	 * @Description  TODO
	 * @param        @param atView
	 * @param        @param showView
	 * @param        @param width
	 * @param        @param height
	 * @param        @param gravity
	 * @param        @param atViewGravity 
	 * @param        @param edge     边界
	 * @param        @return
	 * @return       PopupWindow 
	 * @throws       none
	 */
	public PopupWindow show(View atView, View showView, int width, int height, int gravity, int atViewGravity, int edge){

		popupWindow = new PopupWindow(showView, width, height);
		popupWindow.setFocusable(true);  
		popupWindow.setOutsideTouchable(true);  
		popupWindow.setBackgroundDrawable(new BitmapDrawable());

		int[] location = new int[2];  
		atView.getLocationOnScreen(location);

		switch (atViewGravity) {
		case Gravity.LEFT:
			popupWindow.showAtLocation(atView, gravity, location[0] - popupWindow.getWidth() , location[1] + edge );
			break;
		case Gravity.TOP:
			popupWindow.showAtLocation(atView, gravity, edge + location[0], location[1] - popupWindow.getHeight());
			break;
		case Gravity.BOTTOM:
			popupWindow.showAtLocation(atView, gravity, edge, location[1] + atView.getHeight());
			break;
		case Gravity.RIGHT:
			popupWindow.showAtLocation(atView, gravity, location[0] + atView.getWidth() + popupWindow.getWidth() , location[1] + edge );
			break;
		case Gravity.FILL:
			popupWindow.showAtLocation(atView, gravity, 0, 0);
			break;
		default:
			break;
		}


		return popupWindow;
	}
	
	public PopupWindow showFill(Context context, View atView, View showView){
		return showFill(context, atView, showView, true);	
	}

	public PopupWindow showFill(Context context, View atView, View showView, boolean isHasStatusBar){
		Screen screen = new Screen(context);
		if(isHasStatusBar == true){
			popupWindow = new PopupWindow(showView, screen.getWidth(), screen.getHeight() - screen.getStatusBarHeight());
		}else{
			popupWindow = new PopupWindow(showView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		}
		
		popupWindow.setFocusable(true);  
		popupWindow.setOutsideTouchable(true);  
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		
		if(isHasStatusBar == true){
			popupWindow.showAtLocation(atView, Gravity.NO_GRAVITY, 0, screen.getStatusBarHeight());
		}else{
			popupWindow.showAtLocation(atView, Gravity.NO_GRAVITY, 0, 0);
		}

		return popupWindow;
	}

	public class Screen {  

		private int width;  
		private int height;  
		private Context context;
		public Screen(Context context) {  
			this.context = context;
			DisplayMetrics metrics = new DisplayMetrics();  
			((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics );  
			width = metrics.widthPixels;  
			height = metrics.heightPixels;  
		}  
		/** 
		 * @return 屏幕宽度 in pixel 
		 */  
		public int getWidth() {  
			return width;  
		}  

		/** 
		 * 
		 * @return 屏幕高度 in pixel 
		 */  
		public int getHeight() {  
			return height;  
		}  

		public int getStatusBarHeight() {  
			int result = 0;  
			int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");  
			if (resourceId > 0) {  
				result = context.getResources().getDimensionPixelSize(resourceId);  
			}  
			return result;  
		} 

		@Override  
		public String toString() {  
			return "Screen{" +  
					"width=" + width +  
					", height=" + height +  
					'}';  
		}  
	}
}
