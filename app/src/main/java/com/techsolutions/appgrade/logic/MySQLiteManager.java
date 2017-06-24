package com.techsolutions.appgrade.logic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YUVALLEV on 24/06/2017.
 */

public class MySQLiteManager extends SQLiteOpenHelper {

    private static String DB_NAME = "SQLite_App_Grade.db";  // Database Name
    private static final int DB_VERSION = 1;                    // Database Version
    private Context savedContext;
    private SQLiteDatabase myDataBase;

    //Courses Table
    private static final String TABLE_COURSES = "TABLE_COURSES";
    private static final String KEY_COURSE_NAME = "COURSE_NAME";
    private static final String KEY_COURSE_NUMBER = "COURSE_NUMBER";

    public MySQLiteManager(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        this.savedContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        //Create COURSES_TABLE
        String CREATE_TABLE_COURSES = "CREATE TABLE " + TABLE_COURSES + "("
                + KEY_COURSE_NAME + " TEXT,"
                + KEY_COURSE_NUMBER + " INTEGER" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_COURSES);

        this.myDataBase = sqLiteDatabase;
    }


    public void deleteDB()
    {
        savedContext.deleteDatabase(DB_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
    }

    //region Table Courses methods
    public void addToCoursesTable(String courseName, int courseNumber)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_COURSE_NAME, courseName);
        values.put(KEY_COURSE_NUMBER, courseNumber);
        db.insert(TABLE_COURSES, null, values);
    }

    public List<String> getCoursesNames()
    {
        String[] columns = new String[]{KEY_COURSE_NAME};
        Cursor c = getReadableDatabase().query(TABLE_COURSES, columns, null, null, null, null, null);
        int columnIndex = c.getColumnIndex(KEY_COURSE_NAME);

        List<String> result = new ArrayList<>();
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            String str = c.getString(columnIndex);
            result.add(str);
        }
        return result;
    }
    //endregion Table Courses methods
}
