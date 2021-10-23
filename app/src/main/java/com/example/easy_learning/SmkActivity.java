package com.example.easy_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easy_learning.adapter.SmkAdapter;
import com.example.easy_learning.databinding.ActivitySmkBinding;
import com.example.easy_learning.model.PelajaranSMK;
import com.example.easy_learning.model.SMK;

import java.util.ArrayList;

public class SmkActivity extends AppCompatActivity {
    private ActivitySmkBinding binding;
    private RecyclerView view_smk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_smk);
        binding.setSmk(this);

        view_smk=binding.viewSmk;

        ArrayList<SMK> listsmk = new PelajaranSMK().listsmk;
        String username = getIntent().getStringExtra("username_smk");

        SmkAdapter adapter = new SmkAdapter(this,listsmk,username);

        view_smk.setAdapter(adapter);
        view_smk.setLayoutManager(new LinearLayoutManager(this));

        getSupportActionBar().setTitle("SMK");

    }
}