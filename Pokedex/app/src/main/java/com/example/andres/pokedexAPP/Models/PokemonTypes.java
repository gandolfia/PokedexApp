package com.example.andres.pokedexAPP.Models;

/**
 * Created by Andres on 11/17/2017.
 */

public class PokemonTypes {

    private int slot;
    private Pokemon type;


    public Pokemon getType() {
        return type;
    }

    public void setType(Pokemon type) {
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

}
