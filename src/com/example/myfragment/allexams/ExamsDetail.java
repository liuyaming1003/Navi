package com.example.myfragment.allexams;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragment.R;
import com.example.myfragment.ui.NavigationFragment;

public class ExamsDetail extends NavigationFragment {
	private View rootView;
	@SuppressLint("InflateParams") @Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if(rootView==null){  
            rootView=inflater.inflate(R.layout.vc_all_exams_detail, null);  
        }  
        ViewGroup parent = (ViewGroup) rootView.getParent();  
        if (parent != null) {  
            parent.removeView(rootView);  
        }   
        
        return rootView;  
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if(savedInstanceState == null){
			setLeftBg(R.drawable.navigation_back_bg);
			setRightBg(R.drawable.navigation_home_bg);
			setTitleText("详情");
		}
	}
}
