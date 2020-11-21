package com.example.reminderapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MedicineListFragment extends ListFragment {
    private MedicineListListener medicineListListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_game_list, container, false);

        MedicineDb medicineDb = new MedicineDb(getActivity());

        ArrayAdapter<Medicine> arrayAdapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                medicineDb.get());

        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.medicineListListener = (MedicineListListener) context;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if (medicineListListener != null) {
            medicineListListener.itemClicked(id);
        }
    }

    interface MedicineListListener {
        void itemClicked(long id);
    }
}