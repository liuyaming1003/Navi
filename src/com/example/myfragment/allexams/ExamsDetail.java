package com.example.myfragment.allexams;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragment.R;
import com.example.myfragment.fragment.NavigationFragment;

public class ExamsDetail extends NavigationFragment {
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if(savedInstanceState == null){
			setLeftBg(R.drawable.navigation_back_bg);
			setRightBg(R.drawable.navigation_home_bg);
			setTitleText("详情");
		}
	}

	@SuppressLint("InflateParams") 
	@Override
	public View getRootView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.vc_all_exams_detail, null);
		view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				push(ExamsDetail.this, new ExamsDetail(), null, true);				
			}
		});
		
		return view;
	}
}
