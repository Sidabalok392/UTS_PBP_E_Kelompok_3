package com.example.easy_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easy_learning.adapter.SmaAdapter;
import com.example.easy_learning.databinding.ActivitySmaBinding;
import com.example.easy_learning.model.PelajaranSMA;
import com.example.easy_learning.model.SMA;

import java.util.ArrayList;

public class SmaActivity extends AppCompatActivity {

    private ActivitySmaBinding binding;
    private RecyclerView view_sma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sma);
        binding.setSma(this);

        view_sma = binding.viewSma;

        ArrayList<SMA> listSma = new PelajaranSMA().listsma;
        String username = getIntent().getStringExtra("username_sma");

        SmaAdapter adapter = new SmaAdapter(this, listSma, username);

        view_sma.setAdapter(adapter);
        view_sma.setLayoutManager(new LinearLayoutManager(this));

        getSupportActionBar().setTitle("SMA");

    }
}