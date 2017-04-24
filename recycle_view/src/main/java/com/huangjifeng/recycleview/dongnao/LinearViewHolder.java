package com.huangjifeng.recycleview.dongnao;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.huangjifeng.recycleview.R;

/**
 * Created by Administrator on 2017/4/24.
 */

public class LinearViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public LinearViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.item_text);
    }
}
