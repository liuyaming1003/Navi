package com.example.myfragment.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.myfragment.NavigationBarItem;
import com.example.myfragment.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class NavigationController extends FragmentViewController {
	private String title = "";
	private RelativeLayout navigationLayout;
	private LinearLayout leftLLayout;
	private LinearLayout midLLayout;
	private LinearLayout rightLLayout;

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

		navigationLayout = (RelativeLayout) view.findViewById(R.id.navigation_relativeLayout);
		leftLLayout = (LinearLayout) view.findViewById(R.id.leftLLayout);
		midLLayout = (LinearLayout) view.findViewById(R.id.midLLayout);
		rightLLayout = (LinearLayout) view.findViewById(R.id.rightLLayout);

		addDefaultLeftBarItem();

		super.onViewCreated(view, savedInstanceState);
	}

	/**
	 * 设置NavigationBar的 Title
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param title
	 * @return       void 
	 * @throws       none
	 */
	protected final void setTitle(String title){
		if(midLLayout != null){
			midLLayout.removeAllViews();
			TextView titleView = new TextView(getActivity());
			titleView.setText(title);
			titleView.setTextSize(17);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
			params.weight = 1.0f;
			titleView.setLayoutParams(params);
			titleView.setBackgroundColor(Color.RED);
			titleView.setGravity(Gravity.CENTER);
			midLLayout.addView(titleView);

			this.title = title;
		}
	}

	/**
	 * 获取Title
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @return
	 * @return       String 
	 * @throws       none
	 */
	public final String getTitle(){
		return this.title;
	}

	/**
	 * 设置是否隐藏navigationBar, 有动画效果
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param hidden
	 * @return       void 
	 * @throws       none
	 */
	protected final void setNavigationHidden(boolean hidden){
		setNavigationHidden(hidden, true);
	}

	/**
	 * 设置是否隐藏navigationBar
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param hidden  是否隐藏
	 * @param        @param anim    是否添加动画
	 * @return       void 
	 * @throws       none
	 */
	protected final void setNavigationHidden(boolean hidden, boolean anim){
		if(navigationLayout != null){
			if(hidden == true){
				if(anim == true){
					navigationLayout.clearAnimation();
					Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.navigationbar_dismiss);
					navigationLayout.setAnimation(animation);
				}
				navigationLayout.setVisibility(View.GONE);
			}else{
				if(anim == true){
					navigationLayout.clearAnimation();
					Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.navigationbar_show);
					navigationLayout.setAnimation(animation);
				}
				navigationLayout.setVisibility(View.VISIBLE);
			}
		}
	}

	/**
	 * 设置NavigationController View
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param view
	 * @return       void 
	 * @throws       none
	 */
	protected final void setView(@NonNull View view){
		setLayoutView(navigationLayout, view);
	}

	/**
	 * 设置TitleView
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param view
	 * @return       void 
	 * @throws       none
	 */
	protected final void setTitleView(@NonNull View view){
		setLayoutView(midLLayout, view);
	}

	/**
	 * 设置左边View
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param view
	 * @return       void 
	 * @throws       none
	 */
	protected final void setLeftView(@NonNull View view){
		setLayoutView(leftLLayout, view);
	}

	/**
	 * 设置右边View
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param view
	 * @return       void 
	 * @throws       none
	 */
	protected final void setRightView(@NonNull View view){
		setLayoutView(rightLLayout, view);
	}

	private void setLayoutView(RelativeLayout layout, View view){
		if(layout != null){
			layout.removeAllViews();
			layout.addView(view);
		}
	}

	private void setLayoutView(LinearLayout layout, View view){
		if(layout != null){
			layout.removeAllViews();
			layout.addView(view);
		}
	}

	private List<Fragment> removeEmptyForList(List<Fragment> list) {  
		List<Fragment> fragmentList = new ArrayList<Fragment>(); 

		if(list==null||list.size()<=0)  
			return null;  
		//循环第一层  
		for(int i=0;i<list.size();i++) {  
			//进入每一个list  
			Fragment fragment = (Fragment) list.get(i);  
			if(fragment != null)  
				fragmentList.add(fragment);  
			System.out.println("no null count = " + fragmentList.size());  
		}  

		return fragmentList;  
	} 

	/**
	 * 查找Fragment栈中有效的Fragment的上一个Fragment
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param list
	 * @param        @return
	 * @return       Fragment 
	 * @throws       none
	 */
	private Fragment getLastValidFragment(List<Fragment> list){
		Fragment fragment = null;
		System.out.println("list = " + list);
		List<Fragment> fragmentList = removeEmptyForList(list);
		if(fragmentList != null){
			int size = fragmentList.size();
			if(size >= 2){
				//返回倒数第二个Fragment
				return fragmentList.get(size - 2);
			}
		}
		return fragment;
	}

	/**
	 * 在Fragment切换时,默认添加返回按钮
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        
	 * @return       void 
	 * @throws       none
	 */
	private void addDefaultLeftBarItem(){
		FragmentManager fm = getParentFragment().getChildFragmentManager();
		System.out.println("navigation Count = " + fm.getBackStackEntryCount());
		List<Fragment> list = fm.getFragments();
		if(list.size() > 1){
			NavigationBarItem item = new NavigationBarItem(getActivity());
			Fragment fragment = getLastValidFragment(list);
			String backText = "";
			if(fragment != null && fragment instanceof NavigationController){
				backText = ((NavigationController) fragment).getTitle();
			}
			item.setBtnImgText(R.drawable.navigation_back_bg, backText, Gravity.LEFT);
			setLeftBarItem(item);

			item.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					pop();					
				}
			});
		}
	}

	/**
	 * 添加左边Item, 可以为多个参数
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param items
	 * @return       void 
	 * @throws       none
	 */
	protected final void setLeftBarItem(NavigationBarItem... items){
		setBarItem(leftLLayout, items);
	}

	/**
	 * 添加右边item, 可以为多个参数
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param items
	 * @return       void 
	 * @throws       none
	 */
	protected final void setRightBarItem(NavigationBarItem... items){
		setBarItem(rightLLayout, items);
	}

	/**
	 * 添加item
	 * @Title        NavigationController 
	 * @Description  TODO
	 * @param        @param layout
	 * @param        @param items
	 * @return       void 
	 * @throws       none
	 */
	private void setBarItem(LinearLayout layout, NavigationBarItem... items){
		if(layout == null){
			return ;
		}
		layout.removeAllViews();

		for(NavigationBarItem item : items){
			layout.addView(item);
		}
	}
}
