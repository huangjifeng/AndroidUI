package com.huangjifeng.linearlayoutcompat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        app:divider="@drawable/divider_line"
        用于设置分割线的内容，可以是一张.9图，也可以是自己自定义的shape

        app:dividerPadding="10dp"
        用于设置分割线的startPadding  和  endPadding

        app:showDividers="middle|beginning|end"

       用于设置元素的分割线位置，beginning表示所有元素的最前端
       middle表示所有元素之间        end表示所有元素的最尾端






        */
    }
}
