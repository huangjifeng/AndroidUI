package com.huangjifeng.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.huangjifeng.recycleview.first.FirstActivity;
import com.huangjifeng.recycleview.second.SecondActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button001:
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
                break;
            case R.id.button002:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
            case R.id.button003:
                break;
        }
    }
}
