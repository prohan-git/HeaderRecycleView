package com.example.kjpro.headerrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/****
 *  Project_Name:    HeaderRecycleView
 *  Copyright:       Copyright  2012-2017 G-emall Technology Co.,Ltd
 *  Version:         1.0.0.1
 *  Created:         Tijun.han on 2017/7/17 0017 17:50.
 *  E-mail:          tijun.han@g-emall.com
 *  Desc:            
 ****/
public class MyRecycleTypeAdapter extends RecyclerView.Adapter<MyRecycleTypeAdapter.ViewHolder> {
    public String[] datas = null;

    public MyRecycleTypeAdapter(String[] datas) {
        this.datas = datas;
    }


    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(datas[position]);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.length;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text);
        }
    }
}
