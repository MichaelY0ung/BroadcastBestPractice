package com.example.michael.broadcastbestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by michael on 2016/4/15.
 */
public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
