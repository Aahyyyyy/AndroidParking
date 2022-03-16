package com.myapplication1.my.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.myapplication1.utils.MySQLiteOpenHelper;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/10 21:26
 */
public class OwnerDao {
    private MySQLiteOpenHelper helper;
    private SQLiteDatabase database;

    public OwnerDao(Context context) {
        helper = new MySQLiteOpenHelper(context, null, null, 0);
    }

    public void doLogin(String phone) {
        database = helper.getWritableDatabase();
        String sql = "insert into owner(Ophonenum, Oidnum, Ocert, Ocheck, Oaddress, Oemail, Bname) " +
                     "values(?, null, 0, 0, null, null, null)";
        Object values[] = new Object[] { phone };
        database.execSQL(sql, values);
    }
}
