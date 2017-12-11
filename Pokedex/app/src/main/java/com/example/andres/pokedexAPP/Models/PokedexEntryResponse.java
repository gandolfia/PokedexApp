package com.example.andres.pokedexAPP.Models;

import java.util.ArrayList;

/**
 * Created by Andres on 11/30/2017.
 */

public class PokedexEntryResponse {
    private ArrayList<PokedexEntry> flavor_text_entries;
    private EvolutionDetails evolution_chain;
    private Pokemon color;

    public Pokemon getColor() {
        return color;
    }

    public void setColor(Pokemon color) {
        this.color = color;
    }

    public EvolutionDetails getEvolution_chain() {
        return evolution_chain;
    }

    public void setEvolution_chain(EvolutionDetails evolution_chain) {
        this.evolution_chain = evolution_chain;
    }

    public ArrayList<PokedexEntry> getFlavor_text_entries() {
        return flavor_text_entries;
    }

    public void setFlavor_text_entries(ArrayList<PokedexEntry> flavor_text_entries) {
        this.flavor_text_entries = flavor_text_entries;
    }
}
