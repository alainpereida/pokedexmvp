package com.example.pokedexmvp.data.api;

import com.example.pokedexmvp.data.model.response.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonService {

    @GET("pokemon/")
    Call<PokemonResponse> getListPokemons(@Query("limit") int limit, @Query("offset") int offset);
}
