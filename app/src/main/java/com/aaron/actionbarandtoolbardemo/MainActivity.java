package com.aaron.actionbarandtoolbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ab = (Button)findViewById(R.id.btn_ab);
        Button btn_tb01 = (Button)findViewById(R.id.btn_tb01);
        Button btn_tb02 = (Button)findViewById(R.id.btn_tb02);

        btn_ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActionBarTestActivity.class);
                startActivity(intent);
            }
        });

        btn_tb01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ToolbarTestActivity.class);
                startActivity(intent);
            }
        });

        btn_tb02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ToolbarTest2Activity.class);
                startActivity(intent);
            }
        });
    }
}
