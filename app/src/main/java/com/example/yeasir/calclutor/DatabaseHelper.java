package com.example.yeasir.calclutor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yeasir on 20-Apr-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String mydatabase = "user.db";
    public static  String table = "userTable";
    public static final String col_1 = "id";
    public static final String col_2 = "name";
    public static final String col_3 = "userName";
    public static final String col_4 = "password";
    public static final String col_5 = "email";
    public static final String col_6 = "address";
    public static final String col_7 = "mobile";
    public static final String col_8 = "userType";

    public DatabaseHelper(Context context) {

        super(context, mydatabase, null, 2);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + table + "(id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,userName TEXT,password TEXT,email TEXT,address TEXT,mobile TEXT,userType TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE doctor (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, CONTACT TEXT, EMAIL TEXT, DEPARTMENT TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE nurse (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, CONTACT TEXT, EMAIL TEXT, DEPARTMENT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + mydatabase);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS doctor");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS nurse");
        onCreate(sqLiteDatabase);

    }
    public boolean insertDocData(String name,String contact,String email,String department)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("CONTACT",contact);
        values.put("EMAIL",contact);
        values.put("DEPARTMENT",department);
        long result = db.insert("doctor",null,values);

        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllDoc()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor result=db.rawQuery("SELECT * FROM doctor",null);
        return result;

    }
    public List<Doctor> doclist()
    {
        List<Doctor> list=new ArrayList<Doctor>();
        Cursor rs=getAllDoc();
        if(rs.getCount()>0)
        {
            while(rs.moveToNext())
            {
                Doctor doc=new Doctor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                list.add(doc);
            }
        }
        return list;
    }
    public boolean insertNurse(String name,String contact,String email,String department)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("CONTACT",contact);
        values.put("EMAIL",contact);
        values.put("DEPARTMENT",department);
        long result =db.insert("nurse",null,values);

        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllNurse()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor result=db.rawQuery("SELECT * FROM nurse",null);
        return result;

    }
    public List<Nurse> nurselist()
    {
        List<Nurse> list=new ArrayList<Nurse>();
        Cursor rs=getAllNurse();
        if(rs.getCount()>0)
        {
            while(rs.moveToNext())
            {
                Nurse nurse=new Nurse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                list.add(nurse);
            }
        }
        return list;
    }

    public boolean insertRegisterData(String name, String uname, String pass, String email, String address, String mobile) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_2,name);
        contentValues.put(col_3,uname);
        contentValues.put(col_4,pass);
        contentValues.put(col_5,email);
        contentValues.put(col_6,address);
        contentValues.put(col_7,mobile);
        //contentValues.put(col_8,utype);

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

    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + table;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }
}
