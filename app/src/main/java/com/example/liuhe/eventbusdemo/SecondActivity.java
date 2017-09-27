package com.example.liuhe.eventbusdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by liuhe on 2017/9/16.
 */

public class SecondActivity extends Activity{

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        button = (Button) findViewById(R.id.send);
        textView = (TextView) findViewById(R.id.message);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("post", Thread.currentThread().getName());
                        EventBus.getDefault().post(new MessageEvent("NewMesage"));

                    }
                }).start();

            }

        });

    }

}
