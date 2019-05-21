package com.akb.ferry.akbuts10116154;

/**
 * NIM : 10116154
 * Nama : Ferry Hermawan
 * Kelas : IF4
 * Tgl Pengerjaan : 19 Mei 2019
 */

import com.akb.ferry.akbuts10116154.model.TemanModel;

import java.util.ArrayList;

public class CRUD {

    private ArrayList<TemanModel> temanList = new ArrayList<>();

    public void save(String nim, String nama, String kelas, String telpon, String email,String instagram)
    {
        temanList.add(new TemanModel(nim, nama, kelas, telpon, email, instagram));
    }

    public ArrayList<TemanModel> getTemanList()
    {
        return temanList;
    }

    public String getNim() {
        return getNim();
    }

    public Boolean update(int position,String newNim, String newNama, String newKelas, String newTelpon, String newEmail, String newInstagram)
    {
        try {
            temanList.remove(position);
            temanList.add(position, new TemanModel(newNim, newNama, newKelas, newTelpon, newEmail, newInstagram));

            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(int position)
    {
        try {
            temanList.remove(position);

            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
    }
}
