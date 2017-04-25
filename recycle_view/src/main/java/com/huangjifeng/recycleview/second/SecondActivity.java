package com.huangjifeng.recycleview.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.huangjifeng.recycleview.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/25.
 */

public class SecondActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mList;
    private SecondRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new SecondItemDirection(this, R.drawable.item_shape));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mList = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            mList.add("item  =  " + i);
        }
        mAdapter = new SecondRecyclerViewAdapter(this, mList);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.second_recycle_view);
    }
}
