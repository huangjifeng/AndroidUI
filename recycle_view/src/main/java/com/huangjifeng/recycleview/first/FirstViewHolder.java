package com.huangjifeng.recycleview.first;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/4/23.
 * RecyclerView通用ViewHolder
 */

public class FirstViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mView;

    public FirstViewHolder(View itemView) {
        super(itemView);
        mView = new SparseArray<View>();
    }

    //通过viewId获取控件
    public <T extends View> T getView(int viewId) {
        View view = mView.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mView.put(viewId, view);
        }
        return (T) view;
    }

    //设置TextView的值
    public FirstViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public FirstViewHolder setImageResource(int viewId, int resId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    public FirstViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public FirstViewHolder setImageURI(int viewId, String uri) {
        ImageView imageView = getView(viewId);
        return this;
    }


}
