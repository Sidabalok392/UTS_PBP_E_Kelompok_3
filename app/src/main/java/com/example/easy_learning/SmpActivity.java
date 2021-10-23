package com.example.easy_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easy_learning.adapter.SmpAdapter;
import com.example.easy_learning.databinding.ActivitySmpBinding;
import com.example.easy_learning.model.PelajaranSMP;
import com.example.easy_learning.model.SMP;

import java.util.ArrayList;


public class SmpActivity extends AppCompatActivity {
    private ActivitySmpBinding binding;
    private RecyclerView view_smp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_smp);
        binding.setSmp(this);

        view_smp=binding.viewSmp;

        ArrayList<SMP> listsmp = new PelajaranSMP().listsmp;
        String username = getIntent().getStringExtra("username_smp");

        SmpAdapter adapter = new SmpAdapter(this,listsmp,username);

        view_smp.setAdapter(adapter);
        view_smp.setLayoutManager(new LinearLayoutManager(this));

        getSupportActionBar().setTitle("SMP");

    }
}