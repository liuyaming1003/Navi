package com.example.myfragment.allaccout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragment.MainActivity;
import com.example.myfragment.R;
import com.example.myfragment.allexams.ExamsDetail;
import com.example.myfragment.fragment.NavigationFragment;

public class AllAccoutVC extends NavigationFragment {
	@Override
	public View getRootView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.vc_all_accout, container, false);
		view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				push(AllAccoutVC.this, new ExamsDetail(), null, true);
			}
		});
		return view;
	}
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		
		System.out.println("hidden = " + hidden);
		((MainActivity) getActivity()).hiddenTabHost(hidden);
		super.onHiddenChanged(hidden);
	}
}
