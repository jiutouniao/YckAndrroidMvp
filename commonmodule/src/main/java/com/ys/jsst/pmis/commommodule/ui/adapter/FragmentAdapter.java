package com.ys.jsst.pmis.commommodule.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * description: 添加指示器的viewpager 指示器
 * Date: 2016/6/21 11:48
 * User: zhaojiahao
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTitles;


    public FragmentAdapter(FragmentManager fm, List<Fragment> fragment , List<String> titles) {
        super(fm);
        this.mFragments=fragment;
        this.mTitles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
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