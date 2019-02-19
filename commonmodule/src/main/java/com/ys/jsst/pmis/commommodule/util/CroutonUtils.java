package com.ys.jsst.pmis.commommodule.util;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.ys.jsst.pmis.commommodule.R;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;

/**
 * Crouton显示
 * Created by amos on 2017/10/10.
 */

public class CroutonUtils {


    /**
     * 显示Crouton
     *
     * @param activity 当前activity
     * @param content  要显示的内容
     * @param resId    需要显示在哪个view下
     */
    public static void makeText(Activity activity, String content, int resId) {
        View v = View.inflate(activity, R.layout.common_custom_crouton, null);
        ((TextView) v.findViewById(R.id.tv_content)).setText(content);

        //修改默认弹出时间
        Configuration.Builder cfg = new Configuration.Builder();
        cfg.setDuration(1000);
        Crouton.make(activity, v, resId , cfg.build()).show();
    }

    public static void makeText(Activity activity, String content) {
        View v = View.inflate(activity, R.layout.common_custom_crouton, null);
        ((TextView) v.findViewById(R.id.tv_content)).setText(content);

        Configuration.Builder cfg = new Configuration.Builder();
        cfg.setDuration(1000);
        Crouton.make(activity, v).show();
    }
}
