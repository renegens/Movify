package com.renegens.movify.adapters;

import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.renegens.movify.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private static final String TAG = "CardAdapter";
    private ArrayList<String> arrayList;
    private TypedArray typedArray;

    public ListAdapter(ArrayList<String> arrayList, TypedArray typedArray) {
        super();
        this.arrayList = arrayList;
        this.typedArray = typedArray;
    }

    @Override public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_row, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override public void onBindViewHolder(ListItemViewHolder holder, int position) {

        holder.itemName.setText(arrayList.get(position));
        holder.imageView.setImageDrawable(typedArray.getDrawable(position));
    }

    @Override public int getItemCount() {

        return arrayList.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName;
        public ImageView imageView;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.textView_fragmentlist_task_name);
            imageView = (ImageView) itemView.findViewById(R.id.imageView_fragmenlist_recyclerItem);
        }
    }
}


