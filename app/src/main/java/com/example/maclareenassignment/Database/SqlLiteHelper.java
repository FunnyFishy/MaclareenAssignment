package com.example.maclareenassignment.Database;

import static javax.xml.datatype.DatatypeConstants.DATETIME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.maclareenassignment.Note.NoteModel;

import java.util.ArrayList;


public class SqlLiteHelper extends SQLiteOpenHelper {



    public static final String DataBase_Name = "SqlLiteDatabase";
    public static final String Table_Name = "Notes";
    public static final int DataBase_Version = 1;


    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESC = "description";
    public static final String created_at = "";


    private static final String CREATE_TABLE = "create table " + Table_Name + "(" + ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE + " TEXT NOT NULL, " + DESC + " TEXT,"
        + created_at +" DATETIME DEFAULT CURRENT_TIMESTAMP"+")";





    public SqlLiteHelper(Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

//        sqLiteDatabase.execSQL("Create table " + Table_Name +
//                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "TITLE TEXT," +
//                "description TEXT," +
//                "created_at DATETIME DEFAULT CURRENT_TIMESTAMP);");
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(sqLiteDatabase);

    }



//    public void addNewNote(String title, String description) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(title, title);
//        values.put(description, description);
//        db.insert(Table_Name, null, values);
//        db.close();
//    }








//    ArrayList<NoteModel> geNoteData() {
//        String sql = "select * from " + Table_Name;
//        SQLiteDatabase db = this.getReadableDatabase();
//        ArrayList<NoteModel> storeContacts = new ArrayList<>();
//        Cursor cursor = db.rawQuery(sql, null);
//        if (cursor.moveToFirst()) {
//            do {
//                int id = Integer.parseInt(cursor.getString(0));
//                String title = cursor.getString(1);
//                String descreption = cursor.getString(2);
//                String created_at = cursor.getString(3);
//
//                storeContacts.add(new NoteModel());
//            }
//            while (cursor.moveToNext());
//        }
//        cursor.close();
//        return storeContacts;
//    }
}
