package com.squorpikkor.android.app.mypattern.SaveMe;

// Created by VadimSquorpikkor on 07.08.2017.

import java.util.ArrayList;

public interface Saveable {

    String name = null;
    void setAllVar(ArrayList<String> list);
    ArrayList<String> getAllVar();
}
