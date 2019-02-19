package com.ys.jsst.pmis.commommodule.ui.adapter;
/**-------------------------------------------------------------------------------------------------
viewpager中彻底性动态添加、删除Fragment
 1.将FragmentPagerAdapter 替换成FragmentStatePagerAdapter，因为前者只要加载过，fragment中的视图就一直在内存中，在这个过程中无论你怎么刷新，清除都是无用的，直至程序退出； 后者 可以满足我们的需求。
 2.我们可以重写Adapter的方法--getItemPosition()，让其返回PagerAdapter.POSITION_NONE即可；
 　　　　 @Override
    public int getItemPosition(Object object) {
    return PagerAdapter.POSITION_NONE;
    }

到这一步我们就可以真正的实现随意、彻底删除viewpager中的fragment；[随意添加完全OK]
 ----------------------------------------------------------------------------------------------------*/
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;
import java.util.List;

/**
 * author :shao bing
 * description: ViewPager 适配器 ，适合大量的界面
 * time :2016/12/21 9:22
 */
public class StatePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;

    public void setList(List<Fragment> fragments){
        this.fragments =fragments;
    }


    public StatePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }
    @Override
    public int getCount() {
        return this.fragments.size();
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment=null;
        try {
            fragment=(Fragment)super.instantiateItem(container,position);
        }catch (Exception e){

        }
        return fragment;
    }

    /**
     * 清除旧的fragment
     * @param container
     * @param position
     * @param object
     */
    public void destroyItem(ViewGroup container, int position, Object object) {
        FragmentManager manager = ((Fragment) object).getFragmentManager();
        if(manager==null){
            return;
        }
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) object);
        trans.commit();
        super.destroyItem(container, position, object);
    }


//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
//    }


}
