package com.ys.jsst.pmis.commommodule.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ys.jsst.pmis.commommodule.R;
/**
 * Created by gengxiecong on 2018/11/26.
 */

public class CommonTitle extends RelativeLayout {
    ImageView ivLeft;
    ImageView ivRight;
    TextView tvLeft;
    TextView tvRight;
    TextView tvTitle;

    private boolean leftTextIsShow;
    private boolean leftPictrueIsShow;
    private String leftText;
    private Drawable leftesPictrueId;
    private String titleText;
    private boolean rightPictrueIsShow;
    private boolean rightTextIsShow;
    private String rightText;
    private Drawable rightResPictrueId;

    public CommonTitle(Context context) {
        this(context,null);
    }
    public CommonTitle(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public CommonTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


       TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.common_title);
        leftPictrueIsShow = array.getBoolean(R.styleable.common_title_leftPictrueIsShow,false);

        leftTextIsShow = array.getBoolean(R.styleable.common_title_leftTextIsShow,false);

        leftText = array.getString(R.styleable.common_title_leftText);

        leftesPictrueId = array.getDrawable(R.styleable.common_title_leftResPictrueId);


        titleText = array.getString(R.styleable.common_title_titleText);


        rightPictrueIsShow = array.getBoolean(R.styleable.common_title_rightPictrueIsShow,false);

        rightTextIsShow = array.getBoolean(R.styleable.common_title_rightTextIsShow,false);

        rightText = array.getString(R.styleable.common_title_rightText);

        rightResPictrueId = array.getDrawable(R.styleable.common_title_rightResPictrueId);
        array.recycle();

        initView(context);
    }

    private void initView(Context context) {
         LayoutInflater.from(context).inflate(R.layout.common_title, this);
        ivLeft = findViewById(R.id.iv_left);
        ivRight =  findViewById(R.id.iv_right);
        tvLeft  = findViewById(R.id.tv_left);
        tvRight  = findViewById(R.id.tv_right);
        tvTitle  = findViewById(R.id.tv_title);


        ivLeft.setVisibility(leftPictrueIsShow?VISIBLE:GONE);
        ivLeft.setImageDrawable(leftesPictrueId);

        tvLeft.setVisibility(leftTextIsShow?VISIBLE:GONE);
        tvLeft.setText(leftText);

        tvTitle.setText(titleText);
        tvTitle.setTextColor(context.getResources().getColor(R.color.color_333333));

        ivRight.setVisibility(rightPictrueIsShow?VISIBLE:GONE);
        ivRight.setImageDrawable(rightResPictrueId);

        tvRight.setVisibility(rightTextIsShow?VISIBLE:GONE);
        tvRight.setText(rightText);

    }




}
