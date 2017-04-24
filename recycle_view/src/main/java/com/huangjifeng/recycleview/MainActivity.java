package com.huangjifeng.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.huangjifeng.recycleview.dongnao.DongActivity;
import com.huangjifeng.recycleview.first.FirstActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
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
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button001:
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
                break;
            case R.id.button002:
                startActivity(new Intent(MainActivity.this, DongActivity.class));
                break;
        }

    }
}
