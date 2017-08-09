package com.squorpikkor.android.app.mypattern.SaveMe;

// Created by VadimSquorpikkor on 08.08.2017.

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private SharedPreferences preferences;
    private HashMap<String, SharedPreferences> prefMap;
    private final String LIST_SAVER = "list_saver";
    private final String OBJ_MAP_SAVER = "object_map_saver";
    private final String SAVE_FIELD = "setting";

    private ArrayList<MyClass> objList;//Set???
    private ArrayList<String> objNameList;

    Context context;

    Controller(Context context) {
        objList = new ArrayList<>();
        objNameList = new ArrayList<>();
        preferences = context.getSharedPreferences(LIST_SAVER, Context.MODE_PRIVATE);

    }

    void createNewObj(String name) {
        if (!objNameList.contains(name)) {
            objList.add(new MyClass(name));
            objNameList.add(name);
        }
    }

    /*void saveObject(MyClass obj) {
        prefMap = new HashMap<>();//Or it should be initialized when created?
        prefMap.put(obj.name, (context.getSharedPreferences(obj.name, Context.MODE_PRIVATE)));
        SharedPreferences.Editor editor = prefMap.get(obj.name).edit();
        editor.clear();

    }*/

    void saveObject(MyClass obj) {
        prefMap.put(obj.name, (context.getSharedPreferences(obj.name, Context.MODE_PRIVATE)));
        saveStringArray(obj.getAllVar(), prefMap.get(obj.name));
    }

    void SaveObjNameList() {
        saveStringArray(objNameList);
    }

    void loadObjNameList() {
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

    private void saveStringArray(ArrayList<String> list, SharedPreferences sPref) {//It should be own class, for better composition -- it can be using in another classes
        int count = 0;
        SharedPreferences.Editor editor = sPref.edit();
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
        while (LIST_SAVER.contains(SAVE_FIELD + count)) {
            list.add(SAVE_FIELD + count);
            count++;
        }
    }

    private void loadStringArray(ArrayList<String> list, SharedPreferences sPref) {
        list.clear();
        int count = 0;
        while (sPref.contains(SAVE_FIELD + count)) {
            list.add(SAVE_FIELD + count);
            count++;
        }
    }
}
