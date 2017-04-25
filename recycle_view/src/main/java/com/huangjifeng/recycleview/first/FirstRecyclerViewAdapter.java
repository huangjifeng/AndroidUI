package com.huangjifeng.recycleview.first;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangjifeng.recycleview.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/25.
 */

public class FirstRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private final ArrayList<String> mList;
    private final LayoutInflater mInflater;

    //通过枚举来记录有多少种item布局
    public static enum ITEM_TYPE {
        ITEM_TYPE_THEME,
        ITEM_TYPE_VIDEO
    }

    public FirstRecyclerViewAdapter(Context context, ArrayList<String> list) {
        this.mContext = context;
        this.mList = list;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_THEME.ordinal()) {
            View view = mInflater.inflate(R.layout.first_item_01, parent, false);
            return new FirstThemeViewHolder(view);
        } else if (viewType == ITEM_TYPE.ITEM_TYPE_VIDEO.ordinal()) {
            View view = mInflater.inflate(R.layout.first_item_02, parent, false);
            return new FirstVideoViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FirstThemeViewHolder) {
            FirstThemeViewHolder firstThemeViewHolder = (FirstThemeViewHolder) holder;
            firstThemeViewHolder.textView.setText("这是头标签");
        } else if (holder instanceof FirstVideoViewHolder) {
            FirstVideoViewHolder firstVideoViewHolder = (FirstVideoViewHolder) holder;
            firstVideoViewHolder.textView.setText(mList.get(position - 1));
            firstVideoViewHolder.imageView.setImageResource(R.drawable.ding_not_clicked);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 10 == 0) {
            return ITEM_TYPE.ITEM_TYPE_THEME.ordinal();
        } else {
            return ITEM_TYPE.ITEM_TYPE_VIDEO.ordinal();
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //Called by RecyclerView when it starts observing this Adapter.
    //通过判断getItemViewType(position)来设置不同的跨度
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (getItemViewType(position) == ITEM_TYPE.ITEM_TYPE_THEME.ordinal()) {
                        return gridLayoutManager.getSpanCount();
                    } else if (getItemViewType(position) == ITEM_TYPE.ITEM_TYPE_VIDEO.ordinal()) {
                        return 1;
                    }
                    return 1;
                }
            });
        }
    }
}
