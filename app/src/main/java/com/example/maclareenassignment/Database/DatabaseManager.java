package com.example.maclareenassignment.Database;

import static com.example.maclareenassignment.Database.SqlLiteHelper.Table_Name;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.maclareenassignment.Note.NoteModel;

import java.util.ArrayList;

public class DatabaseManager {

    private SqlLiteHelper dbHelper;

    private Context mcontext;

    private SQLiteDatabase sqLiteDatabase;

    public DatabaseManager(Context context) {
        mcontext = context;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new SqlLiteHelper(mcontext);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }


    public void insertNote(String title, String description) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(SqlLiteHelper.TITLE, title);
        contentValue.put(SqlLiteHelper.DESC, description);
        sqLiteDatabase.insert(Table_Name, null, contentValue);
    }


//    public Cursor fetchNotes() {
//        String[] columns = new String[] { SqlLiteHelper.ID, SqlLiteHelper.TITLE, SqlLiteHelper.DESC,SqlLiteHelper.created_at };
//        Cursor cursor = sqLiteDatabase.query(SqlLiteHelper.Table_Name, columns, null, null, null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//        return cursor;
//    }


    public ArrayList<NoteModel> fetchNotes() {
        dbHelper = new SqlLiteHelper(mcontext);
        sqLiteDatabase = dbHelper.getReadableDatabase();

        StringBuffer stringBuffer = new StringBuffer();
        NoteModel noteModel = null;


        Cursor cursorCourses = sqLiteDatabase.rawQuery("SELECT * FROM " + Table_Name, null);


        ArrayList<NoteModel> noteModelArrayList = new ArrayList<>();


// new code
        while (cursorCourses.moveToNext()) {

            noteModel = new NoteModel();

            int id = cursorCourses.getInt(cursorCourses.getColumnIndexOrThrow("id"));
            String title = cursorCourses.getString(cursorCourses.getColumnIndexOrThrow("title"));
            String description = cursorCourses.getString(cursorCourses.getColumnIndexOrThrow("description"));
            String DATETIME = cursorCourses.getString(cursorCourses.getColumnIndexOrThrow("DATETIME"));


            noteModel.setId(id);
            noteModel.setTitle(title);
            noteModel.setDescription(description);
            noteModel.setCreated_at(DATETIME);
            stringBuffer.append(noteModel);
            noteModelArrayList.add(noteModel);



        }




//old code===============
//        if (cursorCourses.moveToFirst()) {
//            do {
//
//                noteModelArrayList.add(new NoteModel(cursorCourses.getString(2),
//                        cursorCourses.getString(1),
//                        cursorCourses.getString(0)));
//            } while (cursorCourses.moveToNext());
//
//        }

            cursorCourses.close();
            return noteModelArrayList;



    }
}