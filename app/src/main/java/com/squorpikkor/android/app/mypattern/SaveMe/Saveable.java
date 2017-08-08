package com.squorpikkor.android.app.mypattern.SaveMe;

// Created by VadimSquorpikkor on 07.08.2017.

import android.content.SharedPreferences;

import java.util.ArrayList;

interface Saveable {

    ArrayList<String> getAllVar();
    void setAllVar(ArrayList<String> list);

    void saveMe();
    void loadMe();
}
