package com.example.andres.pokedex;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andres.pokedex.Models.PokemonStats;

import java.util.ArrayList;


/**
 * Created by Andres on 11/18/2017.
 */


public class PokemonStatsAdapter extends RecyclerView.Adapter<PokemonStatsAdapter.ViewHolder>{

    ArrayList<PokemonStats> dataset;
    private Context context;

    public PokemonStatsAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stats, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PokemonStats p = dataset.get(position);
       // holder.nameTextView.setText(p.getStat().getName());
       // holder.valueTextView.setText(p.getStat().toString());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTextView;
        private TextView valueTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.Stat_NameTextView);
            valueTextView = (TextView) itemView.findViewById(R.id.Base_ValueTextView);
        }
    }

}