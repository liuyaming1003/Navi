package com.example.myfragment.allexams;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.myfragment.CustomButton;
import com.example.myfragment.MainActivity;
import com.example.myfragment.NavigationBarItem;
import com.example.myfragment.PopupWindowView;
import com.example.myfragment.R;
import com.example.myfragment.fragment.NavigationController;

public class AllExamsVC extends NavigationController {
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if(savedInstanceState == null){
			setTitle("全部");
			NavigationBarItem item = new NavigationBarItem(getActivity());
			item.setBtnImgText(R.drawable.icn_nav_import, R.drawable.icn_nav_import, "", Gravity.LEFT);
			item.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					View showView = getActivity().getLayoutInflater().inflate(R.layout.test_popupwindow, null);
					new PopupWindowView().show(v, showView, 400, 400, Gravity.LEFT | Gravity.TOP, Gravity.BOTTOM, 10).setOnDismissListener(new PopupWindow.OnDismissListener() {

						@Override
						public void onDismiss() {

						}
					});
				}
			});
			setLeftBarItem(item);

			NavigationBarItem ritemSearch = new NavigationBarItem(getActivity());
			ritemSearch.setBtnImgText(R.drawable.icn_nav_search, "", Gravity.RIGHT);
			ritemSearch.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					View showView = getActivity().getLayoutInflater().inflate(R.layout.vc_search, null);
					new PopupWindowView().showFill(getActivity(), v, showView).setOnDismissListener(new PopupWindow.OnDismissListener() {

						@Override
						public void onDismiss() {

						}
					});
				}
			});

			NavigationBarItem ritemMore = new NavigationBarItem(getActivity());
			ritemMore.setBtnImgText(R.drawable.icn_nav_more, "", Gravity.RIGHT);
			ritemMore.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					View showView = getActivity().getLayoutInflater().inflate(R.layout.test_popupwindow, null);
					new PopupWindowView().show(v, showView, 400, 400, Gravity.RIGHT | Gravity.TOP, Gravity.BOTTOM, 10).setOnDismissListener(new PopupWindow.OnDismissListener() {

						@Override
						public void onDismiss() {

						}
					});
				}
			});
			setRightBarItem(ritemSearch, ritemMore);

			NavigationBarItem midItem = new NavigationBarItem(getActivity());
			midItem.setSwitchImgText(R.drawable.icn_nav_filter_expand, R.drawable.icn_nav_filter_collapse, "全部", Gravity.RIGHT);
			midItem.setOnSwitchListener(new CustomButton.OnSwitchListener() {
				@Override
				public void switchBtn(final CustomButton button, boolean isSwitch) {
					if(isSwitch == true){
						View showView = getActivity().getLayoutInflater().inflate(R.layout.test_popupwindow, null);
						new PopupWindowView().show(button, showView, LayoutParams.MATCH_PARENT, 400, Gravity.FILL_HORIZONTAL|Gravity.TOP, Gravity.BOTTOM).setOnDismissListener(new PopupWindow.OnDismissListener() {

							@Override
							public void onDismiss() {
								button.setOnSwitchNormal();
							}
						});
						System.out.println("Switch 切换了状态");
					}else{
						System.out.println("Switch 一般状态");
					}
				}
			});
			setTitleView(midItem);
		}
	}

	@Override
	public void onHiddenChanged(boolean hidden) {

		System.out.println("hidden = " + hidden);
		((MainActivity) getActivity()).hiddenTabHost(hidden);
		super.onHiddenChanged(hidden);
	}

	@SuppressLint("InflateParams") @Override
	public View getRootView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.vc_all_exams, null);
		view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				push(AllExamsVC.this, new ExamsDetail(), null, true);
			}
		});
		return view;
	}
}
