package com.example.user.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private Button submit;

    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        submit = (Button)findViewById(R.id.saybtn);
        submit.setOnClickListener(gethoroscope);
        Intent intent = getIntent();//為了"接收"另一個頁面的回傳值，需要另一個Intent
        str = intent.getStringExtra("Name");
    }

    private OnClickListener gethoroscope = new OnClickListener() {
        @Override
        public void onClick(View v) {
            //為了"開啟新頁面"需要一個Intent
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,SayHelloActivity.class);
            startActivity(intent);//切換Activity
            }

        };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_Web) {
            Uri uri = Uri.parse("https://www.google.com.tw/");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
