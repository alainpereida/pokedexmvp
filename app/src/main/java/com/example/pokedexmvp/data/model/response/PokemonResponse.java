package com.example.pokedexmvp.data.model.response;

import com.example.pokedexmvp.data.model.Pokemon;

import java.util.ArrayList;

public class PokemonResponse {

    private ArrayList<Pokemon> results;

    public  ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) { this.results = results; }
}
