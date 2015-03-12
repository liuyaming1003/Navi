package com.example.myfragment.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragment.MainActivity;
import com.example.myfragment.R;

public class AllExamsVC extends NavigationFragment {
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.vc_all_exams, container, false);

		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);

		setLeftBg(R.drawable.barbutton_settings);
		setRightBg(R.drawable.barbutton_login);
		setTitleText("All");
		
		((MainActivity)getActivity()).setFragmentLayout(R.id.fragment);
	}
}
