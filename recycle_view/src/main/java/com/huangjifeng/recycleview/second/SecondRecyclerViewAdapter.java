package com.huangjifeng.recycleview.second;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huangjifeng.recycleview.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/25.
 */

public class SecondRecyclerViewAdapter extends RecyclerView.Adapter<SecondViewHolder> {

    private final Context mContext;
    private final ArrayList<String> mList;
    private final LayoutInflater mInflater;

    public SecondRecyclerViewAdapter(Context context, ArrayList<String> list) {
        this.mContext = context;
        this.mList = list;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public SecondViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SecondViewHolder secondViewHolder = new SecondViewHolder(mInflater
                .inflate(R.layout.second_item_01, parent, false));
        return secondViewHolder;
    }

    @Override
    public void onBindViewHolder(SecondViewHolder holder, int position) {
        holder.textView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
