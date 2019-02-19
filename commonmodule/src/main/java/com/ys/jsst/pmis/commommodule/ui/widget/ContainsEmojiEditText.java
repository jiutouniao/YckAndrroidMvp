package com.ys.jsst.pmis.commommodule.ui.widget;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;

/**
 * Created by chenxiaowei on 2018/9/6.
 */

public class ContainsEmojiEditText extends android.support.v7.widget.AppCompatEditText {

    public ContainsEmojiEditText(Context context) {
        super(context);
        initEditText();
    }

    public ContainsEmojiEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEditText();
    }

    public ContainsEmojiEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEditText();

    }

    // 初始化edittext 控件
    private void initEditText() {
        setFilters(new InputFilter[]{new EmojiFilter2()});
    }


}