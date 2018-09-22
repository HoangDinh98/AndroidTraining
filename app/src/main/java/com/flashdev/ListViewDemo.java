package com.flashdev;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewDemo extends Activity {
    private ListView listItems;
    private PokemonAdapter pokemonAdapter;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listItems = (ListView)findViewById(R.id.act_listview);
        setData();

        pokemonAdapter = new PokemonAdapter(this, pokemons);

        listItems.setAdapter(pokemonAdapter);

    }

    private void setData(){
        pokemons.add(new Pokemon("Pikachu","abc fdsfdsf ", "pokemon_01"));
        pokemons.add(new Pokemon("Freeza","abc fdsfdsf ","pokemon_06"));
        pokemons.add(new Pokemon("Slapter","abc fdsfdsf ","pokemon_03"));
        pokemons.add(new Pokemon("Ilumis","abc fdsfdsf ","pokemon_04"));
        pokemons.add(new Pokemon("Nepus","abc fdsfdsf ","pokemon_05"));
    }
}
