package com.si6a.i_laundry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.si6a.i_laundry.databinding.ItemUnggahBinding;

import java.util.ArrayList;
import java.util.List;

public class UnggahViewAdapter extends RecyclerView.Adapter<UnggahViewAdapter.ViewHolder> {
    private List<com.si6a.i_laundry.Unggah> data = new ArrayList<>();
    private OnItemLongClickListener onItemLongClickListener;

    public void setData(List<com.si6a.i_laundry.Unggah> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public UnggahViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemUnggahBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UnggahViewAdapter.ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        com.si6a.i_laundry.Unggah unggah = data.get(pos);
        holder.itemUnggahBinding.tvName.setText(unggah.getUsername());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener.onItemLongClick(v, unggah, pos);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemUnggahBinding itemUnggahBinding;

        public ViewHolder(@NonNull ItemUnggahBinding itemView) {
            super(itemView.getRoot());
            itemUnggahBinding = itemView;
        }
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View v, com.si6a.i_laundry.Unggah unggah, int position);
    }
}
