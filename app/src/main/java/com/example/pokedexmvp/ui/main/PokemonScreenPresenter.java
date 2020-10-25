package com.example.pokedexmvp.ui.main;

import android.content.Context;

import com.example.pokedexmvp.data.model.Pokemon;

import java.util.ArrayList;

public class PokemonScreenPresenter implements PokemonScreenContract.Presenter {

    private PokemonScreenInteractor interactor;
    private PokemonScreenActivity view;

    public PokemonScreenPresenter(PokemonScreenActivity view) {
        this.interactor = new PokemonScreenInteractor(this);
        this.view = view;
    }

    @Override
    public void getData() {
        interactor.getData();
    }

    @Override
    public Context getAppContext() {
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public void setList(ArrayList<Pokemon> pokemons) {
        view.setList(pokemons);
    }
}
