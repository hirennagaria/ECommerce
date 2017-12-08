package com.hiren.ecommerce;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = ProductDatabase.NAME, version = ProductDatabase.VERSION)
public class ProductDatabase {
    public static final String NAME = "MyDataBase";

    public static final int VERSION = 1;
}