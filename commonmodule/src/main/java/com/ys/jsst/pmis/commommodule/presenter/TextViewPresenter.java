package com.ys.jsst.pmis.commommodule.presenter;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ys.jsst.pmis.commommodule.util.StringUtils;

/**
 * 描述：处理文字显示类
 * 作者：shaobing
 * 时间： 2017/2/15 13:48
 */
public class TextViewPresenter {

    /**
     * 给TextView 添加文字
     * @param textView 对应的文字控件
     * @param text     相关信息
     */
    public static void setText(TextView textView,String text){
        if(textView==null){
            return;
        }
        if(StringUtils.isNotEmpty(text)){
            textView.setVisibility(View.VISIBLE);
            textView.setText(text);
        }else{
            textView.setText("");
        }
    }
    /**
     * EditText 添加文字
     * @param editText 对应的文字控件
     * @param text     相关信息
     */
    public static void setText(EditText editText, String text){
        if(editText==null){
            return;
        }
        if(StringUtils.isNotEmpty(text)){
            editText.setVisibility(View.VISIBLE);
            editText.setText(text);
        }else{
            editText.setText("");
        }
    }



    /**
     * 给TextView 添加信息
     * @param textView
     * @param text
     * @param isGone
     */
    public static void setText(TextView textView,String text,boolean isGone){
        if(textView==null){
            return;
        }
        if(StringUtils.isNotEmpty(text)){
            textView.setVisibility(View.VISIBLE);
            textView.setText(text);
        }else{
            if(isGone){
                textView.setVisibility(View.GONE);
            }else{
                textView.setText("");
            }
        }
    }



}
