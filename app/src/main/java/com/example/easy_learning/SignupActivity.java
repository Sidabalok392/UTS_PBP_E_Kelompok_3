package com.example.easy_learning;

import static com.example.easy_learning.MyApplication.CHANNEL_1_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.easy_learning.database.DatabaseTodo;
import com.example.easy_learning.databinding.ActivitySignupBinding;
import com.example.easy_learning.model.Todo;
import com.example.easy_learning.preferences.SplashPreferences;

import java.util.List;


public class SignupActivity extends AppCompatActivity {
    private SplashPreferences preferences;
    private EditText nama_signup;
    private EditText umur_signup;
    private EditText alamat_signup;
    private EditText email_signup;
    private EditText notelp_signup;
    private EditText username_signup;
    private EditText password_signup;
    private Button btncancel_signup;
    private Button btnsignup_signup;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignupBinding binding= DataBindingUtil.setContentView(
                this, R.layout.activity_signup);
        binding.setSignup(this);

        notificationManager = NotificationManagerCompat.from(this);

        nama_signup= binding.namaSignup;
        umur_signup=binding.umurSignup;
        alamat_signup=binding.alamatSignup;
        email_signup=binding.emailSignup;
        notelp_signup=binding.notelpSignup;
        username_signup=binding.usernameSignup;
        password_signup=binding.passwordSignup;
        btncancel_signup=binding.btncancelSignup;
        btnsignup_signup=binding.btnsignupSignup;
        preferences=new SplashPreferences(this);
        getSupportActionBar().setTitle("Sign Up");

        btncancel_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });

        btnsignup_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean[] checkError={false,false,false,false,false,false,false};
                if(nama_signup.getText().toString().isEmpty()){
                    nama_signup.setError("input kosong");
                    checkError[0]=false;
                }else{
                    checkError[0]=true;
                }if(umur_signup.getText().toString().isEmpty()){
                    umur_signup.setError("input kosong");
                    checkError[1]=false;
                }else{
                    checkError[1]=true;
                }if(alamat_signup.getText().toString().isEmpty()){
                    alamat_signup.setError("input kosong");
                    checkError[2]=false;
                }else{
                    checkError[2]=true;
                }if(email_signup.getText().toString().isEmpty()){
                    email_signup.setError("input kosong");
                    checkError[3]=false;
                }else{
                    checkError[3]=true;
                }if(notelp_signup.getText().toString().isEmpty()){
                    notelp_signup.setError("input kosong");
                    checkError[4]=false;
                }else{
                    checkError[4]=true;
                }if(username_signup.getText().toString().isEmpty()){
                    username_signup.setError("input kosong");
                    checkError[5]=false;
                }else{
                    checkError[5]=true;
                }if(password_signup.getText().toString().isEmpty()){
                    password_signup.setError("input kosong");
                    checkError[6]=false;
                }else{
                    checkError[6]=true;
                }

                // TODO: 14/10/2021 Buat Kalo Register dah ada berarti ganti username

                List<Todo> listtodo = DatabaseTodo.getInstance(SignupActivity.this).getDatabase().todoDao().getAll();

                for(int i=0;i<listtodo.size();i++){
                    if(username_signup.getText().toString().equals(listtodo.get(i).getUsername())){
                        username_signup.setError("Akun sudah ada!");
                        checkError[0] = false;
                    }
                }






                for(int a=0;a<checkError.length;a++){
                    if(checkError[a]==false){
                        break;
                    }else{
                        if(a==checkError.length-1){

                            preferences.setLogin("signup_login");
                            addTodo();
                            checkLogin();

                            String title = "Sign UP";
                            String message = "SUKSES";

                            Intent activityIntent = new Intent(SignupActivity.this,LoginActivity.class);
                            PendingIntent contentIntent = PendingIntent.getActivity(SignupActivity.this,
                                    0,activityIntent,0);

                            Notification notification = new NotificationCompat.Builder(SignupActivity.this,CHANNEL_1_ID)
                                    .setSmallIcon(R.drawable.hi)
                                    .setContentTitle(title)
                                    .setContentText(message)
                                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                                    .setColor(Color.BLUE)
                                    .setContentIntent(contentIntent)
                                    .setAutoCancel(true)
                                    .setOnlyAlertOnce(true)
                                    .addAction(R.mipmap.ic_launcher,"Login",contentIntent)
                                    .build();

                            notificationManager.notify(1,notification);
                        }
                    }
                }

            }
        });
    }

    // TODO: 09/10/2021 Jika Udah Sign up signup_login=1;

    private void checkLogin() {
        if(preferences.checkLogin()) {
            startActivity(new Intent(SignupActivity.this,LoginActivity.class));
            finish();
        }else{
            startActivity(new Intent(SignupActivity.this,SplashActivity.class));
        }
    }

    private void addTodo()
    {
        class AddTodo extends AsyncTask<Void, Void, Void>
        {
            @Override
            protected Void doInBackground(Void... voids) {
                Todo todo=new Todo();
                todo.setNama(nama_signup.getText().toString());
                todo.setUmur(umur_signup.getText().toString());
                todo.setAlamat(alamat_signup.getText().toString());
                todo.setEmail(email_signup.getText().toString());
                todo.setNotelp(notelp_signup.getText().toString());
                todo.setUsername(username_signup.getText().toString());
                todo.setPassword(password_signup.getText().toString());

                DatabaseTodo.getInstance(SignupActivity.this).getDatabase().todoDao().insertTodo(todo);

                return null;
            }
        }

        AddTodo addTodo=new AddTodo();
        addTodo.execute();
    }

    public void sendOnChannel1(View v) {
    }


}