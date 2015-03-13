package com.example.myfragment;

import com.example.myfragment.allaccout.AllAccoutContainer;
import com.example.myfragment.allexams.AllExamsContainer;
import com.example.myfragment.allshare.AllShareContainer;
import com.example.myfragment.allupload.AllUploadContainer;
import com.example.myfragment.ui.TabBasicFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;


public class MainActivity extends BasicActivity implements OnTabChangeListener{
	private FragmentTabHost mTabHost = null;;
	private View indicator = null;
	private String Tab_AllExams = "AllExams";
	private String Tab_AllUpload = "AllUpload";
	private String Tab_AllShare = "AllShare";
	private String Tab_AllAccout = "AllAccout";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setOnTabChangedListener(this);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.frameLayout);
		//TabHost
		// 添加tab名称和图标
		indicator = getIndicatorView("试卷", R.layout.tab_item_all_exams);
		mTabHost.addTab(
				mTabHost.newTabSpec(Tab_AllExams).setIndicator(indicator),
				AllExamsContainer.class, null);

		indicator = getIndicatorView("全部上传", R.layout.tab_item_all_upload);
		mTabHost.addTab(
				mTabHost.newTabSpec(Tab_AllUpload).setIndicator(indicator),
				AllUploadContainer.class, null);

		indicator = getIndicatorView("全部分享", R.layout.tab_item_all_share);
		mTabHost.addTab(
				mTabHost.newTabSpec(Tab_AllShare).setIndicator(indicator),
				AllShareContainer.class, null);
		indicator = getIndicatorView("账户", R.layout.tab_item_all_account);
		mTabHost.addTab(
				mTabHost.newTabSpec(Tab_AllAccout).setIndicator(indicator),
				AllAccoutContainer.class, null);
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
	}

	@Override
	public void onBackPressed() {
		boolean isPopFragment = false;
		String currentTabTag = mTabHost.getCurrentTabTag();
		if (currentTabTag.equals(Tab_AllExams) ||
				currentTabTag.equals(Tab_AllUpload) ||
				currentTabTag.equals(Tab_AllShare) ||
				currentTabTag.equals(Tab_AllAccout) ) {
			isPopFragment = ((TabBasicFragment)getSupportFragmentManager().findFragmentByTag(currentTabTag)).popFragment();
		}

		if (!isPopFragment) {
			finish();
		}
	}
}
