package com.huangjifeng.recycleview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */

public class StaggeredGridRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredGridRecyclerViewAdapter.MyViewHolder> {
    List<String> list;
    List<Integer> heights;

    public StaggeredGridRecyclerViewAdapter(List<String> list) {
        //构造方法传入数据
        this.list = list;
        heights = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            heights.add((int) (150 + Math.random() * 200));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建ViewHolder
        //LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout, null)
        //该方法是渲染一个布局文件，
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_item_layout, null));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //给ViewHolder绑定数据
        holder.textView.setText(list.get(position));
        ViewGroup.LayoutParams layoutParams = holder.textView.getLayoutParams();
        //layoutParams.height = heights.get(position);
        holder.textView.setBackgroundColor(Color.rgb(100, (int) (Math.random() * 255), (int) (Math.random() * 255)));
        //holder.textView.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(int position, String content) {
        list.add(position, content);
        notifyItemInserted(position);
    }

    public void removeItem(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_text);
        }
    }

}
