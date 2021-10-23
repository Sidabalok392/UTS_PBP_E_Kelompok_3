package com.example.easy_learning.preferences;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.easy_learning.model.Class;

public class ClassPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    /* Mendefinisikan Key */
    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_CLASS = "class";

    public static final String KEY_NAMAPELAJARAN = "nama_pelajaran";
    public static final String KEY_GAMBARPELAJARAN = "gambar_pelajaran";



    public ClassPreferences(Context context) {
        this.context = context;
        /* penamaan bebas namun disini digunakan "splashPreferences" */
        sharedPreferences = context.getSharedPreferences("classPreferences",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setClass(String classs, String namaPelajaran, String gambarPelajaran) {
        /* Menyimpan data login ke sharedPreferences dengan key dan value */
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_CLASS,classs);


        editor.putString(KEY_NAMAPELAJARAN,namaPelajaran);
        editor.putString(KEY_GAMBARPELAJARAN,gambarPelajaran);

        /* Jangan lupa commit karena kalo hanya set editornya saja tidak commit akan sia-sia */
        editor.commit();
    }

    public Class getClasss() {
        /* Mengembalikan object User untuk menampilkan data user jika user sudah login */
        String classs;
        String namaPelajaran;
        String gambarPelajaran;

        classs = sharedPreferences.getString(KEY_CLASS,null);


        namaPelajaran = sharedPreferences.getString(KEY_NAMAPELAJARAN,null);
        gambarPelajaran = sharedPreferences.getString(KEY_GAMBARPELAJARAN,null);

        return new Class(classs,namaPelajaran,gambarPelajaran);
    }

    public boolean checkClass() {
        /* Mengembalikan nilai is_login, jika sudah login otomatis nilai true jika tidak akan return false */
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }

    public void Logout() {
        /* Melakukan clear data yang ada pada sharedPreferences, jangan lupa di commit agar data terubah */
        editor.clear();
        editor.commit();
    }
}

