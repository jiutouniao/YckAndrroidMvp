package com.ys.jsst.pmis.commommodule.ui.widget;

import android.text.InputFilter;
import android.text.Spanned;

import com.ys.jsst.pmis.commommodule.util.EmojiFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  项目描述:
 *  作者: shenrunzhou 
 *  创建时间  :2018-08-20  15:03
 */

public class EmojiFilter2
        implements InputFilter {


    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                               int dstart, int dend) {

        String emoji1 = EmojiFilter.filterEmoji(source.toString());
        if (emoji1==null||emoji1.length()==0){
            return "";
        }


        Pattern emoji = Pattern.compile(

                "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher emojiMatcher = emoji.matcher(source);
        if (emojiMatcher.find()) {
            return "";
        }
        return null;
    }
}
