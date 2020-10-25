package com.example.pokedexmvp.ui.main;

import android.content.Context;

import com.example.pokedexmvp.data.model.Pokemon;

import java.util.ArrayList;

public interface PokemonScreenContract {
    interface View {
        Context getAppContext();
        void setList(ArrayList<Pokemon> pokemons);
    }

    interface Presenter {
        void getData();
        Context getAppContext();
        void logout();
        void setList(ArrayList<Pokemon> pokemons);
    }

    interface Interactor {
        void getData();
        void logout();
    }
}
