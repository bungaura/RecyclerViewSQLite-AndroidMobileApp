package com.example.myfragment.adapter;

import static android.provider.Settings.System.getString;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfragment.R;
import com.example.myfragment.model.DataItem;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<DataItem> dataList;

    public DataAdapter(ArrayList<DataItem> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataItem dataItem = dataList.get(position);

        holder.id.setText("ID #" + String.valueOf(dataItem.getId()));
        holder.name.setText(dataItem.getName());
        holder.email.setText(dataItem.getEmail());
        holder.password.setText(dataItem.getPassword());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, email, password;
        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.card_id_tv);
            name = itemView.findViewById(R.id.card_name_tv);
            email = itemView.findViewById(R.id.card_email_tv);
            password = itemView.findViewById(R.id.card_pass_tv);
        }
    }
}
