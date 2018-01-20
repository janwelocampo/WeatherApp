package com.dstudio.janwelocampo.mvparchitecture.data.prefs;

import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

public class ObjectManager {

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public ObjectManager(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public Gson getGSON (){
        return  gson;
    }

    public  void setString(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public String getString(String key){
        return sharedPreferences.getString(key, null);
    }

    public  void setBoolean(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.commit();
    }

    public boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key, false);
    }

    public  void setInt(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(key, value).commit();
    }

    public int getInt(String key){
        return sharedPreferences.getInt(key, 0);
    }


}
