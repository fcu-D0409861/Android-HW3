package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class SayHelloActivity extends AppCompatActivity {

    private EditText inname;

    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hello);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        inname = (EditText)findViewById(R.id.input_name);//透過findViewById找到一個控件，並使用=把他綁在一個變數上，我們就可以利用那個變數操作綁定的控件
        str = inname.getText().toString();//取輸入的字串
        Button backbtn = (Button)findViewById(R.id.back_btn);
        backbtn.setOnClickListener(back);
        Intent intent = getIntent();
    }


    private OnClickListener back = new OnClickListener() {
        @Override
        public void onClick(View v) {
           // Intent intent = new Intent();//使用時間是頁面切換時使用，他可以讓你接收/發送資料，但是這兩件事需要不同的Intent
           // intent.putExtra("Name", str); //第一個參數綁定對應的標籤，取值的時候要用，第二個參數傳值
            str = inname.getText().toString();//取輸入的字串
            Toast.makeText(SayHelloActivity.this,"Hello "+str,Toast.LENGTH_SHORT).show();
            finish();//結束目前Activity
        }
    };

}
