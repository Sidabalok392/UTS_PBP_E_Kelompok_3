package com.example.easy_learning;

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

import com.example.easy_learning.database.DatabaseClassTodo;
import com.example.easy_learning.database.DatabaseTodo;
import com.example.easy_learning.databinding.ActivitySuccessBinding;
import com.example.easy_learning.model.ClassTodo;
import com.example.easy_learning.model.Todo;
import com.example.easy_learning.preferences.ClassPreferences;
import com.example.easy_learning.preferences.UserPreferences;

import java.util.ArrayList;
import java.util.List;

public class SuccessActivity extends AppCompatActivity {
    private ActivitySuccessBinding binding;
    private UserPreferences userPreferences;
    private ClassPreferences classPreferences;
    private int iduser;

    @Override
    public void onBackPressed() {
        List<Todo> todos = new ArrayList<>();
        todos = DatabaseTodo.getInstance(SuccessActivity.this)
                .getDatabase().todoDao().getAll();

        int i = 0;
        while (i < todos.size()) {
            if (todos.get(i).getUsername()
                    .equals(userPreferences.getUserLogin().getUsername())
                    && todos.get(i).getPassword()
                    .equals(userPreferences.getUserLogin().getPassword())) {


                classPreferences.setClass("true",getIntent().getStringExtra("nama_pelajaran"),getIntent().getStringExtra("gambar_pelajaran"));




                Intent login_activity = new Intent(
                        SuccessActivity.this, MainActivity.class);
                login_activity.putExtra(
                        "username", userPreferences.getUserLogin().getUsername());
                login_activity.putExtra("user", todos.get(i).getId() - 1);
                startActivity(login_activity);
                finish();
                break;
            }
            i++;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_success);
        binding.setSuccess(this);
        userPreferences=new UserPreferences(SuccessActivity.this);
        classPreferences=new ClassPreferences(SuccessActivity.this);
        getSupportActionBar().setTitle("Thank You");

        String title = "Pembelian";
        String message = "Terimakasih Telah Membeli Kami";

        Intent activityIntent = new Intent(SuccessActivity.this,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(SuccessActivity.this,
                0,activityIntent,0);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        Notification notification = new NotificationCompat.Builder(SuccessActivity.this, MyApplication.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.hi)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher,"Oke",contentIntent)
                .build();

        notificationManager.notify(1,notification);

        Button btndone_success = binding.btndoneSuccess;
        btndone_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Todo> todos = new ArrayList<>();
                todos = DatabaseTodo.getInstance(SuccessActivity.this)
                        .getDatabase().todoDao().getAll();

                int i = 0;
                while (i < todos.size()) {
                    if (todos.get(i).getUsername()
                            .equals(userPreferences.getUserLogin().getUsername())
                            && todos.get(i).getPassword()
                            .equals(userPreferences.getUserLogin().getPassword())) {




                        classPreferences.setClass("true",getIntent().getStringExtra("nama_pelajaran"),getIntent().getStringExtra("gambar_pelajaran"));




                        iduser=todos.get(i).getId();

                        addClassTodo();













                        Intent login_activity = new Intent(

                                SuccessActivity.this, MainActivity.class);
                        login_activity.putExtra(
                                "username", userPreferences.getUserLogin().getUsername());
                        login_activity.putExtra("user", todos.get(i).getId() - 1);
                        startActivity(login_activity);
                        finish();
                        break;
                    }
                    i++;
                }
            }
        });


    }

    private void addClassTodo()
    {
        class AddClassTodo extends AsyncTask<Void, Void, Void>
        {
            @Override
            protected Void doInBackground(Void... voids) {
                ClassTodo classTodo=new ClassTodo();
                classTodo.setIduser(iduser);
                classTodo.setNamapelajaran(getIntent().getStringExtra("nama_pelajaran"));
                classTodo.setGambarpelajaran(getIntent().getStringExtra("gambar_pelajaran"));
                classTodo.setDeskripsipelajaran("");

                DatabaseClassTodo.getInstance(SuccessActivity.this).getDatabase().classTodoDao().insertClassTodo(classTodo);

                return null;
            }
        }

        AddClassTodo addClassTodo=new AddClassTodo();
        addClassTodo.execute();
    }
}
