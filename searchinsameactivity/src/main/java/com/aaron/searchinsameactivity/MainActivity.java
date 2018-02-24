package com.aaron.searchinsameactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 调出搜索框
 */
public class MainActivity extends Activity implements OnClickListener {
    /**
     * Called when the activity is first created.
     */
    private EditText etdata;
    private Button btnsearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findview();
    }

    private void findview() {
        etdata = (EditText) findViewById(R.id.etdata);
        btnsearch = (Button) findViewById(R.id.btncall);
        btnsearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onSearchRequested();
    }

    @Override
    public boolean onSearchRequested() {

        String text = etdata.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("data", text);

        //打开浮动搜索框（第一个参数默认添加到搜索框的值）
        //bundle为传递的数据
        startSearch("", false, bundle, false);
        //这个地方一定要返回真 如果只是super.onSearchRequested方法
        //不但onSearchRequested（搜索框默认值）无法添加到搜索框中
        //bundle也无法传递出去
        return true;
    }

}