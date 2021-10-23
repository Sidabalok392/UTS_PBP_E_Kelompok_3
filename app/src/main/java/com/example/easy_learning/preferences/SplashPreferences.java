package com.example.easy_learning.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.easy_learning.model.Splash;

public class SplashPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    /* Mendefinisikan Key */
    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_SIGNUPLOGIN = "signup_login";

    public SplashPreferences(Context context) {
        this.context = context;
        /* penamaan bebas namun disini digunakan "splashPreferences" */
        sharedPreferences = context.getSharedPreferences("splashPreferences",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLogin(String signup_login) {
        /* Menyimpan data login ke sharedPreferences dengan key dan value */
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_SIGNUPLOGIN,signup_login);

        /* Jangan lupa commit karena kalo hanya set editornya saja tidak commit akan sia-sia */
        editor.commit();
    }

    public Splash getSplashLogin() {
        /* Mengembalikan object User untuk menampilkan data user jika user sudah login */
        String signup_login;

        signup_login = sharedPreferences.getString(KEY_SIGNUPLOGIN,null);

        return new Splash(signup_login);
    }

    public boolean checkLogin() {
        /* Mengembalikan nilai is_login, jika sudah login otomatis nilai true jika tidak akan return false */
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }

    public void Logout() {
        /* Melakukan clear data yang ada pada sharedPreferences, jangan lupa di commit agar data terubah */
        editor.clear();
        editor.commit();
    }
}
