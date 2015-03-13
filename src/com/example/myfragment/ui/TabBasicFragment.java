package com.example.myfragment.ui;

import com.example.myfragment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class TabBasicFragment extends Fragment {
	public void pushFragment(Fragment nextFragment, Bundle bundle, boolean isCanBack, boolean anim){
		FragmentManager fm = getChildFragmentManager();
		FragmentTransaction ft =  fm.beginTransaction();
		if(anim == true){
			ft.setCustomAnimations(
					R.anim.navigation_push_in,
					R.anim.navigation_push_out,
					R.anim.navigation_pop_in,
					R.anim.navigation_pop_out);
		}
		if(bundle != null){
			nextFragment.setArguments(bundle);
		}
		ft.add(R.id.tab_fragment, nextFragment);
		if(isCanBack == true){
			ft.addToBackStack(null);
		}
		ft.commit();
	}

	public final void pushFragment(Fragment nextFragment, Bundle bundle, boolean isCanBack){
		pushFragment(nextFragment, bundle, isCanBack, true);
	}

	public final void presentFragment(Fragment nextFragment, Bundle bundle, boolean isCanBack){
		FragmentManager fm = getChildFragmentManager();
		FragmentTransaction ft =  fm.beginTransaction();
		ft.setCustomAnimations(
				R.anim.present_show_in,
				R.anim.present_show_out,
				R.anim.present_dismiss_in,
				R.anim.present_dismiss_out);
		if(bundle != null){
			nextFragment.setArguments(bundle);
		}
		ft.add(R.id.tab_fragment, nextFragment);
		if(isCanBack == true){
			ft.addToBackStack(null);
		}
		ft.commit();
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
