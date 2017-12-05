package com.example.andres.pokedex.Models;

/**
 * Created by Andres on 11/30/2017.
 */

public class PokedexEntry {
    private String flavor_text;
    private EvolutionDetails evolution_chain;
    private Pokemon language;

    public Pokemon getLanguague() {
        return language;
    }

    public void setLanguague(Pokemon languague) {
        this.language = languague;
    }

    public EvolutionDetails getEvolution_chain() {
        return evolution_chain;
    }

    public void setEvolution_chain(EvolutionDetails evolution_chain) {
        this.evolution_chain = evolution_chain;
    }

    public String getFlavor_text() {
        return flavor_text;
    }

    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }
}
