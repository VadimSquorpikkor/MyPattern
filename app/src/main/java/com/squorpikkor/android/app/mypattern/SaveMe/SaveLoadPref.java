package com.squorpikkor.android.app.mypattern.SaveMe;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by Vadim on 09.08.2017.
 *
 * This class I plan to use in my Android project
 * in composition case to build classes with ability
 * to save and load data using sharedPreferences class
 *
 * I guess its so boring to write same stuff time after time...
 */


public class SaveLoadPref {

    private SharedPreferences preferences;
    private Context context;
    private final String LIST_SAVER = "list_saver";
    private final String SAVE_FIELD = "setting";

    SaveLoadPref(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(LIST_SAVER, Context.MODE_PRIVATE);

    }

    private void saveStringArray(ArrayList<String> list) {
        int count = 0;
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();//For save less variables than before, if do not clear, it will load old variables, from old session
        for (String s : list) {
            editor.putString(SAVE_FIELD + count, s);
            count++;
        }
        editor.apply();
    }

    private void saveStringArray(ArrayList<String> list, SharedPreferences sPref) {
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
