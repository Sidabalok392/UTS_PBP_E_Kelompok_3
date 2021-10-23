package com.example.easy_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easy_learning.database.DatabaseTodo;
import com.example.easy_learning.databinding.ActivityLoginBinding;
import com.example.easy_learning.model.Todo;
import com.example.easy_learning.preferences.UserPreferences;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private UserPreferences userPreferences;
    private EditText username_login;
    private EditText password_login;
    private Button btnlogin_login;
    private Button btnsignup_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding= DataBindingUtil.setContentView(
                this,
                R.layout.activity_login);
        binding.setLogin(this);
        userPreferences=new UserPreferences(LoginActivity.this);
        checkLogin();
        username_login=binding.usernameLogin;
        password_login=binding.passwordLogin;
        btnlogin_login=binding.btnloginLogin;
        btnsignup_login=binding.btnsignupLogin;
        getSupportActionBar().setTitle("Login");

        btnlogin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateForm()){
                    List<Todo> todos=new ArrayList<>();
                    todos= DatabaseTodo.getInstance(LoginActivity.this)
                            .getDatabase().todoDao().getAll();

                    int i=0;
                    while (i < todos.size()){
                        if(todos.get(i).getUsername()
                                .equals(username_login.getText().toString())
                                &&todos.get(i).getPassword()
                                .equals(password_login.getText().toString())){
                            Intent login_activity=new Intent(
                                    LoginActivity.this,MainActivity.class);
                            login_activity.putExtra(
                                    "username",username_login.getText().toString().trim());
                            login_activity.putExtra("user",todos.get(i).getId()-1);
                            startActivity(login_activity);
                            userPreferences.setLogin(
                                    username_login.getText().toString().trim(),
                                    password_login.getText().toString().trim());
                            finish();
                            break;
                        }else{
                            if(i==todos.size()-1){
                                Toast.makeText(
                                        LoginActivity.this,
                                        "username atau password salah",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        i++;
                    }
                }
            }
        });

        btnsignup_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
                finish();
            }
        });
    }

    private boolean validateForm() {
        /* Check username & password is empty or not */
        if(username_login.getText().toString().trim().isEmpty()
                || password_login.getText().toString().trim().isEmpty()) {
            Toast.makeText(LoginActivity.this,
                    "username Atau password Kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void checkLogin() {
        if(userPreferences.checkLogin()) {
            List<Todo> todos=new ArrayList<>();
            todos= DatabaseTodo.getInstance(LoginActivity.this)
                    .getDatabase().todoDao().getAll();

            int i=0;
            while (i < todos.size()){
                if(todos.get(i).getUsername()
                        .equals(userPreferences.getUserLogin().getUsername())
                        &&todos.get(i).getPassword()
                        .equals(userPreferences.getUserLogin().getPassword())){
                    Intent login_activity=new Intent(
                            LoginActivity.this,MainActivity.class);
                    login_activity.putExtra(
                            "username",userPreferences.getUserLogin().getUsername());
                    login_activity.putExtra("user",todos.get(i).getId()-1);
                    startActivity(login_activity);
                    finish();
                    break;
                }
                i++;
            }
        }
    }


}