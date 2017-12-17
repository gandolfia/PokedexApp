package com.example.andres.pokedexAPP.Models;

import java.util.ArrayList;

/**
 * Created by Andres on 12/17/2017.
 */

public class PokemonTypeListResponse {
    private ArrayList<PokemonTypeList> pokemon;

    public ArrayList<PokemonTypeList> getPokemon() {
        return pokemon;
    }

    public void setPokemon(ArrayList<PokemonTypeList> pokemonTypeList) {
        this.pokemon = pokemonTypeList;
    }
}
