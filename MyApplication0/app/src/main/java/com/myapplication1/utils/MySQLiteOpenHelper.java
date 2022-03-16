package com.myapplication1.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * SQLiteOpenHelper 工具类
 * 单例模式(1.构造函数私有化 2.对外提供函数)
 *
 * @author : Aahyyyyy
 * @date : 2022/2/26 20:32
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "parking.db";
    private static final int DB_VERSION = 1;

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // 初始化数据库
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    // 升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
