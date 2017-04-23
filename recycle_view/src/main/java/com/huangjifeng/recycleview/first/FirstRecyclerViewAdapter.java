package com.huangjifeng.recycleview.first;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by Administrator on 2017/4/23.
 */

public abstract class FirstRecyclerViewAdapter extends RecyclerView.Adapter<FirstViewHolder> {

    private final List<DataDTO> mDatas;
    private final int mLayoutId;
    private final LayoutInflater mInflater;
    private onItemClickListener onItemClickListener;

    public interface onItemClickListener {

        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);

    }

    public void setonItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public FirstRecyclerViewAdapter(Context context, List<DataDTO> datas, int layoutId) {
        this.mDatas = datas;
        this.mLayoutId = layoutId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public FirstViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FirstViewHolder firstViewHolder = new FirstViewHolder(mInflater.inflate(mLayoutId, parent, false));
        return firstViewHolder;
    }

    @Override
    public void onBindViewHolder(FirstViewHolder holder, int position) {
        convert(holder, mDatas.get(position));
        setUpItemEvent(holder);
    }

    private void setUpItemEvent(final FirstViewHolder holder) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //这个获取位置的方法，防止添加删除导致位置发生变化
                    int layoutPosition = holder.getAdapterPosition();
                    onItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //这个获取位置的方法，防止添加删除导致位置发生变化
                    int layoutPosition = holder.getAdapterPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, layoutPosition);
                    return false;
                }
            });
        }
    }

    public abstract void convert(FirstViewHolder holder, DataDTO dataDTO);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addData(int pos, DataDTO datas) {
        mDatas.add(pos, datas);
        notifyItemInserted(pos);
    }

    public void deleteData(int pos) {
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }

}
