package com.huangjifeng.recycleview.dongnao;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.huangjifeng.recycleview.R;

/**
 * Created by Administrator on 2017/4/24.
 */

public class LinearItemDirection extends RecyclerView.ItemDecoration {
    private final Context mContext;
    private final int mDirection;
    private Drawable mDivider;

    public LinearItemDirection(Context context, int direction) {
        this.mContext = context;
        this.mDirection = direction;
        mDivider = ContextCompat.getDrawable(mContext, R.drawable.item_shape);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mDirection == LinearLayoutManager.VERTICAL) {
            setVerticalDivider(c, parent);
        } else {
            setHorizalDivider(c, parent);
        }
    }

    private void setHorizalDivider(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int left = childView.getRight() + layoutParams.rightMargin + Math.round(ViewCompat.getTranslationX(childView));
            int right = left + mDivider.getIntrinsicWidth();
            int top = parent.getPaddingTop() + layoutParams.topMargin;
            int bottom = parent.getHeight() - parent.getPaddingBottom() - layoutParams.bottomMargin;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    private void setVerticalDivider(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int left = parent.getPaddingLeft() + layoutParams.leftMargin;
            int right = parent.getWidth() - parent.getPaddingRight() - layoutParams.rightMargin;
            int top = childView.getBottom() + layoutParams.bottomMargin + Math.round(ViewCompat.getTranslationY(childView));
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mDirection == LinearLayoutManager.VERTICAL) {
            outRect = new Rect(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect = new Rect(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}
