package com.example.andres.pokedexAPP.Models;

import java.util.ArrayList;

/**
 * Created by Andres on 11/13/2017.
 */

public class Pokemon {

    private int number;
    private String name;
    private String url;
    private ArrayList<PokemonTypes> types;

    public ArrayList<PokemonTypes> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<PokemonTypes> types) {
        this.types = types;
    }

    public int getNumber() {
        String[] urlparts = url.split("/");
        return Integer.parseInt(urlparts[urlparts.length -1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
