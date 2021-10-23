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
import com.example.easy_learning.databinding.SmaItemBinding;
import com.example.easy_learning.model.SMA;

import java.util.ArrayList;

public class SmaAdapter extends RecyclerView.Adapter<SmaAdapter.viewHolder> {
    private Context context;
    private ArrayList<SMA> listsma;
    private String username;

    public SmaAdapter(Context context, ArrayList<SMA> listsma,String username) {
        this.context = context;
        this.listsma = listsma;
        this.username = username;
    }

    @NonNull
    @Override
    public SmaAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SmaItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.sma_item,parent,false);
        return new SmaAdapter.viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SmaAdapter.viewHolder holder, int position) {
        holder.fotopelajaran_sma.setImageResource(listsma.get(position).getIdFoto_SMA());
        holder.tvnama_pelajaran_sma.setText(listsma.get(position).getNama_pelajaran_SMA());
        holder.btnpelajaran_sma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent order_activity = new Intent(context, OrderActivity.class);

                order_activity.putExtra("nama_order",username);
                order_activity.putExtra("nama_pelajaran",holder.tvnama_pelajaran_sma.getText().toString());
                order_activity.putExtra("deskripsi_pelajaran",listsma.get(holder.getPosition()).getDeskripsi_SMA());
                order_activity.putExtra("tingkat_order","Senior High School");
                order_activity.putExtra("harga_order","250000");

                order_activity.putExtra("gambar_order",String.valueOf(listsma.get(holder.getAdapterPosition()).getIdFoto_SMA()));

                context.startActivity(order_activity);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listsma.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView fotopelajaran_sma;
        TextView tvnama_pelajaran_sma;
        Button btnpelajaran_sma;
        public viewHolder(@NonNull SmaItemBinding itemView) {
            super(itemView.getRoot());

            fotopelajaran_sma=itemView.fotopelajaranSma;
            tvnama_pelajaran_sma=itemView.tvnamaPelajaranSma;
            btnpelajaran_sma=itemView.btnpelajaranSma;

        }
    }
}
