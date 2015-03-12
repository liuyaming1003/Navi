package com.example.myfragment.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

public class BasicFragment extends Fragment {
	protected onSwitchFragmentListener switchFragmentListener = null;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		System.out.println("********** "+ this + "onCreateView" + " **********");

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub

		try{
			switchFragmentListener = (onSwitchFragmentListener) activity;
		}catch(ClassCastException e){
			throw new ClassCastException(activity.toString() + "must implement onSwitchFragmentListener");
		}



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

	public interface onSwitchFragmentListener{
		public void push(Fragment fragment, Fragment nextFragment, Bundle bundle, boolean isCanBack);
		public void present(Fragment fragment, Fragment nextFragment, Bundle bundle, boolean isCanBack);
		public void pop();
		public void popToRoot();
		public void popToFragment(int atIndex);
	}
}
