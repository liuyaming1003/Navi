package com.example.myfragment.allshare;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myfragment.MainActivity;
import com.example.myfragment.R;
import com.example.myfragment.allexams.ExamsDetail;
import com.example.myfragment.fragment.NavigationFragment;

public class AllShareVC extends NavigationFragment {
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if(savedInstanceState == null){
			setRightBg(R.drawable.navigation_home_bg);
			setTitleText("全部分享");
		}
	}
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		
		System.out.println("hidden = " + hidden);
		((MainActivity) getActivity()).hiddenTabHost(hidden);
		super.onHiddenChanged(hidden);
	}
	

	@SuppressLint("InflateParams") 
	@Override
	public View getRootView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.vc_all_share, null);
		Button button = (Button) view.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				push(AllShareVC.this, new ExamsDetail(), null, true);
			}
		});
		
		return view;
	}
}
