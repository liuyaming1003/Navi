package com.example.myfragment.allexams;

import com.example.myfragment.R;
import com.example.myfragment.fragment.TabBasicFragment;

public class AllExamsContainer extends TabBasicFragment {
	
	@Override
	protected void initTabView() {
		pushFragment(this, new AllExamsVC(), null, false, false);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.tab_fragment;
	}
	
	@Override
	protected int getFragmentId() {
		// TODO Auto-generated method stub
		return R.id.tab_fragment;
	}
}
