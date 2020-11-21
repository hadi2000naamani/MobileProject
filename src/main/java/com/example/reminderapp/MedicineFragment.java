package com.example.reminderapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MedicineFragment extends Fragment {

    private long medicineId;
    private ArrayList<Medicine> medicines;
    private Medicine medicine;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (savedInstanceState != null) {
            medicineId = savedInstanceState.getLong("medicine_id");
        }

        return inflater.inflate(R.layout.fragment_medicine, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        MedicineDb db = new MedicineDb(getActivity());
        medicines = db.get();

        if (view != null) {
            ImageView img = view.findViewById(R.id.img);
            TextView title = view.findViewById(R.id.title);
            TextView description = view.findViewById(R.id.description);
            TextView price = view.findViewById(R.id.price);
            medicine = medicines.get(0);

            img.setImageResource(medicine.getImage());
            title.setText(medicine.getMedicine());
            description.setText(medicine.getDescription());
            price.setText(medicine.getPrice());

        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong("medicine_id", medicineId);
    }

    public void setMedicineId(long id) {
        this.medicineId = id;
    }
}