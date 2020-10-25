package com.example.pokedexmvp.data.api;

public abstract class UtilsApi {
    private UtilsApi() {};

    public static final String API_URL = "https://pokeapi.co/api/v2/";

    public static PokemonService getPokemonsService() {
        return RetrofitClient.getClient(API_URL).create(PokemonService.class);
    }
}
