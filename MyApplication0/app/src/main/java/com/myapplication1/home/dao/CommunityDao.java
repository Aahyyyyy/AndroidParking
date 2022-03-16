package com.myapplication1.home.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.myapplication1.home.bean.Community;
import com.myapplication1.utils.MySQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/10 21:27
 */
public class CommunityDao {
    private MySQLiteOpenHelper helper;
    private SQLiteDatabase database;

    public CommunityDao(Context context) {
        helper = new MySQLiteOpenHelper(context, null, null, 0);
    }

    public List<Community> getAllCom() {
        ArrayList<Community> comList = new ArrayList<>();
        database = helper.getWritableDatabase();
        String sql = "select * from community";
        Cursor cursor = database.rawQuery(sql, null);
        // 游标从头读到尾
        for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
            Community community = new Community();
            community.setCno(cursor.getInt(cursor.getColumnIndex("Cno")));
            community.setCname(cursor.getString(cursor.getColumnIndex("Cname")));
            community.setCaddress(cursor.getString(cursor.getColumnIndex("Caddress")));
            community.setCphoto(cursor.getString(cursor.getColumnIndex("Cphoto")));
            community.setCcity(cursor.getString(cursor.getColumnIndex("Ccity")));
            comList.add(community);
        }
        System.out.println("---------------------------" + comList);
        return comList;
    }
}
