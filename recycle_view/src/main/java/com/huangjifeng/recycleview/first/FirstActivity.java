package com.huangjifeng.recycleview.first;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.huangjifeng.recycleview.R;

/**
 * http://blog.csdn.net/emperor_rock/article/details/51538266
 */

public class FirstActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_first);
    }
}
