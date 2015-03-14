package com.example.myfragment;

import com.example.myfragment.allaccout.AllAccoutContainer;
import com.example.myfragment.allexams.AllExamsContainer;
import com.example.myfragment.allshare.AllShareContainer;
import com.example.myfragment.allupload.AllUploadContainer;
import com.example.myfragment.fragment.TabBasicFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;


public class MainActivity extends BasicActivity implements OnTabChangeListener{
	private long mExitTime;

	private FragmentTabHost mTabHost = null;;
	private View indicator = null;
	private String Tab_AllExams = "AllExams";
	private String Tab_AllUpload = "AllUpload";
	private String Tab_AllShare = "AllShare";
	private String Tab_AllAccout = "AllAccout";
	private AllExamsContainer examsContainer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setOnTabChangedListener(this);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.frameLayout);
		//TabHost
		// 添加tab名称和图标
		examsContainer = new AllExamsContainer();
		indicator = getIndicatorView("试卷", R.layout.tab_item_all_exams);
		mTabHost.addTab(
				mTabHost.newTabSpec(Tab_AllExams).setIndicator(indicator),
				examsContainer.getClass(), null);

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
		System.out.println("Tag = " + currentTabTag);
		if (currentTabTag.equals(Tab_AllExams) ||
				currentTabTag.equals(Tab_AllUpload) ||
				currentTabTag.equals(Tab_AllShare) ||
				currentTabTag.equals(Tab_AllAccout) ) {
			isPopFragment = ((TabBasicFragment)getSupportFragmentManager().findFragmentByTag(currentTabTag)).popFragment();
		}

		if (!isPopFragment) {
			if ((System.currentTimeMillis() - mExitTime) > 2000) {// 如果两次按键时间间隔大于2000毫秒，则不退出
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
				mExitTime = System.currentTimeMillis();// 更新mExitTime
			} else {
				System.exit(0);// 否则退出程序
			}
		}
	}
	
	public void hiddenTabHost(boolean hidden){
		TabWidget tabs = (TabWidget) findViewById(android.R.id.tabs);
		if(hidden == true){
			Animation animation = AnimationUtils.loadAnimation(  
	                this, R.anim.tabbar_dismiss);
			tabs.setAnimation(animation);
			tabs.setVisibility(View.GONE);
		}else{
			Animation animation = AnimationUtils.loadAnimation(  
	                this, R.anim.tabbar_show);
			tabs.setAnimation(animation);
			tabs.setVisibility(View.VISIBLE);
		}
	}
}
