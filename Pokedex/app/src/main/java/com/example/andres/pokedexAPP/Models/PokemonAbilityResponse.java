package com.example.andres.pokedexAPP.Models;

import java.util.ArrayList;

/**
 * Created by Andres on 11/28/2017.
 */

public class PokemonAbilityResponse {
    ArrayList<PokemonAbilities> abilities;

    public ArrayList<PokemonAbilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<PokemonAbilities> abilities) {
        this.abilities = abilities;
    }
}
