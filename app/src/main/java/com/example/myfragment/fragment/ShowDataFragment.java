package com.example.myfragment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragment.R;
import com.example.myfragment.adapter.DataAdapter;
import com.example.myfragment.database.DatabaseHelper;
import com.example.myfragment.model.DataItem;

import java.util.ArrayList;

public class ShowDataFragment extends Fragment {
    private RecyclerView recyclerView;
    private DataAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_data, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        ArrayList<DataItem> dataList = fetchDataFromDatabase();

        adapter = new DataAdapter(dataList);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    private ArrayList<DataItem> fetchDataFromDatabase() {
        DatabaseHelper dbHelper = new DatabaseHelper(requireContext());
        return dbHelper.getAllData();
    }
}