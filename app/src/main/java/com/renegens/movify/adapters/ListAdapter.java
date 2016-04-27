package com.renegens.movify.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.renegens.movify.R;

import org.themoviedb.models.toprated.Result;

import io.realm.RealmResults;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private static final String TAG = "CardAdapter";
    private RealmResults<Result> list;

    public ListAdapter(RealmResults<Result> list) {
        this.list = list;
    }

    @Override public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_row, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override public void onBindViewHolder(ListItemViewHolder holder, int position) {

        holder.itemName.setText(list.get(position).originalTitle);

    }

    @Override public int getItemCount() {

        return list.size();
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


