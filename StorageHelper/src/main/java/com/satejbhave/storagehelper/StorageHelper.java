package com.satejbhave.storagehelper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class StorageHelper {
    Context context;
    String databaseName;
    final String LIST_SIZE = "list_size_";
    String defaultDatabaseName = "satejbhavestoragehelperclass";
    SharedPreferences sharedPreference;



    public StorageHelper(Context context , String databaseName) {
        this.context = context;
        this.databaseName = databaseName;
        sharedPreference = context.getSharedPreferences(databaseName, Context.MODE_PRIVATE);
    }
    public StorageHelper(Context context) {
        this.context = context;
        databaseName = defaultDatabaseName;
        sharedPreference = context.getSharedPreferences(defaultDatabaseName, Context.MODE_PRIVATE);
    }


    // --------------------------------- PUT SECTION ---------------------------------

    public void put(String key ,String data){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString(key, data);
        editor.apply();
    }
    public void put(String key ,Boolean data){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putBoolean(key, data);
        editor.apply();
    }
    public void put(String key ,int data){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putInt(key, data);
        editor.apply();
    }
    public void put(String key ,float data){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putFloat(key, data);
        editor.apply();
    }
    public void put(String key , List<String> data, String defaultValue){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putInt(key + LIST_SIZE,data.size());
        for (String x : data){
            int x2 = data.indexOf(x) +1;
            editor.putString(key + x2, x);
        }
        editor.apply();
    }
    public void put(String key , List<Integer> data , int defaultValue){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putInt(key + LIST_SIZE,data.size());
        for (int x : data){
            int x2 = data.indexOf(x) +1;
            editor.putInt(key + x2, x);
        }
        editor.apply();
    }
    public void put(String key , List<Boolean> data ,Boolean defaultValue){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putInt(key + LIST_SIZE,data.size());
        for (Boolean x : data){
            int x2 = data.indexOf(x) +1;
            editor.putBoolean(key + x2, x);
        }
        editor.apply();
    }

    // --------------------------------- GET SECTION ---------------------------------

    public String getStringData(String key){
        return sharedPreference.getString(key,"");
    }
    public Boolean getBooleanData(String key){
        return sharedPreference.getBoolean(key,false);
    }
    public int getIntegerData(String key){
        return sharedPreference.getInt(key,0);
    }
    public Float getFloatData(String key){
        return sharedPreference.getFloat(key,0);
    }
    public List<Integer> getIntegerList(String key){
        List<Integer> objectList = new ArrayList<>();
        for (int i = 1 ; i <= sharedPreference.getInt(key + LIST_SIZE,0) ;i++) {
            objectList.add(sharedPreference.getInt(key + i, 0));
        }
        return objectList;
    }
    public List<String> getStringList(String key){
        List<String> objectList = new ArrayList<>();
        for (int i = 1 ; i <= sharedPreference.getInt(key + LIST_SIZE,0) ;i++) {
            objectList.add(sharedPreference.getString(key + i, ""));
        }
        return objectList;
    }
    public List<Boolean> getBooleanList(String key){
        List<Boolean> objectList = new ArrayList<>();
        for (int i = 1 ; i <= sharedPreference.getInt(key + LIST_SIZE,0) ;i++) {
            objectList.add(sharedPreference.getBoolean(key + i, false));
        }
        return objectList;
    }
    public Set<String> getAllKeys(){
        return sharedPreference.getAll().keySet();
    }

    // --------------------------------- IS SECTION ---------------------------------

    public Boolean isKeyExist(String key){
        return sharedPreference.getAll().containsKey(key);
    }
    public Boolean isValueExist(Object values){
        return sharedPreference.getAll().containsValue(values);
    }

    // --------------------------------- DELETE SECTION ---------------------------------

    public void delete(String key){
        sharedPreference.edit().remove(key).apply();
    }
    public void deleteAll(){
        sharedPreference.edit().clear().apply();
    }

    // --------------------------------- FUNCTIONS SECTION ---------------------------------

    public void incrementValue(String key){
        int temp = getIntegerData(key);
        temp++;
        delete(key);
        put(key,temp);
    }
    public void decrementValue(String key){
        int temp = getIntegerData(key);
        temp--;
        delete(key);
        put(key,temp);
    }



}
