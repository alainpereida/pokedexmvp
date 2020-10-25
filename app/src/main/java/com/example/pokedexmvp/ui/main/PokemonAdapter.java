package com.example.pokedexmvp.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokedexmvp.R;
import com.example.pokedexmvp.data.model.Pokemon;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder>  {
    private ArrayList<Pokemon> list = new ArrayList<>();
    private Context context;

    public PokemonAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PokemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pokemon, parent, false);
        return new PokemonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonHolder holder, int position) {
        holder.pokemon = list.get(position);
        holder.nameView.setText(holder.pokemon.getName());
        holder.number.setText("No. " + holder.pokemon.getNumber());

        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + holder.pokemon.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        list.addAll(pokemons);
        notifyDataSetChanged();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView nameView;
        private final TextView number;
        public Pokemon pokemon;

        public PokemonHolder(@NonNull View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            nameView = (TextView) view.findViewById(R.id.nameView);
            number = (TextView) view.findViewById(R.id.numerView);
        }

        @Override
        public String toString() {
            return super.toString() + "ViewHolder{" +
                    "imageView=" + imageView +
                    ", nameView=" + nameView +
                    '}';
        }
    }
}
