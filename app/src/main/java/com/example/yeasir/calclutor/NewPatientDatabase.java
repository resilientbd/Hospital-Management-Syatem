package com.example.yeasir.calclutor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yeasi on 05-May-17.
 */

public class NewPatientDatabase extends SQLiteOpenHelper {

    private static final int database_version = 1;
    public static final String mydatabase = "newPatient.db";
    public static  String table = "patientTable";
    public static final String col_1 = "id";
    public static final String col_2 = "name";
    public static final String col_3 = "mobile";
    public static final String col_4 = "age";
    public static final String col_5 = "gender";
    public static final String col_6 = "disease";
    public static final String col_7 = "department";
    public static final String col_8 = "room";

    public NewPatientDatabase(Context context) {
        super(context, mydatabase,null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + table + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT,mobile TEXT,age TEXT,gender TEXT,disease TEXT,department TEXT,room TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + mydatabase);
        onCreate(sqLiteDatabase);
    }

    public boolean insertRegisterData(String name, String mobile, String age, String gender, String disease, String department,String room) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_2,name);
        contentValues.put(col_3,mobile);
        contentValues.put(col_4,age);
        contentValues.put(col_5,gender);
        contentValues.put(col_6,disease);
        contentValues.put(col_7,department);
        contentValues.put(col_8,room);

        long result = sqLiteDatabase.insert(table,null,contentValues);

        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData() {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor res = sqLiteDatabase.rawQuery("select * from " + table,null);
        return res;
    }
}
