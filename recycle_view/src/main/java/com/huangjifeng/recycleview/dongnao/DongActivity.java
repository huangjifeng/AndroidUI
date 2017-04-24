package com.huangjifeng.recycleview.dongnao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.huangjifeng.recycleview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */

public class DongActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong);
        initData();
        initView();
        initLinearRecycler();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.dong_recycle_view);
    }

    private void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add("item = " + i);
        }
    }

    private void initLinearRecycler() {
        mRecyclerView.setAdapter(new LinearRecyclerViewAdapter(this, list));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.addItemDecoration(new LinearItemDirection(this,LinearLayoutManager.HORIZONTAL));
    }
}
