package com.huangjifeng.swiperefreshlayout;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_content);
        //下拉之后的监听，可以在监听中进行数据获取，获取完数据后可以进行界面跟新
        swipeRefreshLayout.setOnRefreshListener(this);
        //以下两个方法都是设置旋转进度的背景颜色
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.gray));
        //swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.holo_red_dark);
        //该方法是设置进度条的颜色，最多可以设置4种进度条
        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorAccent),
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorPrimaryDark));
        //设置圆形进度条的大小，有SwipeRefreshLayout.LARGE和SwipeRefreshLayout.DEFAULT
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        //设置下拉多少距离进行刷新，增加用户体验
        swipeRefreshLayout.setDistanceToTriggerSync(50);
        //暂时还不了解这个的用法，后期增加
        swipeRefreshLayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Toast.makeText(MainActivity.this,"要开始刷新了",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 7000);
    }
}
