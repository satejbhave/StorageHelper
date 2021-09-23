package com.satejbhave.storagehelper;

import android.content.Context;
import android.content.SharedPreferences;

public class StorageHelper {
    Context context;
    String databaseName;
    private final String defaultDatabaseName = "satejbhave_storagehelperclass" ;


    public StorageHelper(Context context, String databaseName) {
        this.context = context;
        this.databaseName = databaseName;
    }

    public StorageHelper(Context context) {
        this.context = context;
        databaseName = defaultDatabaseName;
    }
}
