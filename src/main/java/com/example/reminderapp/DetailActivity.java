package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
public static final String EXTRA_MEDICINE_ID ="medicine_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        MedicineFragment medicineFragment = (MedicineFragment)getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        long medicineId= getIntent().getLongExtra(EXTRA_MEDICINE_ID,0);
        medicineFragment.setMedicineId((int)medicineId);
    }
}