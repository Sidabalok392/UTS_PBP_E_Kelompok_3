package com.example.easy_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.easy_learning.databinding.ActivityOrderBinding;
import com.example.easy_learning.preferences.ClassPreferences;


public class OrderActivity extends AppCompatActivity {
    private EditText etnama_order;
    private TextView tvdeskripsi_order;
    private Button btndone_order;
    private ClassPreferences classPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOrderBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_order);
        binding.setOrder(this);
        classPreferences=new ClassPreferences(OrderActivity.this);

        etnama_order=binding.etnamaOrder;
        tvdeskripsi_order=binding.tvdeskripsiOrder;
        btndone_order=binding.btndoneOrder;

        etnama_order.setText(getIntent().getStringExtra("nama_pelajaran"));
        tvdeskripsi_order.setText(getIntent().getStringExtra("deskripsi_pelajaran"));

        getSupportActionBar().setTitle("Order");

        btndone_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent payment_activity = new Intent(OrderActivity.this,PaymentActivity.class);
                payment_activity.putExtra("nama_payment",getIntent().getStringExtra("nama_order"));
                payment_activity.putExtra("modul_payment", getIntent().getStringExtra("nama_pelajaran"));
                payment_activity.putExtra("tingkat_payment", getIntent().getStringExtra("tingkat_order"));
                payment_activity.putExtra("harga_payment", getIntent().getStringExtra("harga_order"));



                payment_activity.putExtra("gambar_payment",getIntent().getStringExtra("gambar_order"));






                startActivity(payment_activity);
                finish();

            }
        });



    }
}