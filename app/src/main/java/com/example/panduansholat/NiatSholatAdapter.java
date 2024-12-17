package com.example.panduansholat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NiatSholatAdapter extends RecyclerView.Adapter<NiatSholatAdapter.ViewHolder> {

    private Context context;
    private List<NiatSholatModel> sholatList;

    public NiatSholatAdapter(Context context, List<NiatSholatModel> sholatList) {
        this.context = context;
        this.sholatList = sholatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_niat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NiatSholatModel item = sholatList.get(position);
        holder.nama.setText(item.getName());
        holder.arabic.setText(item.getArabic());
        holder.latin.setText(item.getLatin());
        holder.terjemahan.setText(item.getTerjemahan());
    }

    @Override
    public int getItemCount() {
        return sholatList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, arabic, latin, terjemahan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.name);
            arabic = itemView.findViewById(R.id.arabic);
            latin = itemView.findViewById(R.id.latin);
            terjemahan = itemView.findViewById(R.id.terjemahan);
        }
    }
}
