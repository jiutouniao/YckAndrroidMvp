package com.ys.jsst.pmis.commommodule.ui.widget.lazyfragment;

/**
 * Created by xiaobin on 2017/6/12.
 */

import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * PagerAdapter that items added lazily
 * @param <T>
 */
public abstract class LazyPagerAdapter<T> extends PagerAdapter {

    protected SparseArray<T> mLazyItems = new SparseArray<T>();
    private T mCurrentItem;

    /**
     * add lazy item to container
     * @param container {@link LazyViewPager}
     * @param position the position that the item added to
     * @return the item added
     */
    protected abstract T addLazyItem(ViewGroup container, int position);

    /**
     * getYiJing the lazy item
     * @param container {@link LazyViewPager}
     * @param position the position of lazy item
     * @return the lazy item
     */
    protected abstract T getItem(ViewGroup container, int position);

    /**
     * whether the item is lazily or not
     * @param position the position of item
     * @return the item is lazily
     */
    public boolean isLazyItem(int position) {
        return mLazyItems.get(position) != null;
    }

    /**
     * getYiJing the current item
     * @return the current item
     */
    public T getCurrentItem() {
        return mCurrentItem;
    }

    /**
     * call {@link LazyPagerAdapter#addLazyItem(ViewGroup, int)}
     * to prevent {@link LazyViewPager#onPageScrolled(int, float, int)} not working when the offset of {@link LazyViewPager} is too big
     */
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mCurrentItem = addLazyItem(container, position);
    }

}
