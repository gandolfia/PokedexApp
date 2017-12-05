package com.example.andres.pokedex.Models;

import java.util.ArrayList;

/**
 * Created by Andres on 11/26/2017.
 */

public class PokemonTypesResponse {
    private ArrayList<PokemonTypes> types;

    public ArrayList<PokemonTypes> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<PokemonTypes> types) {
        this.types = types;
    }
}
