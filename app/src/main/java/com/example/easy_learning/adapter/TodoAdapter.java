package com.example.easy_learning.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easy_learning.ClassActivity;
import com.example.easy_learning.LocationActivity;
import com.example.easy_learning.R;
import com.example.easy_learning.databinding.TodoItemBinding;
import com.example.easy_learning.model.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<Todo> todoList;
    private Context context;
    private int user;

    public TodoAdapter(List<Todo> todoList, Context context, int user) {
        this.todoList=todoList;
        this.context=context;
        this.user=user;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //init binding
        TodoItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.todo_item,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todo=todoList.get(user);
        holder.nama_todo.setText(todo.getNama());
        holder.umur_todo.setText(todo.getUmur());
        holder.alamat_todo.setText(todo.getAlamat());
        holder.email_todo.setText(todo.getEmail());
        holder.notelp_todo.setText(todo.getNotelp());
        holder.username_todo.setText(todo.getUsername());

        holder.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, LocationActivity.class));

            }
        });

        holder.classs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ClassActivity.class));
            }
        });


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nama_todo;
        private TextView umur_todo;
        private TextView alamat_todo;
        private TextView email_todo;
        private TextView notelp_todo;
        private TextView username_todo;

        private ImageView location;
        private ImageView classs;


        public ViewHolder(@NonNull TodoItemBinding binding) {
            super(binding.getRoot());

            nama_todo= binding.namaTodo;
            umur_todo= binding.umurTodo;
            alamat_todo= binding.alamatTodo;
            email_todo=binding.emailTodo;
            notelp_todo= binding.notelpTodo;
            username_todo=binding.usernameTodo;

            location=binding.location;
            classs=binding.classs;

        }
    }
}