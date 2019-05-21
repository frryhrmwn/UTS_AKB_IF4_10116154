package com.akb.ferry.akbuts10116154;

/**
 * NIM : 10116154
 * Nama : Ferry Hermawan
 * Kelas : IF4
 * Tgl Pengerjaan : 19 Mei 2019
 */


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.akb.ferry.akbuts10116154.model.TemanModel;


import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TemanFragment extends Fragment {

    private ArrayList<TemanModel> temanList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TemanAdapter mAdapter;
    CRUD crud = new CRUD();


    public TemanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teman, container, false);


        recyclerView = view.findViewById(R.id.teman_rv);

        mAdapter = new TemanAdapter(temanList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        //LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(mAdapter);


        /*

        final RecyclerView recyclerView = view.findViewById(R.id.teman_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //mHistoryViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        mAdapter = new TemanAdapter(temanList);
        recyclerView.setAdapter(mAdapter);

        */



        prepareTemanData();

        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
                recyclerView.setAdapter(mAdapter);
            }
        });


        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                final TemanModel teman = temanList.get(position);
                //Toast.makeText(getActivity().getApplicationContext(), teman.getNama() + " is selected!", Toast.LENGTH_SHORT).show();
                //displayEditDialog();

                final String nim = temanList.get(position).getNIM();
                final String nama = temanList.get(position).getNama();
                final String kelas = temanList.get(position).getKelas();
                final String telp = temanList.get(position).getTelpon();
                final String email = temanList.get(position).getEmail();
                final String instagram = temanList.get(position).getInstagram();

                final CharSequence[] dialogitem = {"Edit", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        switch (which) {
                            case 0:
                                final Dialog de;

                                de = new Dialog(getActivity());
                                de.setTitle("Update / Delete Teman");
                                de.setContentView(R.layout.dialog_edit);

                                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                                lp.copyFrom(de.getWindow().getAttributes());
                                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                                lp.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
                                de.show();
                                de.getWindow().setAttributes(lp);


                                final EditText et_nim = (EditText) de.findViewById(R.id.et_nim);
                                final EditText et_nama = (EditText) de.findViewById(R.id.et_nama);
                                final EditText et_kelas = (EditText) de.findViewById(R.id.et_kelas);
                                final EditText et_telpon = (EditText) de.findViewById(R.id.et_telpon);
                                final EditText et_email = (EditText) de.findViewById(R.id.et_email);
                                final EditText et_instagram = (EditText) de.findViewById(R.id.et_instagram);
                                Button updateBtn= (Button) de.findViewById(R.id.updateBtn);

                                /*
                                et_nim.setText(crud.getTemanList().get(position).getNIM());
                                et_nama.setText(crud.getTemanList().get(position).getNama());
                                et_kelas.setText(crud.getTemanList().get(position).getKelas());
                                et_telpon.setText(crud.getTemanList().get(position).getTelpon());
                                et_email.setText(crud.getTemanList().get(position).getEmail());
                                et_instagram.setText(crud.getTemanList().get(position).getInstagram());
                                */

                                updateBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //GET DATA
                                        String newNim=et_nim.getText().toString();
                                        String newNama=et_nama.getText().toString();
                                        String newKelas=et_kelas.getText().toString();
                                        String newTelpon=et_telpon.getText().toString();
                                        String newEmail=et_email.getText().toString();
                                        String newInstagram=et_instagram.getText().toString();

                                        //VALIDATE
                                        if(newNim.length()>0 && newNim != null
                                                && newNama.length()>0 && newNama != null
                                                && newKelas.length()>0 && newKelas != null
                                                && newTelpon.length()>0 && newTelpon != null
                                                && newEmail.length()>0 && newEmail != null
                                                && newInstagram.length()>0 && newInstagram != null)
                                        {
                                            // update
                                            crud.update(position, newNim, newNama, newKelas, newTelpon, newEmail, newInstagram);

                                            TemanAdapter mAdapter = new TemanAdapter(temanList);
                                            recyclerView.setAdapter(mAdapter);
                                            de.dismiss();

                                        }else
                                        {
                                            Snackbar.make(view, "Ada data yang kosong atau salah diinputkan", Snackbar.LENGTH_LONG)
                                                    .setAction("Action", null).show();
                                        }
                                    }

                                });

                                de.show();
                                recyclerView.setAdapter(mAdapter);


                                break;
                            case 1:
                                try {
                                    temanList.remove(position);

                                }catch (Exception e)
                                {
                                    e.printStackTrace();

                                }
                                break;
                        }
                    }
                }).show();


            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        // set the adapter
        //recyclerView.setAdapter(mAdapter);



        return view;
    }

    private void prepareTemanData() {
        /*
        temanModel teman = new temanModel("10101010", "Asep", "IF4", "08123456789", "asep@gmail.com", "igasep");
        temanList.add(teman);

        temanModel teman = new temanModel("10101011", "Budi", "IF4", "089987654321", "budi@gmail.com", "inibudi");
        temanList.add(teman);

        temanModel teman = new temanModel("10101012", "Chandra", "IF4", "08135798642", "chandra@gmail.com", "chanderara");
        temanList.add(teman);

        temanModel teman = new temanModel("10101013", "Dedi", "IF4", "08578374344", "dedi@gmail.com", "dedd");
        temanList.add(teman);

        temanModel teman = new temanModel("10101014", "Echa", "IF4", "089846384345", "echa@gmail.com", "itsecha");
        temanList.add(teman);
        */

        temanList = new ArrayList<>();
        temanList.add(new TemanModel("10101010", "Asep", "IF4", "08123456789", "asep@gmail.com", "igasep"));
        temanList.add(new TemanModel("10101011", "Budi", "IF4", "089987654321", "budi@gmail.com", "inibudi"));
        temanList.add(new TemanModel("10101012", "Chandra", "IF4", "08135798642", "chandra@gmail.com", "chanderara"));
        temanList.add(new TemanModel("10101013", "Dedi", "IF4", "08578374344", "dedi@gmail.com", "dedd"));
        temanList.add(new TemanModel("10101014", "Echa", "IF4", "089846384345", "echa@gmail.com", "itsecha"));

        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void displayInputDialog(){
        final Dialog d;
        d = new Dialog(getActivity());
        d.setTitle("Tambah Teman");
        d.setContentView(R.layout.dialog_input);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(d.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
        d.show();
        d.getWindow().setAttributes(lp);


        final EditText et_nim = (EditText) d.findViewById(R.id.et_nim);
        final EditText et_nama = (EditText) d.findViewById(R.id.et_nama);
        final EditText et_kelas = (EditText) d.findViewById(R.id.et_kelas);
        final EditText et_telpon = (EditText) d.findViewById(R.id.et_telpon);
        final EditText et_email = (EditText) d.findViewById(R.id.et_email);
        final EditText et_sosmed = (EditText) d.findViewById(R.id.et_instagram);
        Button tambahBtn= (Button) d.findViewById(R.id.tambahBtn);

        tambahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GET DATA
                String nim=et_nim.getText().toString();
                String nama=et_nama.getText().toString();
                String kelas=et_kelas.getText().toString();
                String telpon=et_telpon.getText().toString();
                String email=et_email.getText().toString();
                String sosmed=et_sosmed.getText().toString();

                //VALIDATE
                if(nim.length()>0 && nim != null
                        && nama.length()>0 && nama != null
                        && kelas.length()>0 && kelas != null
                        && telpon.length()>0 && telpon != null
                        && email.length()>0 && email != null
                        && sosmed.length()>0 && sosmed != null)
                {
                    //save
                    temanList.add(new TemanModel(nim,nama,kelas,telpon,email,sosmed));

                    TemanAdapter mAdapter = new TemanAdapter(temanList);
                    recyclerView.setAdapter(mAdapter);
                    d.dismiss();

                }else
                {
                    Snackbar.make(view, "Ada data yang kosong atau salah diinputkan", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

        });

        d.show();

    }

}
