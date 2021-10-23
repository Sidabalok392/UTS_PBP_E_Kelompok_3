package com.example.easy_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.easy_learning.adapter.ClassAdapter;
import com.example.easy_learning.database.DatabaseClassTodo;
import com.example.easy_learning.databinding.ActivityClassBinding;
import com.example.easy_learning.model.ClassTodo;
import com.example.easy_learning.preferences.ClassPreferences;

import java.util.List;


public class ClassActivity extends AppCompatActivity {
    private ActivityClassBinding binding;
    private RecyclerView classview;
    //    private TextView tvnama_class;
//    private EditText etmodul_class;
//    private EditText etvideo_class;
//    private EditText ettanya_class;
    private ClassPreferences classPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_class);
        binding.setClasss(this);
        classview=binding.classView;

        classPreferences = new ClassPreferences(ClassActivity.this);



        getCLassTodo();

        classview.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void getCLassTodo()
    {
        class GetClassTodo extends AsyncTask<Void, Void, List<ClassTodo>>
        {
            @Override
            protected List<ClassTodo> doInBackground(Void... voids)
            {
                return DatabaseClassTodo.getInstance(ClassActivity.this).getDatabase().classTodoDao().getAllClass();
            }

            @Override
            protected void onPostExecute(List<ClassTodo> classTodos)
            {
                super.onPostExecute(classTodos);

                ClassAdapter classAdapter=new ClassAdapter(classTodos,ClassActivity.this);
                classview.setAdapter(classAdapter);
            }
        }

        GetClassTodo getCLassTodo=new GetClassTodo();
        getCLassTodo.execute();
    }
}