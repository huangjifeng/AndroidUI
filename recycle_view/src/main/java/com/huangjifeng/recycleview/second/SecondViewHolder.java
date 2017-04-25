package com.huangjifeng.recycleview.second;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.huangjifeng.recycleview.R;

/**
 * Created by Administrator on 2017/4/25.
 */

public class SecondViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public SecondViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.second_item_01);
    }
}
