package com.huangjifeng.recycleview.second;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/4/25.
 */

public class SecondItemDirection extends RecyclerView.ItemDecoration {

    private final Context mContext;
    private final Drawable mDrawable;

    public SecondItemDirection(Context context, int drawID) {
        super();
        this.mContext = context;
        mDrawable = ContextCompat.getDrawable(mContext, drawID);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childViewCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 0; i < childViewCount; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int top = childView.getBottom() + layoutParams.bottomMargin + Math.round(ViewCompat.getTranslationY(childView));
            int bottom = top + mDrawable.getIntrinsicHeight();
            mDrawable.draw(c);
            mDrawable.setBounds(left, top, right, bottom);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, mDrawable.getIntrinsicHeight());
    }


}
