package com.akb.ferry.akbuts10116154;

/**
 * NIM : 10116154
 * Nama : Ferry Hermawan
 * Kelas : IF4
 * Tgl Pengerjaan : 19 Mei 2019
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akb.ferry.akbuts10116154.model.TemanModel;


import java.util.ArrayList;
import java.util.List;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.MyViewHolder> {
    private ArrayList<TemanModel> temanList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nim, nama, kelas, telpon, email, instagram;

        public MyViewHolder(View view) {
            super(view);
            nim = (TextView) view.findViewById(R.id.item_nim);
            nama = (TextView) view.findViewById(R.id.item_nama);
            kelas = (TextView) view.findViewById(R.id.item_kelas);
            telpon = (TextView) view.findViewById(R.id.item_telp);
            email = (TextView) view.findViewById(R.id.item_email);
            instagram = (TextView) view.findViewById(R.id.item_instagram);
        }
    }

    public TemanAdapter(ArrayList<TemanModel> temanList) {
        this.temanList = temanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teman_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TemanModel teman = temanList.get(position);
        holder.nim.setText(teman.getNIM());
        holder.nama.setText(teman.getNama());
        holder.kelas.setText(teman.getKelas());
        holder.telpon.setText(teman.getTelpon());
        holder.email.setText(teman.getEmail());
        holder.instagram.setText(teman.getInstagram());
    }

    @Override
    public int getItemCount() {
        return temanList.size();
    }
}
