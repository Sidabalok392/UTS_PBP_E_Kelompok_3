package com.example.easy_learning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.easy_learning.databinding.ActivityMainBinding;
import com.example.easy_learning.fragment.HomeFragment;
import com.example.easy_learning.fragment.UserFragment;
import com.example.easy_learning.model.User;
import com.example.easy_learning.preferences.ClassPreferences;
import com.example.easy_learning.preferences.UserPreferences;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    private UserPreferences userPreferences;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMain(this);
        userPreferences=new UserPreferences(MainActivity.this);
        user=userPreferences.getUserLogin();
        checkLogin();
        HomeFragment home=new HomeFragment();
        UserFragment user=new UserFragment();
        binding.navBottom.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        if(item.getItemId()==R.id.home) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.cardview,home).commit();
                            getSupportActionBar().setTitle("Home");
                        }else if(item.getItemId()==R.id.user) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.cardview,user).commit();
                            getSupportActionBar().setTitle("User");
                        }return true;
                    }
                });binding.navBottom.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout){
            userPreferences.Logout();
            ClassPreferences classPreferences = new ClassPreferences(MainActivity.this);
            classPreferences.Logout();
//            Toast.makeText(MainActivity.this, "Baiii baiii", Toast.LENGTH_SHORT).show();
            checkLogin();
        }return super.onOptionsItemSelected(item);

    }
    private void checkLogin() {
        /* this function will check if user login, akan memunculkan toast jika tidak redirect ke login activity */
        if(!userPreferences.checkLogin()) {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        } else {
//            Toast.makeText(MainActivity.this, "Heyy Kamu Sudah Login !!", Toast.LENGTH_SHORT).show();
        }
    }
}