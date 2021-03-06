package com.example.myfragment.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragment.R;
import com.example.myfragment.ui.NavigationFragment;

public class SettingFragment extends NavigationFragment {
	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if(rootView==null){  
            rootView=inflater.inflate(R.layout.setting_fragment, null);  
        }  
        ViewGroup parent = (ViewGroup) rootView.getParent();  
        if (parent != null) {  
            parent.removeView(rootView);  
        }   
        return rootView;  
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		setLeftBg(R.drawable.navigation_back_bg);
		setRightBg(-1);
		setTitleText("设置");
	}
}
