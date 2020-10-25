package com.example.pokedexmvp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.pokedexmvp.R;
import com.example.pokedexmvp.data.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonScreenActivity extends AppCompatActivity implements PokemonScreenContract.View {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private PokemonAdapter pokemonAdapter;
    private PokemonScreenPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PokemonScreenPresenter(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(layoutManager);

        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        pokemonAdapter = new PokemonAdapter(this);
        recyclerView.setAdapter(pokemonAdapter);

        presenter.getData();
    }

    @Override
    public Context getAppContext() {
        return this;
    }

    @Override
    public void setList(ArrayList<Pokemon> pokemons) {
        Toast.makeText(this, "Total Pokemons: " + pokemons.size(), Toast.LENGTH_LONG).show();
        pokemonAdapter.setPokemons(pokemons);
    }
}