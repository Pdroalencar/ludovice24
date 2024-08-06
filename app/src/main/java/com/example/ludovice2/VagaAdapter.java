package com.example.ludovice2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ludovice2.R;
import com.example.ludovice2.model.Vaga;

import java.util.Objects;

public class VagaAdapter extends ListAdapter<Vaga, VagaAdapter.VagaViewHolder> {

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Vaga vaga);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public VagaAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Vaga> DIFF_CALLBACK = new DiffUtil.ItemCallback<Vaga>() {
        @Override
        public boolean areItemsTheSame(@NonNull Vaga oldItem, @NonNull Vaga newItem) {
            return Objects.equals(oldItem.getId(), newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Vaga oldItem, @NonNull Vaga newItem) {
            return oldItem.getTitulo().equals(newItem.getTitulo()) &&
                    oldItem.getEmpresa().equals(newItem.getEmpresa());
        }
    };

    @NonNull
    @Override
    public VagaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vaga, parent, false);
        return new VagaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VagaViewHolder holder, int position) {
        Vaga vaga = getItem(position);
        holder.bind(vaga);
    }

    class VagaViewHolder extends RecyclerView.ViewHolder {
        private final TextView tituloTextView;
        private final TextView empresaTextView;

        VagaViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.tituloTextView);
            empresaTextView = itemView.findViewById(R.id.empresaTextView);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getItem(position));
                }
            });
        }

        void bind(Vaga vaga) {
            tituloTextView.setText(vaga.getTitulo());
            empresaTextView.setText(vaga.getEmpresa());
        }
    }
}