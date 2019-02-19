package com.ys.jsst.pmis.commommodule.ui.widget;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;

import com.ys.jsst.pmis.commommodule.util.ToastUtil;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-8-18 11:54
 */
public class StrongLengthFilter
        implements InputFilter {

    private  Context mContext;
    private int mMax;
    private String mToast;

    public StrongLengthFilter(Context context, int max, String toast) {
        mMax = max;
        mContext =context;
        this.mToast = toast;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        int keep = mMax - (dest.length() - (dend - dstart));
        if (keep <= 0) {
            ToastUtil.showLongCenterToast(mContext, mToast);
            return "";
        } else if (keep >= end - start) {
            return null;
        } else {
            keep += start;
            if (Character.isHighSurrogate(source.charAt(keep - 1))) {
                --keep;
                if (keep == start) {
                    return "";
                }
            }
            return source.subSequence(start, keep);
        }
    }

}
