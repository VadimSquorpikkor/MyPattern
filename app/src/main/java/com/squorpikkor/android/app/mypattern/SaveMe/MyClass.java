package com.squorpikkor.android.app.mypattern.SaveMe;

// Created by VadimSquorpikkor on 08.08.2017.

import java.util.ArrayList;

class MyClass implements Saveable{
    String name;
    MyClass(String name) {
        this.name = name;
    }

    @Override
    public void setAllVar() {

    }

    @Override
    public ArrayList<String> getAllVar() {
        return null;
    }
}
