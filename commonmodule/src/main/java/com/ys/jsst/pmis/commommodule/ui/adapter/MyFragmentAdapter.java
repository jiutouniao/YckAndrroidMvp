package com.ys.jsst.pmis.commommodule.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * description: 没有添加指示器的viewPager 适配器
 * Date: 2016/6/21 11:48
 * User: zhaojiahao
 */
public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;


    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragment) {
        super(fm);
        this.mFragments=fragment;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
