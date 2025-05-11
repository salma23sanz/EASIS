package com.example.bar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecetasAdapter extends RecyclerView.Adapter<RecetasAdapter.RecetaViewHolder> {
    private List<String> recetas;

    public RecetasAdapter(List<String> recetas) {
        this.recetas = recetas;
    }

    @NonNull
    @Override
    public RecetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent, false);
        return new RecetaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecetaViewHolder holder, int position) {
        holder.nombreReceta.setText(recetas.get(position));
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }

    static class RecetaViewHolder extends RecyclerView.ViewHolder {
        TextView nombreReceta;
        ImageView btnFavorito, btnPin;

        public RecetaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreReceta = itemView.findViewById(R.id.nombreReceta);
            btnFavorito = itemView.findViewById(R.id.btnFavorito);
            btnPin = itemView.findViewById(R.id.btnPin);
        }
    }
}
