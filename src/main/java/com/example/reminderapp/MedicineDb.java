package com.example.reminderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MedicineDb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "medicine.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public MedicineDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_TABLE = "CREATE TABLE " +
                MedicineConstant.MedicineTable.TABLE_NAME + "(" +
                MedicineConstant.MedicineTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MedicineConstant.MedicineTable.COLUMN_IMAGE + " INTEGER, " +
                MedicineConstant.MedicineTable.COLUMN_NAME + " TEXT, " +
                MedicineConstant.MedicineTable.COLUMN_DESCRIPTION + " TEXT, " +
                MedicineConstant.MedicineTable.COLUMN_PRICE + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_TABLE);
        fillMedicineTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MedicineConstant.MedicineTable.TABLE_NAME);
        onCreate(db);
    }

    public void fillMedicineTable() {
        Medicine m1 = new Medicine(R.drawable.advil, "Advil", "Hello", "$20");
        add(m1);
    }

    private void add(Medicine m) {
        ContentValues cv = new ContentValues();
        cv.put(MedicineConstant.MedicineTable.COLUMN_IMAGE, m.getImage());
        cv.put(MedicineConstant.MedicineTable.COLUMN_NAME, m.getMedicine());
        cv.put(MedicineConstant.MedicineTable.COLUMN_DESCRIPTION, m.getDescription());
        cv.put(MedicineConstant.MedicineTable.COLUMN_PRICE, m.getPrice());

        db.insert(MedicineConstant.MedicineTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Medicine> get() {
        ArrayList<Medicine> medicinesList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + MedicineConstant.MedicineTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Medicine m = new Medicine();
                m.setImage(c.getInt(c.getColumnIndex(MedicineConstant.MedicineTable.COLUMN_IMAGE)));
                m.setMedicine(c.getString(c.getColumnIndex(MedicineConstant.MedicineTable.COLUMN_NAME)));
                m.setDescription(c.getString(c.getColumnIndex(MedicineConstant.MedicineTable.COLUMN_DESCRIPTION)));
                m.setPrice(c.getString(c.getColumnIndex(MedicineConstant.MedicineTable.COLUMN_PRICE)));
                medicinesList.add(m);
            } while (c.moveToNext());
        }
        c.close();
        return medicinesList;
    }
}
