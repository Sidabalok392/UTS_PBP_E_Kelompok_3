package com.example.easy_learning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easy_learning.R;
import com.example.easy_learning.database.DatabaseTodo;
import com.example.easy_learning.databinding.ClassItemBinding;
import com.example.easy_learning.model.ClassTodo;
import com.example.easy_learning.model.Todo;
import com.example.easy_learning.preferences.UserPreferences;

import java.util.ArrayList;
import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder>
{
    private List<ClassTodo> classTodoList;
    private Context context;

    public ClassAdapter(List<ClassTodo> classTodoList, Context context) {
        this.classTodoList = classTodoList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //init binding
        ClassItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.class_item,parent,false);
        return new ClassAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClassTodo classTodo = classTodoList.get(position);

        holder.foto_class.setImageResource(Integer.parseInt(classTodo.getGambarpelajaran()));
        holder.tvnama_class.setText(classTodo.getNamapelajaran());
        holder.etmodul_class.setText("Modul");
        holder.etvideo_class.setText("Video");
        holder.ettanya_class.setText("Tanya");
    }

    @Override
    public int getItemCount() {
        UserPreferences userPreferences=new UserPreferences(context);
        List<Todo> todos = new ArrayList<>();
        todos = DatabaseTodo.getInstance(context)
                .getDatabase().todoDao().getAll();

        int i = 0;
        int iduser = 0;
        while (i < todos.size()) {
            if (todos.get(i).getUsername().equals(userPreferences.getUserLogin().getUsername())) {
                iduser=todos.get(i).getId();
                break;
            }
            i++;
        }

        int rtrn = 0;
        for(i=0;i<classTodoList.size();i++){
            if(iduser==classTodoList.get(i).getIduser()){
                rtrn++;
            }
        }

        return rtrn;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView foto_class;
        private TextView tvnama_class;
        private EditText etmodul_class;
        private EditText etvideo_class;
        private EditText ettanya_class;
        public ViewHolder(@NonNull ClassItemBinding itemView) {
            super(itemView.getRoot());

            foto_class=itemView.fotoClass;
            tvnama_class=itemView.tvnamaClass;
            etmodul_class=itemView.etmodulClass;
            etvideo_class=itemView.etvideoClass;
            ettanya_class=itemView.ettanyaClass;


        }
    }
}
