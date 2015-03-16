package com.example.myfragment.allexams;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myfragment.R;
import com.example.myfragment.fragment.NavigationController;

public class ExamsDetail extends NavigationController {
	boolean hidden = false;
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if(savedInstanceState == null){
			setTitle("详情");
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
		
		view.findViewById(R.id.hidden).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				hidden = !hidden;
				setNavigationHidden(hidden, false);
				if(hidden == true){
					((Button)v).setText("显示");
				}else{
					((Button)v).setText("隐藏");
				}
				
			}
		});
		
		return view;
	}
}
