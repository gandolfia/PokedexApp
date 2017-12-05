package com.example.andres.pokedex.Models;

/**
 * Created by Andres on 11/13/2017.
 */

public class Pokemon {

    private int number;
    private String name;
    private String url;

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
