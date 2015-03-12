package com.example.myfragment;

import com.example.myfragment.login.LoginFragment;
import com.example.myfragment.login.SettingFragment;
import com.example.myfragment.ui.AllExamsVC;
import com.example.myfragment.ui.BasicFragment.onSwitchFragmentListener;
import com.example.myfragment.ui.MainFragment;
import com.example.myfragment.ui.NextFragment;
import com.example.myfragment.ui.NavigationFragment.OnNavigationFragmentListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;


public class MainActivity extends BasicActivity implements OnTabChangeListener,OnNavigationFragmentListener, onSwitchFragmentListener{
	private FragmentTabHost mTabHost = null;;
	private View indicator = null;
	private int fragmentLayout = 0;
	/**
	 * @param fragmentLayout the fragmentLayout to set
	 */
	public void setFragmentLayout(int fragmentLayout) {
		this.fragmentLayout = fragmentLayout;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setOnTabChangedListener(this);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.frameLayout);
//TabHost
		// 添加tab名称和图标
		indicator = getIndicatorView("All Exams", R.layout.tab_item_all_exams);
		mTabHost.addTab(
				mTabHost.newTabSpec("All Exams").setIndicator(indicator),
				AllExamsVC.class, null);

		indicator = getIndicatorView("全部上传", R.layout.tab_item_all_upload);
		mTabHost.addTab(
				mTabHost.newTabSpec("All Upload").setIndicator(indicator),
				MainFragment.class, null);
		
		indicator = getIndicatorView("Share", R.layout.tab_item_all_share);
		mTabHost.addTab(
				mTabHost.newTabSpec("All Share").setIndicator(indicator),
				MainFragment.class, null);
		indicator = getIndicatorView("账户", R.layout.tab_item_all_account);
		mTabHost.addTab(
				mTabHost.newTabSpec("All Item").setIndicator(indicator),
				MainFragment.class, null);
	}
	
	private View getIndicatorView(String name, int layoutId) {
		View v = getLayoutInflater().inflate(layoutId, null);
		TextView tv = (TextView) v.findViewById(R.id.tabText);
		tv.setText(name);
		return v;
	}

	@Override
	public void onTabChanged(String tabId) {
		System.out.println("String " + tabId);
		
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentByTag(tabId);
		if(fragment instanceof AllExamsVC){
			
		}
	}

	@Override
	public void leftBar(View view, Fragment fragment) {
		System.out.println("LeftBar");
		if(fragment instanceof AllExamsVC){
			pushFragment(fragmentLayout, fragment, new SettingFragment(), null, true);
		}else{
			pop();
		}
	}


	@Override
	public void rightBar(View view, Fragment fragment) {
		System.out.println("RightBar");
		if(fragment instanceof MainFragment){
			presentFragment(fragmentLayout, fragment, new LoginFragment(), null, true);
		}else{
			popToRoot();
		}
	}


	@Override
	public void push(Fragment fragment, Fragment nextFragment, Bundle bundle,
			boolean isCanBack) {
		pushFragment(fragmentLayout, fragment, nextFragment, bundle, isCanBack);
	}


	@Override
	public void present(Fragment fragment, Fragment nextFragment,
			Bundle bundle, boolean isCanBack) {
		presentFragment(fragmentLayout, fragment, nextFragment, bundle, isCanBack);
	}


	@Override
	public void pop() {
		NextFragment.index--;
		popFragment();
	}


	@Override
	public void popToRoot() {
		popToRootFragment();
	}


	@Override
	public void popToFragment(int atIndex) {
		popToAtFragment(atIndex);
	}
}
