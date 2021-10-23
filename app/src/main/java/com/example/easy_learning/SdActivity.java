package com.example.easy_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easy_learning.adapter.SdAdapter;
import com.example.easy_learning.databinding.ActivitySdBinding;
import com.example.easy_learning.model.PelajaranSD;
import com.example.easy_learning.model.SD;

import java.util.ArrayList;

public class SdActivity extends AppCompatActivity {
    private ActivitySdBinding binding;
    private RecyclerView view_sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_sd);
        binding.setSd(this);

        view_sd=binding.viewSd;

        ArrayList<SD> listsd = new PelajaranSD().listsd;
        String username = getIntent().getStringExtra("username_sd");

        SdAdapter adapter = new SdAdapter(this,listsd,username);

        view_sd.setAdapter(adapter);
        view_sd.setLayoutManager(new LinearLayoutManager(this));

        getSupportActionBar().setTitle("SD");

    }
}