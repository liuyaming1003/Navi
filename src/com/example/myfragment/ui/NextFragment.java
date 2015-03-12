package com.example.myfragment.ui;

import com.example.myfragment.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NextFragment extends NavigationFragment {
	public static int index = 1;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.next_fragment, container, false);

		view.findViewById(R.id.prov).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(index == 10){
					switchFragmentListener.popToFragment(1);
				}else{
					switchFragmentListener.pop();
				}
			}
		});

		view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				switchFragmentListener.push(NextFragment.this, new NextFragment(), null, true);
			}
		});

		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText("这是第 " + index++ + " 个Fragment");

		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);

		setLeftBg(R.drawable.navigation_back_bg);
		setRightBg(R.drawable.navigation_home_bg);
		setTitleText("燃气充值");
	}
}