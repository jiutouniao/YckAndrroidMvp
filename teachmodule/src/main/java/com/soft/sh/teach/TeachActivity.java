package com.soft.sh.teach;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.soft.sh.teach.adapter.FragmentAdapter;
import com.soft.sh.teach.ui.fragment.TeachFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

public class TeachActivity extends AppCompatActivity {

    MagicIndicator mIndicator;
    ViewPager mViewPager;
    private List<String> mTitleList = new ArrayList<String>();
    private FragmentAdapter adapter;
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach);
        mIndicator = findViewById(R.id.magic_indicator);
        mViewPager = findViewById(R.id.vp_plan);
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mTitleList.add("标题"+i);
        }

        initData();

        initMagicIndicator();
    }

    private void initData() {
        for (int i = 0; i < mTitleList.size(); i++) {
            TeachFragment informationDisclosureFragment = new TeachFragment();

            Bundle bundle = new Bundle();
            bundle.putString("dicKey", mTitleList.get(i));
            informationDisclosureFragment.setArguments(bundle);
            //            informationDisclosureFragment.(mData.get(i).getDicKey());
            mFragmentList.add(informationDisclosureFragment);
        }
        adapter = new FragmentAdapter(TeachActivity.this.getSupportFragmentManager(), mFragmentList, mTitleList);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(20);
        //mViewBinding.vpPlan.setCurrentItem(0);
        adapter.notifyDataSetChanged();
    }


    /**
     * 侧滑菜单指示器初始化
     */
    private void initMagicIndicator() {
        mIndicator.setBackgroundColor(Color.TRANSPARENT);
        CommonNavigator commonNa = new CommonNavigator(TeachActivity.this);
        commonNa.setAdjustMode(false);
        commonNa.setScrollPivotX(0.25f);
        commonNa.setRightPadding(10);
        commonNa.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleList == null ? 0 : mTitleList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(mTitleList.get(i));
                simplePagerTitleView.setNormalColor(getResources().getColor(R.color.text_color_2a));
                simplePagerTitleView.setSelectedColor(getResources().getColor(R.color.text_color_06));
                simplePagerTitleView.setTextSize(16);

                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(i);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setYOffset(UIUtil.dip2px(context, 0));
                indicator.setColors(getResources().getColor(R.color.text_color_06));
                return indicator;
            }
        });
        mIndicator.setNavigator(commonNa);
        ViewPagerHelper.bind(mIndicator, mViewPager);
    }
}
