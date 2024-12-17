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

public class SholatAdapter extends RecyclerView.Adapter<SholatAdapter.ViewHolder> {

    private Context context;
    private List<SholatModel> itemsholat;

    public SholatAdapter(Context context, List<SholatModel> sholatModel) {
        this.context = context;
        this.itemsholat = sholatModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sholat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SholatModel item = itemsholat.get(position);
        holder.nama.setText(item.getName());
        holder.arabic.setText(item.getArabic());
        holder.latin.setText(item.getLatin());
        holder.terjemahan.setText(item.getTerjemahan());

        String imageUrl = item.getImage();
        Log.d("SholatAdapter", "Loading image: " + imageUrl); // Logging URL

        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(context).load(imageUrl).into(holder.gambar);
        } else {
            // Gunakan R.drawable.default_image jika placeholder.png tidak ada
            holder.gambar.setImageResource(R.drawable.placeholder);
            Log.e("SholatAdapter", "Image URL is null or empty");
        }
    }

    @Override
    public int getItemCount() {
        return itemsholat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, arabic, latin, terjemahan;
        ImageView gambar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.name);
            terjemahan = itemView.findViewById(R.id.terjemahan);
            arabic = itemView.findViewById(R.id.arabic);
            latin = itemView.findViewById(R.id.latin);
            gambar = itemView.findViewById(R.id.image_item);
        }
    }
}