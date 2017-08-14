package com.squorpikkor.android.app.mypattern.SaveMe;

// Created by VadimSquorpikkor on 08.08.2017.

import java.util.ArrayList;

class MyClass implements Saveable{
    String name;
    MyClass(String name) {
        this.name = name;
    }

    @Override
    public void setAllVar(ArrayList<String> list) {
        name = list.get(0);
    }

    @Override
    public ArrayList<String> getAllVar() {
        ArrayList<String> list = new ArrayList<>();
        list.add(name);
        return list;
    }
}
