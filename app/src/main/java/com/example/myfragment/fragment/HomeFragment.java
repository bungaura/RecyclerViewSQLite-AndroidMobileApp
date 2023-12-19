package com.example.myfragment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myfragment.R;
import com.example.myfragment.adapter.DataAdapter;
import com.example.myfragment.database.DatabaseHelper;

public class HomeFragment extends Fragment {

    private DatabaseHelper db;
    private ImageView saveBtn, showDataBtn;
    private EditText nameEt, emailEt, passEt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        db = new DatabaseHelper(getActivity());

        saveBtn = view.findViewById(R.id.saveButtonImageView);
        showDataBtn = view.findViewById(R.id.showDataButtonImageView);
        nameEt = view.findViewById(R.id.home_name_et);
        emailEt = view.findViewById(R.id.home_email_et);
        passEt = view.findViewById(R.id.home_pass_et);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                String email = emailEt.getText().toString();
                String pass = passEt.getText().toString();

                Boolean isInsertValid = db.insertData(name, email, pass);
                if (isInsertValid){
                    Toast.makeText(getActivity(), name + " data has just been saved!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Failed to save data!", Toast.LENGTH_LONG).show();
                }
            }
        });

        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.homeFragment, new ShowDataFragment());
                transaction.addToBackStack(null);  // Optional: Add to back stack if needed
                transaction.commit();
            }
        });



        return view;
    }
}