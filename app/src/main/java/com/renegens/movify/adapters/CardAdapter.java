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

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardItemViewHolder> {

    private static final String TAG = "CardAdapter";
    private ArrayList<String> arrayList;
    private TypedArray typedArray;

    public CardAdapter(ArrayList<String> arrayList, TypedArray typedArray) {
        this.arrayList = arrayList;
        this.typedArray = typedArray;
    }

    @Override public CardItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.card_plant, parent, false);
        return new CardItemViewHolder(itemView);
    }

    @Override public void onBindViewHolder(CardItemViewHolder holder, int position) {

        holder.plantName.setText(arrayList.get(position));
        holder.plantImage.setImageDrawable(typedArray.getDrawable(position));
    }

    @Override public int getItemCount() {

        return arrayList.size();
    }

    public static class CardItemViewHolder extends RecyclerView.ViewHolder {

        public TextView plantName;
        public ImageView plantImage;

        public CardItemViewHolder(View itemView) {
            super(itemView);
            plantName = (TextView) itemView.findViewById(R.id.card_plant_name);
            plantImage = (ImageView) itemView.findViewById(R.id.card_plant_picture);
        }
    }
}
