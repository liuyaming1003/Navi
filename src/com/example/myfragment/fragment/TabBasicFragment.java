package com.example.myfragment.fragment;

import com.example.myfragment.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class TabBasicFragment extends BasicFragment {
	/**
	 * 避免Fragment来回切换重复生成UI
	 */
	protected View rootView;
	
	/**
	 * 是否初始化了TabFragment
	 */
	private boolean viewInit = false;
	
	@SuppressLint("InflateParams") 
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if(rootView==null){  
			rootView=inflater.inflate(getLayoutId(), null);  
		}  
		ViewGroup parent = (ViewGroup) rootView.getParent();  
		if (parent != null) {  
			parent.removeView(rootView);  
		}   

		return rootView;
	}
	
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if (!viewInit) {
			viewInit = true;
			initTabView();
		}
	}
	
	protected abstract int getLayoutId();
	
	protected abstract int getFragmentId();
	
	protected abstract void initTabView();
	
	public void pushFragment(Fragment fragment, Fragment nextFragment, Bundle bundle, boolean isCanBack, boolean anim){
		FragmentManager fm = getChildFragmentManager();
		FragmentTransaction ft =  fm.beginTransaction();
		if(anim == true){
			ft.setCustomAnimations(
					R.anim.navigation_push_in,
					R.anim.navigation_push_out,
					R.anim.navigation_pop_in,
					R.anim.navigation_pop_out);
		}
		if(fragment != this){
			System.out.println("fragment is not this");
			ft.hide(fragment);
		}
		if(bundle != null){
			nextFragment.setArguments(bundle);
		}
		ft.add(getFragmentId(), nextFragment);
		if(isCanBack == true){
			ft.addToBackStack(null);
		}
		ft.commit();
	}

	public final void pushFragment(Fragment fragment, Fragment nextFragment, Bundle bundle, boolean isCanBack){
		pushFragment(fragment, nextFragment, bundle, isCanBack, true);
	}

	public final void presentFragment(Fragment nextFragment, Bundle bundle, boolean isCanBack, boolean anim){
		FragmentManager fm = getChildFragmentManager();
		FragmentTransaction ft =  fm.beginTransaction();
		if(anim == true){
			ft.setCustomAnimations(
					R.anim.present_show_in,
					R.anim.present_show_out,
					R.anim.present_dismiss_in,
					R.anim.present_dismiss_out);
		}
		if(bundle != null){
			nextFragment.setArguments(bundle);
		}
		ft.add(getFragmentId(), nextFragment);
		if(isCanBack == true){
			ft.addToBackStack(null);
		}
		ft.commit();
	}

	public final void presentFragment(Fragment nextFragment, Bundle bundle, boolean isCanBack){
		presentFragment(nextFragment, bundle, isCanBack, true);
	}

	public final boolean popFragment(){
		boolean isPop = false;
		FragmentManager fm = getChildFragmentManager();
		if (fm.getBackStackEntryCount() > 0) {
			isPop = true;
			fm.popBackStack();
		}
		return isPop;
	}

	public final void popToRootFragment(){
		FragmentManager fm = getChildFragmentManager();
		int count = fm.getBackStackEntryCount();
		while (true) {
			if(count-- == 0){
				break;
			}
			fm.popBackStack();
		}
	}

	public final void popToAtFragment(int index){
		FragmentManager fm = getChildFragmentManager();
		fm.popBackStack();
		int count = fm.getBackStackEntryCount();
		if(index >= 0 && index < count){
			while(true){
				if(count-- == index + 1){
					break;
				}
				fm.popBackStack();
			}
		}
	}
}
