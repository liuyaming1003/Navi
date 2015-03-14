package com.example.myfragment.allaccout;

import com.example.myfragment.R;
import com.example.myfragment.fragment.TabBasicFragment;

public class AllAccoutContainer extends TabBasicFragment {
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.tab_fragment;
	}

	@Override
	protected void initTabView() {
		// TODO Auto-generated method stub
		pushFragment(this, new AllAccoutVC(), null, false, false);
	}

	@Override
	protected int getFragmentId() {
		// TODO Auto-generated method stub
		return R.id.tab_fragment;
	}
}
