package com.example.reminderapp;

import android.provider.BaseColumns;

public class MedicineConstant {
    private MedicineConstant(){}
    public static class MedicineTable implements BaseColumns{
        public static final String TABLE_NAME ="Medicine Database";
        public static final String COLUMN_IMAGE="Image";
        public static final String COLUMN_NAME="Medicine";
        public static final String COLUMN_DESCRIPTION="Description";
        public static final String COLUMN_PRICE="Price";
        public static final String COLUMN_DAY = "Day";
        public static final String COLUMN_TIME = "Time";
    }
}
