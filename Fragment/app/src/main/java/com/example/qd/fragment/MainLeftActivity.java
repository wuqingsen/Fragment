package com.example.qd.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainLeftActivity extends Activity {
    private RecyclerView recyclerView;
    private List<String> titleList;//标题列表
    private List<Fragment> fragmentList;//fragment列表
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_left);

        recyclerView = findViewById(R.id.recyclerView);

        //设置侧面标题以及适配器
        setTitleList();
        //添加fragment并设置显示位置为第一个
        setFragment();
    }

    //设置侧面标题以及适配器
    private void setTitleList() {
        //模拟，为标题添加数据
        titleList = new ArrayList<>();
        titleList.add("男装");
        titleList.add("女装");
        titleList.add("童装");
        titleList.add("男鞋");
        titleList.add("女鞋");
        //设置侧面标题适配器
        adapter = new Adapter(this, titleList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setmOnItemClickListerer(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String type) {
                setFragmentSite(position);
            }
        });
    }

    //添加fragment并设置显示位置为第一个
    private void setFragment() {
        fragmentList = new ArrayList<>();
        android.app.FragmentTransaction fTransaction = getFragmentManager().beginTransaction();
        //将 MainFragment 添加到列表中，以供显示
        for (int i = 0; i < titleList.size(); i++) {
            fragmentList.add(new MainFragment(titleList.get(i)));
            fTransaction.add(R.id.fl_content, fragmentList.get(i));
        }
        fTransaction.commitAllowingStateLoss();
        //设置fragment位置；默认第一个，即传0；
        setFragmentSite(0);
    }

    //设置fragment位置
    private void setFragmentSite(int position) {
        android.app.FragmentTransaction fTransaction = getFragmentManager().beginTransaction();
        //隐藏所有的Fragment
        for (int i = 0; i < fragmentList.size(); i++) {
            fTransaction.hide(fragmentList.get(i));
        }
        //显示特定的Fragment
        fTransaction.show(fragmentList.get(position)).commitAllowingStateLoss();
    }
}
