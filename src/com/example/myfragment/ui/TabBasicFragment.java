package com.example.myfragment.ui;

import com.example.myfragment.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.animation.Animation;

public class TabBasicFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		System.out.println("********** "+ this + "onCreateView" + " **********");

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {

		System.out.println("********** "+ this + "onAttach" + " **********");

		super.onAttach(activity);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onActivityCreated" + " **********");

		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		System.out.println("********** "+ this + "onActivityResult" + " **********");

		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onConfigurationChanged" + " **********");

		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onContextItemSelected" + " **********");

		return super.onContextItemSelected(item);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onCreate" + " **********");

		super.onCreate(savedInstanceState);
	}

	@Override
	public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onCreateAnimation" + " **********");

		return super.onCreateAnimation(transit, enter, nextAnim);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onCreateContextMenu" + " **********");

		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onCreateOptionsMenu" + " **********");

		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onDestroy" + " **********");

		super.onDestroy();
	}

	@Override
	public void onDestroyOptionsMenu() {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onDestroyOptionsMenu" + " **********");

		super.onDestroyOptionsMenu();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onDestroyView" + " **********");

		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onDetach" + " **********");
		
		super.onDetach();
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onHiddenChanged" + " **********");

		super.onHiddenChanged(hidden);
	}

	@Override
	public void onInflate(Activity activity, AttributeSet attrs,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onInflate" + " **********");

		super.onInflate(activity, attrs, savedInstanceState);
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onLowMemory" + " **********");

		super.onLowMemory();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onOptionsItemSelected" + " **********");

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onOptionsMenuClosed" + " **********");

		super.onOptionsMenuClosed(menu);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onPause" + " **********");

		super.onPause();
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onPrepareOptionsMenu" + " **********");

		super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onResume" + " **********");

		super.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onSaveInstanceState" + " **********");

		super.onSaveInstanceState(outState);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onStart" + " **********");

		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onStop" + " **********");

		super.onStop();
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onViewCreated" + " **********");

		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onViewStateRestored" + " **********");

		super.onViewStateRestored(savedInstanceState);
	}

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
		ft.add(R.id.tab_fragment, nextFragment);
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
