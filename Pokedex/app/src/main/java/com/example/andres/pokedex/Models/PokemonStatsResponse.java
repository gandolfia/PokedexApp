package com.example.andres.pokedex.Models;

/**
 * Created by Andres on 11/26/2017.
 */

public class PokemonStatsResponse {
    private PokemonStats stat;
    private int effort;
    private int base_stat;

    public PokemonStats getStat() {
        return stat;
    }

    public void setStat(PokemonStats stat) {
        this.stat = stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }
}
