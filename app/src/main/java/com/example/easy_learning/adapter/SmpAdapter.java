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
import com.example.easy_learning.databinding.SmpItemBinding;
import com.example.easy_learning.model.SMP;

import java.util.ArrayList;

public class SmpAdapter extends RecyclerView.Adapter<SmpAdapter.viewHolder> {
    private Context context;
    private ArrayList<SMP> listsmp;
    private String username;

    public SmpAdapter(Context context, ArrayList<SMP> listsmp,String username) {
        this.context = context;
        this.listsmp = listsmp;
        this.username = username;
    }

    @NonNull
    @Override
    public SmpAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SmpItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.smp_item,parent,false);
        return new SmpAdapter.viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SmpAdapter.viewHolder holder, int position) {
        holder.fotopelajaran_smp.setImageResource(listsmp.get(position).getIdFoto_SMP());
        holder.tvnama_pelajaran_smp.setText(listsmp.get(position).getNama_pelajaran_SMP());
        holder.btnpelajaran_smp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent order_activity = new Intent(context, OrderActivity.class);

                order_activity.putExtra("nama_order",username);
                order_activity.putExtra("nama_pelajaran",holder.tvnama_pelajaran_smp.getText().toString());
                order_activity.putExtra("deskripsi_pelajaran",listsmp.get(holder.getPosition()).getDeskripsi_SMP());
                order_activity.putExtra("tingkat_order","Junior High School");
                order_activity.putExtra("harga_order","255000");
                order_activity.putExtra("gambar_order",String.valueOf(listsmp.get(holder.getAdapterPosition()).getIdFoto_SMP()));

                context.startActivity(order_activity);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listsmp.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView fotopelajaran_smp;
        TextView tvnama_pelajaran_smp;
        Button btnpelajaran_smp;
        public viewHolder(@NonNull SmpItemBinding itemView) {
            super(itemView.getRoot());

            fotopelajaran_smp=itemView.fotopelajaranSmp;
            tvnama_pelajaran_smp=itemView.tvnamaPelajaranSmp;
            btnpelajaran_smp=itemView.btnpelajaranSmp;

        }
    }
}
