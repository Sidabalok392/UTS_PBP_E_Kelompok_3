package com.example.easy_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easy_learning.databinding.ActivityPaymentBinding;


public class PaymentActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener
{
    private ActivityPaymentBinding binding;
    private EditText etnama_payment;
    private EditText etmodul_payment;
    private EditText ettingkat_payment;
    private EditText etharga_payment;
    private EditText etuang_payment;
    private Button btnpay_payment;
    private Boolean isTrue = false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_payment);
        binding.setPayment(this);

        etnama_payment=binding.etnamaPayment;
        etmodul_payment=binding.etmodulPayment;
        ettingkat_payment=binding.ettingkatPayment;
        etharga_payment=binding.ethargaPayment;
        etuang_payment= binding.etuangPayment;
        btnpay_payment=binding.btnpayPayment;

        etnama_payment.setText(getIntent().getStringExtra("nama_payment"));
        etmodul_payment.setText(getIntent().getStringExtra("modul_payment"));
        ettingkat_payment.setText(getIntent().getStringExtra("tingkat_payment"));
        etharga_payment.setText(getIntent().getStringExtra("harga_payment"));

        etuang_payment.addTextChangedListener(this);
        btnpay_payment.setOnClickListener(this);

        getSupportActionBar().setTitle("Payment");
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void afterTextChanged(Editable editable) {
        if(Float.parseFloat(etuang_payment.getText().toString()) < Float.parseFloat(etharga_payment.getText().toString())) {
            etuang_payment.setError("Uang Kurang !");
            isTrue=false;
        }else{
            isTrue=true;
        }
    }

    @Override
    public void onClick(View view) {
        if(isTrue == true){
            Intent success = new Intent(PaymentActivity.this,SuccessActivity.class);
            success.putExtra("nama_pelajaran",etmodul_payment.getText().toString().trim());


            success.putExtra("gambar_pelajaran",getIntent().getStringExtra("gambar_payment"));



            startActivity(success);
            finish();
        }else{
            Toast.makeText(PaymentActivity.this, "Uang Masih Kurang !", Toast.LENGTH_SHORT).show();
        }
    }
}