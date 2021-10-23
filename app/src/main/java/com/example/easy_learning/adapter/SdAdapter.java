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
import com.example.easy_learning.databinding.SdItemBinding;
import com.example.easy_learning.model.SD;

import java.util.ArrayList;

public class SdAdapter extends RecyclerView.Adapter<SdAdapter.viewHolder>
{
    private Context context;
    private ArrayList<SD> listsd;
    private String username;

    public SdAdapter(Context context, ArrayList<SD> listsd,String username) {
        this.context = context;
        this.listsd = listsd;
        this.username = username;
    }

    @NonNull
    @Override
    public SdAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SdItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.sd_item,parent,false);
        return new SdAdapter.viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SdAdapter.viewHolder holder, int position) {
        holder.fotopelajaran_sd.setImageResource(listsd.get(position).getIdFoto_SD());
        holder.tvnama_pelajaran_sd.setText(listsd.get(position).getNama_pelajaran_SD());
        holder.btnpelajaran_sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent order_activity = new Intent(context, OrderActivity.class);

                order_activity.putExtra("nama_order",username);
                order_activity.putExtra("nama_pelajaran",holder.tvnama_pelajaran_sd.getText().toString());
                order_activity.putExtra("deskripsi_pelajaran",listsd.get(holder.getPosition()).getDeskripsi_SD());
                order_activity.putExtra("tingkat_order","Elementary School");
                order_activity.putExtra("harga_order","250000");




                order_activity.putExtra("gambar_order",String.valueOf(listsd.get(holder.getAdapterPosition()).getIdFoto_SD()));





                context.startActivity(order_activity);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listsd.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView fotopelajaran_sd;
        TextView tvnama_pelajaran_sd;
        Button btnpelajaran_sd;
        public viewHolder(@NonNull SdItemBinding itemView) {
            super(itemView.getRoot());

            fotopelajaran_sd=itemView.fotopelajaranSd;
            tvnama_pelajaran_sd=itemView.tvnamaPelajaranSd;
            btnpelajaran_sd=itemView.btnpelajaranSd;

        }
    }
}
