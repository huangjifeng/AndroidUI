package com.huangjifeng.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * PopupMenu可以非常方便的在指定view的下面显示一个弹出菜单，类似于actionbar溢出菜单的效果。
        * 它的菜单选项可以来自于menu资源，因此非常方便。
        *
        * */

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.my_popup_menu, popupMenu.getMenu());
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu menu) {
                        Toast.makeText(MainActivity.this, "HAHAHHAHA", Toast.LENGTH_SHORT).show();
                    }
                });
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    private String toast_string;
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_01:
                                toast_string = new String("复制0001");
                                break;
                            case R.id.menu_02:
                                toast_string = new String("复制0002");
                                break;
                            case R.id.menu_03:
                                toast_string = new String("复制0003");
                                break;
                            case R.id.menu_04:
                                toast_string = new String("复制0004");
                                break;
                        }
                        Toast.makeText(MainActivity.this, toast_string, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

}
