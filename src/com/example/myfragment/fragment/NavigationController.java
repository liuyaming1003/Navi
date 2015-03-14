package com.example.myfragment.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.myfragment.NavigationBarItem;
import com.example.myfragment.R;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class NavigationController extends FragmentViewController {
	private String title = "";
	private LinearLayout leftLLayout;
	private LinearLayout midLLayout;
	private LinearLayout rightLLayout;
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

		leftLLayout = (LinearLayout) view.findViewById(R.id.leftLLayout);
		midLLayout = (LinearLayout) view.findViewById(R.id.midLLayout);
		rightLLayout = (LinearLayout) view.findViewById(R.id.rightLLayout);

		addDefaultLeftBarItem();

		super.onViewCreated(view, savedInstanceState);
	}

	protected void setTitle(String title){
		if(midLLayout != null){
			midLLayout.removeAllViews();
			TextView titleView = new TextView(getActivity());
			titleView.setText(title);
			titleView.setTextSize(17);
			LayoutParams params = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
			params.gravity = Gravity.CENTER;
			midLLayout.addView(titleView, params);
			
			this.title = title;
		}
	}
	
	public String getTitle(){
		return this.title;
	}

	protected void setTitleView(@NonNull View view){
		if(midLLayout != null){
			midLLayout.removeAllViews();
			midLLayout.addView(view);
		}
	}

	private void addDefaultLeftBarItem(){
		NavigationBarItem item = new NavigationBarItem(getActivity());
		item.setBtnImgText(R.drawable.navigation_back_bg, "返回", Gravity.LEFT);
		setLeftBarItem(item);
	}

	@SuppressWarnings("serial")
	protected void setLeftBarItem(final NavigationBarItem item){
		setLeftBarItem(new ArrayList<NavigationBarItem>(){
			{add(item);}
		});
	}

	protected void setLeftBarItem(final List<NavigationBarItem> items){
		setBarItem(items, leftLLayout);
	}

	@SuppressWarnings("serial")
	protected void setRightBarItem(final NavigationBarItem item){
		setRightBarItem(new ArrayList<NavigationBarItem>(){
			{add(item);}
		});
	}

	protected void setRightBarItem(final List<NavigationBarItem> items){
		setBarItem(items, rightLLayout);
	}

	private void setBarItem(final List<NavigationBarItem> items, LinearLayout layout){
		if(layout == null){
			return ;
		}
		layout.removeAllViews();
		for (int i = 0; i < items.size(); i++) {

			layout.addView(items.get(i));
		}
	}
}
