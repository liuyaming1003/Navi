package com.example.myfragment.allaccout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragment.R;
import com.example.myfragment.ui.BasicFragment;

public class AllAccoutVC extends BasicFragment {
	private View rootView;
	@SuppressLint("InflateParams") @Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		//View view = inflater.inflate(R.layout.vc_all_exams, container, false);
		if(rootView==null){  
			rootView=inflater.inflate(R.layout.vc_all_accout, null);  
		}  
		ViewGroup parent = (ViewGroup) rootView.getParent();  
		if (parent != null) {  
			parent.removeView(rootView);  
		}   
		return rootView;  
	}
}
