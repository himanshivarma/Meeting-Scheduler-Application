package com.example.homepage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Addingmeetingsc extends SQLiteOpenHelper {
    public Addingmeetingsc(Context context) {
        super(context, "meeting.db", null, 1);
    }

    public boolean add(int meetingid, String[] date, String time, String agenda) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("meetingid", meetingid);
        values.put("date", date[0]);
        values.put("time", time);
        values.put("agenda", agenda);

        // Check if meetingid already exists
        if (checkMeetingIdExists(meetingid)) {


            return false;
        }

        long val = db.insert("meetingschedule", null, values);
        if (val != -1) {
            return true;
        }

        return false;
    }

    private boolean checkMeetingIdExists(int meetingid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT meetingid FROM meetingschedule WHERE meetingid=?", new String[]{String.valueOf(meetingid)});

        boolean exists = cursor.moveToFirst();

        cursor.close();
        return exists;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE IF NOT EXISTS meetingschedule (meetingid INTEGER primary key,date TEXT,time TEXT,agenda TEXT)";
        db.execSQL(query);
    }
    public Cursor getData(String date)
    {
        SQLiteDatabase db=this.getReadableDatabase();
       date="'"+date+"'";
       Cursor cursor=db.rawQuery("select *from meetingschedule where date="+date,null);
       return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS meetingschedule");
        onCreate(db);
    }

    public int del(String id) {
        SQLiteDatabase db = this.getWritableDatabase(); // Assuming you want to perform a write operation
        Cursor cursor = null;
        int deletedRowCount = 0;

        try {
            String selection = "id = ?";
            String[] selectionArgs = { String.valueOf(id) };

            deletedRowCount = db.delete("meetingschedule", selection, selectionArgs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return deletedRowCount;
    }

}
