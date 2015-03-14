package com.example.myfragment.allupload;

import com.example.myfragment.R;
import com.example.myfragment.fragment.TabBasicFragment;

public class AllUploadContainer extends TabBasicFragment {

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.tab_fragment;
	}

	@Override
	protected void initTabView() {
		// TODO Auto-generated method stub
		pushFragment(this, new AllUploadVC(), null, false, false);
	}
	
	@Override
	protected int getFragmentId() {
		// TODO Auto-generated method stub
		return R.id.tab_fragment;
	}
}
