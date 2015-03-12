package com.example.myfragment.ui;

import com.example.myfragment.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends NavigationFragment {
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_fragment, container, false);
		Button btn = (Button) view.findViewById(R.id.button);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				NextFragment.index = 1;
				switchFragmentListener.push(MainFragment.this, new NextFragment(), null, true);
			}
		});
		
		return view;
	}
	
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		setLeftBg(R.drawable.barbutton_settings);
		setRightBg(R.drawable.barbutton_login);
		setTitleText("社区银行");
	}
}
