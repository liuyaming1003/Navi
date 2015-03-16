package com.example.myfragment.allexams;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragment.MainActivity;
import com.example.myfragment.NavigationBarItem;
import com.example.myfragment.R;
import com.example.myfragment.fragment.NavigationController;

public class AllExamsVC extends NavigationController {
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if(savedInstanceState == null){
			setTitle("全部");
			NavigationBarItem item = new NavigationBarItem(getActivity());
			item.setBtnImgText(R.drawable.icn_nav_import, "", Gravity.LEFT);
			
			setLeftBarItem(item);
			
			NavigationBarItem ritemSearch = new NavigationBarItem(getActivity());
			ritemSearch.setBtnImgText(R.drawable.icn_nav_search, "", Gravity.RIGHT);
			
			final NavigationBarItem ritemMore = new NavigationBarItem(getActivity());
			ritemMore.setBtnImgText(R.drawable.icn_nav_more, "", Gravity.RIGHT);
			setRightBarItem(ritemSearch, ritemMore);
			
			final NavigationBarItem midItem = new NavigationBarItem(getActivity());
			midItem.setBtnImgText(R.drawable.icn_nav_filter_expand, "全部", Gravity.RIGHT);
			setTitleView(midItem);
		}
	}
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		
		System.out.println("hidden = " + hidden);
		((MainActivity) getActivity()).hiddenTabHost(hidden);
		super.onHiddenChanged(hidden);
	}

	@SuppressLint("InflateParams") @Override
	public View getRootView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.vc_all_exams, null);
		view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				push(AllExamsVC.this, new ExamsDetail(), null, true);
			}
		});
		return view;
	}
}
