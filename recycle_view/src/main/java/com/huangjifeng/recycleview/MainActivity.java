package com.huangjifeng.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.huangjifeng.recycleview.first.FirstActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<String> list = new ArrayList<String>();
    private RecyclerView recyclerView;
    private StaggeredGridRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new StaggeredGridRecyclerViewAdapter(list);
        //LayoutManager 布局摆放管理器（线性摆放，瀑布流）
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        * LinearLayoutManager：线性摆放
        *  LinearLayoutManager.HORIZONTAL：数据水平排布
        *  true：表示数据反向，从最后一个开始取
        * */
        /*recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        * new GridLayoutManager：格子式摆放
        * 3：代表多少列或者多少行
        * GridLayoutManager.VERTICAL：表示上下滑动
        * true：表示数据反向，从最后一个开始取
        * */
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    private void initData() {
        for (int i = 0; i < 40; i++) {
            list.add("这是第" + i + "个条目");
        }


    }

    public boolean isGrid = false;

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_change:
                if (isGrid) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
                }
                isGrid = !isGrid;
                break;
            case R.id.button_add:
                adapter.addItem(3, "哈哈");
                break;
            case R.id.button_delete:
                adapter.removeItem(4);
                break;
            case R.id.next_activity:
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
        }

    }
}
