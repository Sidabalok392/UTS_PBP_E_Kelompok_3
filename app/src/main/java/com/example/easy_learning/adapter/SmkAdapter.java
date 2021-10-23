package com.example.easy_learning.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easy_learning.OrderActivity;
import com.example.easy_learning.R;
import com.example.easy_learning.databinding.SmkItemBinding;
import com.example.easy_learning.model.SMK;

import java.util.ArrayList;

public class SmkAdapter extends RecyclerView.Adapter<SmkAdapter.viewHolder> {
    private Context context;
    private ArrayList<SMK> listsmk;
    private String username;

    public SmkAdapter(Context context, ArrayList<SMK> listsmk,String username) {
        this.context = context;
        this.listsmk = listsmk;
        this.username = username;
    }

    @NonNull
    @Override
    public SmkAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SmkItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.smk_item,parent,false);
        return new SmkAdapter.viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SmkAdapter.viewHolder holder, int position) {
        holder.fotopelajaran_smk.setImageResource(listsmk.get(position).getIdFoto_SMK());
        holder.tvnama_pelajaran_smk.setText(listsmk.get(position).getNama_pelajaran_SMK());
        holder.btnpelajaran_smk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent order_activity = new Intent(context, OrderActivity.class);

                order_activity.putExtra("nama_order",username);
                order_activity.putExtra("nama_pelajaran",holder.tvnama_pelajaran_smk.getText().toString());
                order_activity.putExtra("deskripsi_pelajaran",listsmk.get(holder.getPosition()).getDeskripsi_SMK());
                order_activity.putExtra("tingkat_order","Vokational Skul");
                order_activity.putExtra("harga_order","250000");

                order_activity.putExtra("gambar_order",String.valueOf(listsmk.get(holder.getAdapterPosition()).getIdFoto_SMK()));


                context.startActivity(order_activity);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listsmk.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView fotopelajaran_smk;
        TextView tvnama_pelajaran_smk;
        Button btnpelajaran_smk;
        public viewHolder(@NonNull SmkItemBinding itemView) {
            super(itemView.getRoot());

            fotopelajaran_smk=itemView.fotopelajaranSmk;
            tvnama_pelajaran_smk=itemView.tvnamaPelajaranSmk;
            btnpelajaran_smk=itemView.btnpelajaranSmk;

        }
    }
}
