package com.squorpikkor.android.app.mypattern.SaveMe;

// Created by VadimSquorpikkor on 07.08.2017.

/**
 * Old version that do not use Controller
 */

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

//public class MyClass_Old implements Saveable {
public class MyClass_Old {
    private SharedPreferences preferences;

    MyClass_Old(String name, Context context) {
        preferences = context.getSharedPreferences("mainPref", Context.MODE_PRIVATE);
        this.name = name;
        MyClassNameList.add(name);
    }

    static ArrayList<String> MyClassNameList = new ArrayList<>();

    String name = "var1";
    int var2 = 10;

    /*@Override
    public ArrayList<String> getAllVar() {
        return null;
    }

    @Override
    public void setAllVar(ArrayList<String> list) {

    }

    @Override
    public void saveMe() {


    }

    @Override
    public void loadMe() {
//        MyClass_Old()

    }*/
}
