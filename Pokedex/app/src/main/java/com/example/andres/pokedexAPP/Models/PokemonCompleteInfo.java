package com.example.andres.pokedexAPP.Models;

import java.util.ArrayList;

/**
 * Created by Andres on 11/26/2017.
 */

public class PokemonCompleteInfo {

    ArrayList<PokemonTypes> types;
    ArrayList<PokemonStatsResponse> stats;

    private int id;
    private int height;
    private int weight;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<PokemonTypes> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<PokemonTypes> types) {
        this.types = types;
    }

    public ArrayList<PokemonStatsResponse> getStats() {
        return stats;
    }

    public void setStats(ArrayList<PokemonStatsResponse> stats) {
        this.stats = stats;
    }
}
