package com.squorpikkor.android.app.mypattern.SaveMe;

// Created by VadimSquorpikkor on 08.08.2017.

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    //region ClassFields
    private SharedPreferences preferences;
    private SharedPreferences objPref;
    private HashMap<String, SharedPreferences> prefMap;
    private final String LIST_SAVER = "list_saver";
    private final String SAVE_FIELD = "setting";

    private ArrayList<MyClass> objList;//Set???
    /**    private ArrayList<Saveable> objList2;//
     *     ArrayList should be with interface implementation type
     */
    private ArrayList<String> objNameList;

    private Context context;
    //endregion

    public Controller(Context context) {
        this.context = context;
        objList = new ArrayList<>();
        objNameList = new ArrayList<>();
        preferences = context.getSharedPreferences(LIST_SAVER, Context.MODE_PRIVATE);
        prefMap = new HashMap<>();
    }

    private MyClass getObj(String name) {
        for (MyClass myClass : objList) {
            if (myClass.name.equals(name)) {
                return myClass;
            }
        }
        return null;
    }

    public ArrayList<String> getObjVarArray(String name) {
        return getObj(name).getAllVar();
    }

    public void createObj(String name) {
        if (!objNameList.contains(name)) {
            objList.add(new MyClass(name));
            objNameList.add(name);
            saveObjList();
            saveObjNameList();
        }
    }

    public void saveObject(MyClass obj) {
        if (!prefMap.containsKey(obj.name)) {
            prefMap.put(obj.name, (context.getSharedPreferences(obj.name, Context.MODE_PRIVATE)));
        }
        saveStringArray(obj.getAllVar(), prefMap.get(obj.name));


    }

    public void loadObject(String name) {

    }

    public void saveObjList() {
        for (MyClass mClass : objList) {
            saveObject(mClass);
        }
    }

    public void loadObjList() {

    }

    public void saveObjNameList() {
        saveStringArray(objNameList);
    }

    public void loadObjNameList() {
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
