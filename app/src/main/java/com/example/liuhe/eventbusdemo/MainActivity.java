package com.example.liuhe.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private Button post_btn, regist_btn, unregist_btn;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        post_btn = (Button) findViewById(R.id.post_message);
        regist_btn = (Button) findViewById(R.id.regist_seventbus);
        unregist_btn = (Button) findViewById(R.id.unregist_seventbus);

        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new MessageEvent("message" +
                        "---" +index++));
            }
        });

        regist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().register(MainActivity.this);
            }
        });

        unregist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().unregister(MainActivity.this);
            }
        });


    }


    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void showMessagePOSTINGEvent(MessageEvent messageEvent){
        Log.d("POSTING",messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void showMessageMainEvent(MessageEvent messageEvent){
        Log.d("MAIN",messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND, sticky = true)
    public void showMessageBACKGROUNDEvent(MessageEvent messageEvent){
        Log.d("BACKGROUND",messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void showMessageASYNCEvent(MessageEvent messageEvent){
        Log.d("ASYNC",messageEvent.getMessage());
    }


}
