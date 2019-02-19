package com.ys.jsst.pmis.commommodule.util;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;

import com.ys.jsst.pmis.commommodule.R;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-8-18 11:54
 */
public class LengthFilter implements InputFilter {

    private  Context mContext;
    private int mMax;

    public LengthFilter(Context context, int max) {
        mMax = max;
        mContext =context;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        int keep = mMax - (dest.length() - (dend - dstart));
        if (keep <= 0) {
            ToastUtil.showLongCenterToast(mContext,String.format(UIutil.getString(R.string.group_name_max_wenzi),mMax));
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
