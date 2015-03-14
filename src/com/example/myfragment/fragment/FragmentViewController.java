package com.example.myfragment.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentViewController extends BasicFragment {
	/**
	 * 避免Fragment来回切换重复生成UI
	 */
	protected View rootView;

	@SuppressLint("InflateParams") 
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if(rootView==null){  
			rootView= getRootView(inflater, container, savedInstanceState);  
		}  
		ViewGroup parent = (ViewGroup) rootView.getParent();  
		if (parent != null) {  
			parent.removeView(rootView);  
		}   

		return rootView;
	}

	public abstract View getRootView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
	
	protected final void push(Fragment fragment, Fragment nextFragment, Bundle bundle, boolean isCanBack){
		((TabBasicFragment)getParentFragment()).pushFragment(fragment, nextFragment, bundle, isCanBack);
	}

	protected final void push(Fragment fragment, Fragment nextFragment, Bundle bundle, boolean isCanBack, boolean anim){
		((TabBasicFragment)getParentFragment()).pushFragment(fragment, nextFragment, bundle, isCanBack, anim);
	}

	protected final void present(Fragment nextFragment, Bundle bundle, boolean isCanBack){
		((TabBasicFragment)getParentFragment()).presentFragment(nextFragment, bundle, isCanBack);
	}

	protected final void present(Fragment nextFragment, Bundle bundle, boolean isCanBack, boolean anim){
		((TabBasicFragment)getParentFragment()).presentFragment(nextFragment, bundle, isCanBack, anim);
	}

	protected final void pop(){
		((TabBasicFragment)getParentFragment()).popFragment();
	}
	
	protected final void popToRoot(){
		((TabBasicFragment)getParentFragment()).popToRootFragment();
	}
	
	protected final void popToFragment(int atIndex){
		((TabBasicFragment)getParentFragment()).popToAtFragment(atIndex);
	}
}
