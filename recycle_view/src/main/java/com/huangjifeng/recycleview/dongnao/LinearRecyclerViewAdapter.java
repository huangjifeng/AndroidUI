package com.huangjifeng.recycleview.dongnao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huangjifeng.recycleview.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */

public class LinearRecyclerViewAdapter extends RecyclerView.Adapter<LinearViewHolder> {

    private final Context context;
    private final List<String> list;
    private final LayoutInflater inflater;

    public LinearRecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearViewHolder linearViewHolder = new LinearViewHolder(inflater.inflate(R.layout.recycler_item_layout, null));
        return linearViewHolder;
    }

    @Override
    public void onBindViewHolder(LinearViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
