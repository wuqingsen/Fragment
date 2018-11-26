package com.example.qd.fragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainFragmentActivity extends Activity implements View.OnClickListener {

    //ll_1,ll_2,ll_3,ll_4分别是首页，发现，消息，我的
    private LinearLayout ll_1, ll_2, ll_3, ll_4;
    private TextView tv_1, tv_2, tv_3, tv_4;
    private MainFragment fg1;
    private MainFragment fg2;
    private MainFragment fg3;
    private MainFragment fg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //查找控件模拟第一次点击等操作
        setView();
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fTransaction = getFragmentManager().beginTransaction();
        hideAllFragment(fTransaction);
        switch (view.getId()) {
            //首页
            case R.id.ll_1:
                if (fg1 == null) {
                    fg1 = new MainFragment("首页");
                    fTransaction.add(R.id.fl_context, fg1);
                } else {
                    fTransaction.show(fg1);
                }
                //设置选中的点击效果,1为首页
                setClick("1");
                break;
            //发现
            case R.id.ll_2:
                if (fg2 == null) {
                    fg2 = new MainFragment("发现");
                    fTransaction.add(R.id.fl_context, fg2);
                } else {
                    fTransaction.show(fg2);
                }
                //设置选中的点击效果,2为发现
                setClick("2");
                break;
            //消息
            case R.id.ll_3:
                if (fg3 == null) {
                    fg3 = new MainFragment("消息");
                    fTransaction.add(R.id.fl_context, fg3);
                } else {
                    fTransaction.show(fg3);
                }
                //设置选中的点击效果,3为消息
                setClick("3");
                break;
            //我的
            case R.id.ll_4:
                if (fg4 == null) {
                    fg4 = new MainFragment("我的");
                    fTransaction.add(R.id.fl_context, fg4);
                } else {
                    fTransaction.show(fg4);
                }
                //设置选中的点击效果,4为我的
                setClick("4");
                break;
        }
        //提交事务
        fTransaction.commitAllowingStateLoss();
    }

    //设置选中的点击效果
    private void setClick(String type) {
        tv_1.setTextColor(Color.parseColor("#FF999999"));
        tv_2.setTextColor(Color.parseColor("#FF999999"));
        tv_3.setTextColor(Color.parseColor("#FF999999"));
        tv_4.setTextColor(Color.parseColor("#FF999999"));
        tv_1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        tv_1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tv_2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        tv_2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tv_3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        tv_3.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tv_4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        tv_4.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        if (type.equals("1")){
            //选中首页，设置字体颜色、大小、加粗；
            tv_1.setTextColor(Color.parseColor("#FF333333"));
            tv_1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            tv_1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }else if (type.equals("2")){
            //选中发现，设置字体颜色、大小、加粗；
            tv_2.setTextColor(Color.parseColor("#FF333333"));
            tv_2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            tv_2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }else if (type.equals("3")){
            //选中消息，设置字体颜色、大小、加粗；
            tv_3.setTextColor(Color.parseColor("#FF333333"));
            tv_3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            tv_3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }else {
            //选中我的，设置字体颜色、大小、加粗；
            tv_4.setTextColor(Color.parseColor("#FF333333"));
            tv_4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            tv_4.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
    }

    //查找控件模拟第一次点击等操作
    private void setView() {
        ll_1 = findViewById(R.id.ll_1);
        ll_2 = findViewById(R.id.ll_2);
        ll_3 = findViewById(R.id.ll_3);
        ll_4 = findViewById(R.id.ll_4);
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);
        tv_4 = findViewById(R.id.tv_4);
        ll_1.setOnClickListener(this);
        ll_2.setOnClickListener(this);
        ll_3.setOnClickListener(this);
        ll_4.setOnClickListener(this);
        //模拟一次点击，既进去后选择第一项
        ll_1.performClick();
    }
}
