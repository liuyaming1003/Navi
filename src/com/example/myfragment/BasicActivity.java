package com.example.myfragment;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class BasicActivity extends FragmentActivity {
	protected Fragment customFragment;
	protected final void pushFragment(int viewId, Fragment fragment, Fragment nextFragment, Bundle bundle, boolean isCanBack){
		FragmentManager fm = customFragment.getChildFragmentManager();
		FragmentTransaction ft =  fm.beginTransaction();
		ft.setCustomAnimations(
				R.anim.navigation_push_in,
				R.anim.navigation_push_out,
				R.anim.navigation_pop_in,
				R.anim.navigation_pop_out);
		ft.hide(fragment);
		if(bundle != null){
			nextFragment.setArguments(bundle);
		}
		ft.add(viewId, nextFragment);
		if(isCanBack == true){
			ft.addToBackStack(null);
		}
		ft.commit();
	}
	
	protected final void presentFragment(int viewId, Fragment fragment, Fragment nextFragment, Bundle bundle, boolean isCanBack){
		FragmentManager fm = customFragment.getChildFragmentManager();
		FragmentTransaction ft =  fm.beginTransaction();
		ft.setCustomAnimations(
				R.anim.present_show_in,
				R.anim.present_show_out,
				R.anim.present_dismiss_in,
				R.anim.present_dismiss_out);
		ft.hide(fragment);
		if(bundle != null){
			nextFragment.setArguments(bundle);
		}
		ft.add(viewId, nextFragment);
		if(isCanBack == true){
			ft.addToBackStack(null);
		}
		ft.commit();
	}
	
	protected final void popFragment(){
		FragmentManager fm = customFragment.getChildFragmentManager();
		fm.popBackStack();
	}
	
	protected final void popToRootFragment(){
		FragmentManager fm = customFragment.getChildFragmentManager();
		int count = fm.getBackStackEntryCount();
		while (true) {
			if(count-- == 0){
				break;
			}
			fm.popBackStack();
		}
	}
	
	protected final void popToAtFragment(int index){
		FragmentManager fm = customFragment.getChildFragmentManager();
		fm.popBackStack();
		int count = fm.getBackStackEntryCount();
		if(index >= 0 && index < count){
			while(true){
				if(count-- == index + 1){
					break;
				}
				fm.popBackStack();
			}
		}
	}
	
	//点击空白处隐藏键盘
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {  
			// 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）  
			View v = getCurrentFocus();  

			if (isShouldHideInput(v, ev)) {  
				hideSoftInput(v.getWindowToken());  
			}  
		}  
		return super.dispatchTouchEvent(ev);
	}

	/** 
	 * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏 
	 *  
	 * @param v 
	 * @param event 
	 * @return 
	 */  
	private boolean isShouldHideInput(View v, MotionEvent event) {  
		if (v != null && (v instanceof EditText)) {  
			int[] l = { 0, 0 };  
			v.getLocationInWindow(l);  
			int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left  
					+ v.getWidth();  
			if (event.getX() > left && event.getX() < right  
					&& event.getY() > top && event.getY() < bottom) {  
				// 点击EditText的事件，忽略它。  
				return false;  
			} else {  
				return true;  
			}  
		}  
		// 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点  
		return false;  
	}  

	/** 
	 * 多种隐藏软件盘方法的其中一种 
	 *  
	 * @param token 
	 */  
	private void hideSoftInput(IBinder token) {  
		if (token != null) {  
			InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);  
			if(im.isActive()){
				im.hideSoftInputFromWindow(token,  
						InputMethodManager.HIDE_NOT_ALWAYS);  
			}
		}  
	} 
}
