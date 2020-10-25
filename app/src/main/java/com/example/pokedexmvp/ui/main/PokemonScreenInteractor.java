package com.example.pokedexmvp.ui.main;

import android.util.Log;

import com.example.pokedexmvp.data.api.PokemonService;
import com.example.pokedexmvp.data.api.UtilsApi;
import com.example.pokedexmvp.data.model.response.PokemonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonScreenInteractor implements PokemonScreenContract.Interactor {

    private PokemonScreenPresenter presenter;
    private PokemonService pokemonSerivce;

    public PokemonScreenInteractor(PokemonScreenPresenter presenter) {
        pokemonSerivce = UtilsApi.getPokemonsService();
        this.presenter = presenter;
    }

    @Override
    public void getData() {
        Call<PokemonResponse> call = pokemonSerivce.getListPokemons(50, 0);
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    PokemonResponse pokemonResponse = response.body();
                    presenter.setList(pokemonResponse.getResults());
                } else {
                    Log.i("POKEDEX", "Pokemon " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.i("POKEDEX", "ERROR:  " + t.getMessage());
            }
        });
    }

    @Override
    public void logout() {

    }
}
