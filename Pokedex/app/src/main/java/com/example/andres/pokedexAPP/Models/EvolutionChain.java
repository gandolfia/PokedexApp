package com.example.andres.pokedexAPP.Models;

import java.util.ArrayList;

/**
 * Created by Andres on 11/30/2017.
 */

public class EvolutionChain {
    ArrayList<EvolutionChain> evolves_to;

    Pokemon species;

    public ArrayList<EvolutionChain> getEvolves_to() {
        return evolves_to;
    }

    public void setEvolves_to(ArrayList<EvolutionChain> evolves_to) {
        this.evolves_to = evolves_to;
    }

    public Pokemon getSpecies() {
        return species;
    }

    public void setSpecies(Pokemon species) {
        this.species = species;
    }
}
