package com.aaron.actionbarandtoolbardemo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * ActionBar 使用例子
 */
public class ActionBarTestActivity extends AppCompatActivity {
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);//确保icon图标能够作为一个操作项被点击
        actionBar.setDisplayHomeAsUpEnabled(true);//在ActionBar图标（如果没有设置图标icon，文字标题也可以代替）的左侧添加了一个向左的箭头
        actionBar.setDisplayShowHomeEnabled(true);//使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，否则，显示应用程序图标
        actionBar.setDisplayShowTitleEnabled(true);//使左上角标题是否显示
        actionBar.setDisplayShowCustomEnabled(true);//使自定义的普通View（比如输入框）能在title栏显示，即actionBar.setCustomView能起作用
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(ActionBarTestActivity.this, "点击了：" + item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.user_p:
                Toast.makeText(ActionBarTestActivity.this, "点击了：" + item.getItemId(), Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home://左上角图标点击动作
                Toast.makeText(ActionBarTestActivity.this, "点击了Home", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
