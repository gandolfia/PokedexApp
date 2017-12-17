package com.example.andres.pokedexAPP;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.andres.pokedexAPP.Models.Pokemon;

import java.util.ArrayList;

/**
 * Created by Andres on 12/17/2017.
 */

public class PokemonTypeAdapter extends RecyclerView.Adapter<PokemonTypeAdapter.ViewHolder>{
    private ArrayList<Pokemon> dataset;
    private Context context;

    public PokemonTypeAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }
    public PokemonTypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Pokemon p = dataset.get(position);
        holder.buttonType.setText(p.getName());
        holder.buttonType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EmptyACtivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addPokemonList(ArrayList<Pokemon> pokemonList) {
        dataset.addAll(pokemonList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        private Button buttonType;
        public ViewHolder(View itemView)
        {
            super(itemView);
            buttonType = (Button) itemView.findViewById(R.id.TypeButton);


        }

    }
}
