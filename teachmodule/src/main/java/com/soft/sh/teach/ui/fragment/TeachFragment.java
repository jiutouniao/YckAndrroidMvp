package com.soft.sh.teach.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.View;

import com.soft.sh.teach.R;
import com.soft.sh.teach.adapter.FragmentAdapter;
import com.soft.sh.teach.databinding.FragmentTeachBinding;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import com.ys.jsst.pmis.commommodule.base.BaseFragment;

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

public class TeachFragment extends BaseFragment<FragmentTeachBinding> {

    private List<String> mTitleList;
    private List<Fragment> mFragmentList;
    private FragmentAdapter adapter;

    public static TeachFragment getInstance() {
        TeachFragment bookFrament = new TeachFragment();
        return bookFrament;
    }

    public void initToolBar() {
    }

    @Override
    public void initView(BaseAttribute attribute) {
        attribute.mLayoutId = R.layout.fragment_teach;
    }

    @Override
    public void initData() {
        initToolBar();
        mTitleList = new ArrayList<String>();
        mFragmentList= new ArrayList<Fragment>();
        for (int i = 0; i < 10; i++) {
            mTitleList.add("标题"+i);
            mFragmentList.add(new TypeFragment());
        }
        adapter = new FragmentAdapter(getActivity().getSupportFragmentManager(), mFragmentList, mTitleList);
        mViewBinding.vpPlan.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        initMagicIndicator();
    }

    @Override
    public void initEvent() {
    }
    /**
     * 侧滑菜单指示器初始化
     */
    private void initMagicIndicator() {
        mViewBinding.magicIndicator.setBackgroundColor(Color.TRANSPARENT);
        CommonNavigator commonNa = new CommonNavigator(getActivity());
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
                        mViewBinding.vpPlan.setCurrentItem(i);
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
        mViewBinding.magicIndicator.setNavigator(commonNa);
        ViewPagerHelper.bind(mViewBinding.magicIndicator, mViewBinding.vpPlan);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
