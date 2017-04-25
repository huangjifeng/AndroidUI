package com.huangjifeng.recycleview.first;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.huangjifeng.recycleview.R;

/**
 * Created by Administrator on 2017/4/25.
 */

public class FirstThemeViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public FirstThemeViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.first_item_01_textview);
    }
}
