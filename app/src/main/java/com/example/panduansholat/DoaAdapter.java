package com.example.panduansholat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DoaAdapter extends RecyclerView.Adapter<DoaAdapter.ViewHolder> {

    private Context context;
    private List<DoaModel> itemdoa;

    public DoaAdapter(Context context, List<DoaModel> doaModel) {
        this.context = context;
        this.itemdoa = doaModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_doa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoaModel item = itemdoa.get(position);
        holder.nama.setText(item.getName());
        holder.arabic.setText(item.getArabic());
        holder.latin.setText(item.getLatin());
        holder.terjemahan.setText(item.getTerjemahan());

    }

    @Override
    public int getItemCount() {
        return itemdoa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, arabic, latin, terjemahan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.name);
            terjemahan = itemView.findViewById(R.id.terjemahan);
            arabic = itemView.findViewById(R.id.arabic);
            latin = itemView.findViewById(R.id.latin);
        }
    }
}
