package com.example.andres.pokedexAPP.Models;

/**
 * Created by Andres on 11/30/2017.
 */

public class EvolutionDetails {
    private String url;
    private int number;

    public int getNumber() {
        String[] urlparts = url.split("/");
        return Integer.parseInt(urlparts[urlparts.length -1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
