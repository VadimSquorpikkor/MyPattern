package com.squorpikkor.android.app.mypattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squorpikkor.android.app.mypattern.SaveMe.Controller;

public class MainActivity extends AppCompatActivity {

//    ListWS listWS;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new Controller(this);

    }
}
