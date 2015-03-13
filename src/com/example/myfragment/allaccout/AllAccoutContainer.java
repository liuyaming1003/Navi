package com.example.myfragment.allaccout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragment.R;
import com.example.myfragment.ui.TabBasicFragment;

public class AllAccoutContainer extends TabBasicFragment {
	private boolean mIsViewInited = false;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab_fragment, container, false);

		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if (!mIsViewInited) {
			mIsViewInited = true;
			initView();
		}
	}
	
	private void initView(){
		pushFragment(this, new AllAccoutVC(), null, false, false);
	}
}
