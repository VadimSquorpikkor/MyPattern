package com.squorpikkor.android.app.mypattern.SaveMe;

// Created by VadimSquorpikkor on 08.08.2017.

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class Controller {
    private SharedPreferences preferences;
    private final String SAVER = "saver";
    private final String SAVE_FIELD = "setting";

    private ArrayList<MyClass> objList;//Set???
    private ArrayList<String> objNameList;

    Controller(Context context) {
        objList = new ArrayList<>();
        objNameList = new ArrayList<>();
        preferences = context.getSharedPreferences(SAVER, Context.MODE_PRIVATE);

    }

    void createNewObj(String name) {
        if (!objNameList.contains(name)) {
            objList.add(new MyClass(name));
            objNameList.add(name);
        }
    }

    void SaveObjList() {
        saveStringArray(objNameList);
    }

    void loadObjList() {
        loadStringArray(objNameList);
    }


    private void saveStringArray(ArrayList<String> list) {//It should be own class, for better composition -- it can be using in another classes
        int count = 0;
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();//For save less variables than before, if do not clear, it will load old variables, from old session
        for (String s : list) {
            editor.putString(SAVE_FIELD + count, s);
            count++;
        }
        editor.apply();
    }

    private void loadStringArray(ArrayList<String> list) {
        list.clear();
        int count = 0;
        while (SAVER.contains(SAVE_FIELD + count)) {
            list.add(SAVE_FIELD + count);
            count++;
        }
    }
}
