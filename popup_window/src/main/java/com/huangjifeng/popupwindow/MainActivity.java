package com.huangjifeng.popupwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

//ListPopupWindow和popupWindow的简单使用
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private View contentView;
    private PopupWindow popupWindow;
    private Button button_list_popup_window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });

        button_list_popup_window = (Button) findViewById(R.id.button_list_popup_window);
        button_list_popup_window.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shouListPopupWindow();
            }
        });
    }


    private void showPopupWindow() {
        if (popupWindow == null) {
            //初始化并创建popupWindow时需要至少设置3个变量：
            // View contentView，int width, int height ；少任意一个就不可能弹出来PopupWindow！！！！
            //一般最常用这个构造函数进行PopupWindow的创建，contentView是弹出来的popup布局
            //如果在代码中重新设置了popupWindow的宽和高，那就以代码中所设置为准
            contentView = LayoutInflater.from(this).inflate(R.layout.popup_layout, null);
            popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setOutsideTouchable(false);
            //设置PopupWindow是否响应touch事件，默认是true，如果设置为false，所有touch事件无响应，包括点击事件
            //popupWindow.setTouchable(false);

            TextView text_share = (TextView) contentView.findViewById(R.id.share);
            TextView text_delete = (TextView) contentView.findViewById(R.id.delete);
            TextView text_save = (TextView) contentView.findViewById(R.id.save);
            text_share.setOnClickListener(this);
            text_delete.setOnClickListener(this);
            text_save.setOnClickListener(this);
        }
        if (!popupWindow.isShowing()) {
            //相对某个控件的位置（正左下方），无偏移       showAsDropDown(View anchor)：
            //popupWindow.showAsDropDown(button);

            //相对某个控件的位置，有偏移;xoff表示x轴的偏移，正值表示向左，负值表示向右；yoff表示相对y轴的偏移，
            // 正值是向下，负值是向上；             showAsDropDown(View anchor, int xoff, int yoff)：
            //popupWindow.showAsDropDown(button,10,200);

            //相对于父控件的位置（例如正中央Gravity.CENTER，下方Gravity.BOTTOM等），可以设置偏移或无偏移
            //showAtLocation(View parent, int gravity, int x, int y)：
            //root_view 为 popupWindow 控件所处的父控件
            View root_view = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
            popupWindow.showAtLocation(root_view, Gravity.BOTTOM, 0, 0);
        }
    }

    @Override
    public void onClick(View v) {
        String toast_string = null;
        switch (v.getId()) {
            case R.id.share:
                toast_string = "分享";
                break;
            case R.id.delete:
                toast_string = "删除";
                break;
            case R.id.save:
                toast_string = "保存";
                break;
        }
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        Toast.makeText(this, toast_string, Toast.LENGTH_SHORT).show();
    }

    private void shouListPopupWindow() {
        String[] items = {"item1", "item2", "item3", "item4", "item5"};
        final ListPopupWindow listPopupWindow = new ListPopupWindow(MainActivity.this);
        //设置ListView类型的适配器
        listPopupWindow.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items));
        //给每个item设置监听事件
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listPopupWindow.dismiss();
            }
        });
        //设置ListPopupWindow的锚点,也就是弹出框的位置是相对当前参数View的位置来显示，
        listPopupWindow.setAnchorView(button_list_popup_window);
        //ListPopupWindow 距锚点的距离，也就是相对锚点View的位置
        listPopupWindow.setHorizontalOffset(100);
        listPopupWindow.setVerticalOffset(100);

        //设置对话框的宽高
        listPopupWindow.setWidth(300);
        listPopupWindow.setHeight(600);
        listPopupWindow.setModal(false);

        listPopupWindow.show();

    }
}
