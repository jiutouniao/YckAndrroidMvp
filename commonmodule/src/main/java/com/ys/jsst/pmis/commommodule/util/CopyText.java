package com.ys.jsst.pmis.commommodule.util;

import android.content.ClipboardManager;
import android.content.Context;

/**
 * 描述：复制文本到剪切板
 * 作者：yuyanjun
 * 时间： 2017-7-18 14:31
 */
public class CopyText {

    public static void CopyToClipboard(Context context, String text) {
        ClipboardManager clip = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        //clip.getText(); // 粘贴
        clip.setText(text); // 复制
    }
}
