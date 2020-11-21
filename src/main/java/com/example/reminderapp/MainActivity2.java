package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity implements MedicineListFragment.MedicineListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.list_fragment);
        if (fragmentContainer != null) {
            MedicineFragment medicineFragment = new MedicineFragment();
            medicineFragment.setMedicineId(id);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.list_fragment, medicineFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_MEDICINE_ID, id);
            startActivity(intent);
        }
    }
}