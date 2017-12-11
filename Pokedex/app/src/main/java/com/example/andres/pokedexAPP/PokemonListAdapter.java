package com.example.andres.pokedexAPP;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.andres.pokedexAPP.Models.Pokemon;

import java.util.ArrayList;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {

    private ArrayList<Pokemon> dataset;
    private Context context;


    public void Clear()
    {
        dataset.clear();
    }

    public PokemonListAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Pokemon p = dataset.get(position);
        holder.nameTextView.setText(p.getName());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick) {
                    //Toast.makeText(context, "Long Click: " + dataset.get(position), Toast.LENGTH_LONG).show();
                }
                else {
                    String id = Integer.toString(dataset.get(position).getNumber());
                    String pokemonname = dataset.get(position).getName();
                    Intent intent = new Intent(context, PokeInfoActivity.class).putExtra("com.example.andres.pokedex.EXTRA_URL", id).putExtra("POKEMON_NAME", pokemonname);
                    context.startActivity(intent);
                    //Toast.makeText(context, "Pokemon Id: " + dataset.get(position).getNumber(), Toast.LENGTH_LONG).show();
                }
            }
        });

        Glide.with(context)
        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ p.getNumber() + ".png")
        .centerCrop()
        .crossFade()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(holder.photoImageView);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addPokemonList(ArrayList<Pokemon> pokemonList) {
        dataset.addAll(pokemonList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener, View.OnLongClickListener{

        private ImageView photoImageView;
        private TextView nameTextView;
        private ItemClickListener itemClickListener;
        public ViewHolder(View itemView)
        {
            super(itemView);
            photoImageView = (ImageView) itemView.findViewById(R.id.PhotoImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.NameTextView);
            photoImageView.setOnClickListener(this);
            photoImageView.setOnClickListener(this);
            nameTextView.setOnClickListener(this);
            nameTextView.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemclicklistener){
            this.itemClickListener = itemclicklistener;
        }
        @Override
        public void onClick(View v) {

            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return false;
        }
    }
}
