package com.huangjifeng.recycleview.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.huangjifeng.recycleview.R;

import java.util.ArrayList;
import java.util.EventListener;

/**
 * Created by Administrator on 2017/4/25.
 * <p>
 * 该demo主要是做RecycleView的不同布局相融合，可以利用这个demo设置头布局和尾布局
 */

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> mList;
    private RecyclerView mRecyclerView;
    private FirstRecyclerViewAdapter mAdapter;
    private Button first_button_01;
    private Button first_button_02;
    private static final int LINEAR_RECYCLER = 0;
    private static final int GRID_RECYCLER = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
        initData();
        initRecyclerView(LINEAR_RECYCLER);
        initListener();
    }

    private void initListener() {
        first_button_01.setOnClickListener(this);
        first_button_02.setOnClickListener(this);
    }

    private void initRecyclerView(int i) {
        if (i == LINEAR_RECYCLER) {
            //setLayoutManager()必须在setAdapter()之前,因为adapter中需要用到layoutManager进行判断
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            first_button_01.setEnabled(false);
            first_button_02.setEnabled(true);
        } else if (i == GRID_RECYCLER) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            first_button_01.setEnabled(true);
            first_button_02.setEnabled(false);
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.first_recycle_view);
        first_button_01 = (Button) findViewById(R.id.first_button_01);
        first_button_02 = (Button) findViewById(R.id.first_button_02);
    }

    private void initData() {
        mList = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            mList.add("item = " + i);
        }
        mAdapter = new FirstRecyclerViewAdapter(this, mList);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_button_01:
                initRecyclerView(LINEAR_RECYCLER);
                break;
            case R.id.first_button_02:
                initRecyclerView(GRID_RECYCLER);
                break;

        }
    }
}
