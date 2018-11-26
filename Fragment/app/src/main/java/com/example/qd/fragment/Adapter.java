package com.example.qd.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author: wu
 * date: on 2018/10/31.
 * describe:
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<String> list = new ArrayList<>();
    private HashMap<Integer, RelativeLayout> mapRl = new HashMap<>();//存储背景
    private HashMap<Integer, ImageView> mapIv = new HashMap<>();//存储图标
    private HashMap<Integer, TextView> mapTv = new HashMap<>();//存储标题

    //接口回调
    public interface OnItemClickListener {
        void onItemClick(int position, String type);
    }

    public Adapter.OnItemClickListener mOnItemClickListerer;

    public void setmOnItemClickListerer(Adapter.OnItemClickListener listerer) {
        this.mOnItemClickListerer = listerer;
    }

    public Adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_name.setText(list.get(position));
        mapRl.put(position, holder.rl_all);//储存背景
        mapIv.put(position, holder.iv_icon);//储存图片
        mapTv.put(position, holder.tv_name);//储存名称
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //将所有字体颜色，图片背景，遍历设置颜色
                for (HashMap.Entry<Integer, RelativeLayout> entry : mapRl.entrySet()) {
                    entry.getValue().setBackgroundColor(Color.parseColor("#FFF3F4F6"));
                }
                for (HashMap.Entry<Integer, ImageView> entry : mapIv.entrySet()) {
                    entry.getValue().setVisibility(View.GONE);
                }
                for (HashMap.Entry<Integer, TextView> entry : mapTv.entrySet()) {
                    entry.getValue().setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                    entry.getValue().setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                holder.rl_all.setBackgroundColor(Color.parseColor("#FFFFFFFF"));//设置背景
                holder.iv_icon.setVisibility(View.VISIBLE);
                holder.tv_name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);//设置字体大小
                holder.tv_name.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//设置高亮
                mOnItemClickListerer.onItemClick(position, "");
            }
        });
        //默认选中第一项
        if (position == 0) {
            holder.rl_all.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            holder.iv_icon.setVisibility(View.VISIBLE);
            holder.tv_name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            holder.tv_name.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        } else {
            holder.rl_all.setBackgroundColor(Color.parseColor("#FFF3F4F6"));
            holder.iv_icon.setVisibility(View.GONE);
            holder.tv_name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            holder.tv_name.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_icon;
        TextView tv_name;
        RelativeLayout rl_all;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_name = itemView.findViewById(R.id.tv_name);
            rl_all = itemView.findViewById(R.id.rl_all);
        }
    }
}
