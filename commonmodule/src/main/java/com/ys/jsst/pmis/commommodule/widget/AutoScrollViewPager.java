package com.ys.jsst.pmis.commommodule.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.util.LogUtil;

import java.util.ArrayList;


//
public class AutoScrollViewPager extends ViewPager {
	PointF downP = new PointF();
	PointF curP = new PointF();
	public MyPagerAdapter adapter;
	public ArrayList<Integer> images;
	private boolean isTouch = false;
	AutoScrollViewPager viewpager;
	ViewPagerStateView stateChange;

	public AutoScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		images = new ArrayList<Integer>();
		viewpager = this;
		initDataTest();
		adapter = new MyPagerAdapter();
		setAdapter(adapter);


	}


	public void setStateChange(ViewPagerStateView stateChange) {
		this.stateChange = stateChange;
	}



	public void setListinfo(ArrayList arrayList) {
		if (arrayList!=null&&arrayList.size()>0){
			images = arrayList;
		}
		setChangeState();
		adapter.notifyDataSetChanged();
		setCurrentItem(1);
	}

	private void initDataTest() {
		 images= new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			switch (i){
				case 0:
					images.add(R.mipmap.ic_launcher_round);
					break;
				case 1:
					images.add(R.mipmap.ic_launcher_round);
					break;
				case 2:
					images.add(R.mipmap.ic_launcher_round);
					break;
				case 3:
					images.add(R.mipmap.ic_launcher_round);
					break;
				case 4:
					images.add(R.mipmap.ic_launcher_round);
					break;

			}



		}
	}

	private void setChangeState() {
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				//当有手动操作时，remove掉之前auto的runnable。延迟将由手动的这次决定。
				//总之，一个页面selected之后  最多只有一个runnable，要把多的remove掉
				handler.removeCallbacks(runnable);
				if (position != images.size()+1 && position != 0){
					handler.postDelayed(runnable,3000);
				}

				stateChange.setViewNum(images.size(),position-1);

			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int arg2) {
				if (position ==images.size() && positionOffset > 0.99) {
					//在position4左滑且左滑positionOffset百分比接近1时，偷偷替换为position1（原本会滑到position5）
					setCurrentItem(1, false);
					LogUtil.d("wolaile 我来初始化");
				} else if (position == 0 && positionOffset < 0.01) {
					//在position1右滑且右滑百分比接近0时，偷偷替换为position4（原本会滑到position0）
					setCurrentItem(images.size(), false);
					LogUtil.d("wolaile " + images.size());
				}
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		adapter.notifyDataSetChanged();
		viewpager.setCurrentItem(0);
	}


	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			int curindex = (getCurrentItem()+1)%(images.size()+2);
			setCurrentItem(curindex,true);
		}
	};

	Runnable runnable = new Runnable() {
		@Override
		public void run() {

			Message message = new Message();
			handler.sendMessage(message);
		}
	};



	public AutoScrollViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}


	public  class MyPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return images.size() + 2;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//container.removeView((View) object);
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			//这是重点
			int realPosition = (position - 1 + images.size())%images.size();
			ImageView iv = new ImageView(container.getContext());
			/*ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
			layoutParams.width = (int) (ScreenUtils.getScreenWidth()*0.5f);
			iv.setLayoutParams(layoutParams);*/
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setImageResource(images.get(realPosition));
			container.addView(iv,0);
			return iv;
		}
	}

}