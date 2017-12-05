package com.example.andres.pokedex.Models;

import java.util.ArrayList;

/**
 * Created by Andres on 11/17/2017.
 */

public class PokemonAbilities {

    private int slot;
    private boolean is_hidden;
    private Pokemon ability;

    public boolean is_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public Pokemon getAbility() {
        return ability;
    }

    public void setAbility(Pokemon ability) {
        this.ability = ability;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
