package com.flashdev;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class RecyclerViewDemo extends AppCompatActivity {
    private RecyclerView rvItems;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        rvItems = (RecyclerView)findViewById(R.id.act_rv_list);
        setData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvItems.setLayoutManager(layoutManager);
        rvItems.setHasFixedSize(true);
        rvItems.setAdapter(new RecyclerDataAdapter(this, pokemons));
    }

    private void setData(){
        pokemons.add(new Pokemon("Pikachu","abc 1 ", "pokemon_01"));
        pokemons.add(new Pokemon("Freeza","abc 2 ","pokemon_06"));
        pokemons.add(new Pokemon("Slapter","abc 3 ","pokemon_03"));
        pokemons.add(new Pokemon("Ilumis","abc 4 ","pokemon_04"));
        pokemons.add(new Pokemon("Nepus","abc 5 ","pokemon_05"));
        pokemons.add(new Pokemon("Pikachu","abc 1 ", "pokemon_01"));
        pokemons.add(new Pokemon("Freeza","abc 2 ","pokemon_06"));
        pokemons.add(new Pokemon("Slapter","abc 3 ","pokemon_03"));
        pokemons.add(new Pokemon("Ilumis","abc 4 ","pokemon_04"));
        pokemons.add(new Pokemon("Nepus","abc 5 ","pokemon_05"));
        pokemons.add(new Pokemon("Pikachu","abc 1 ", "pokemon_01"));
        pokemons.add(new Pokemon("Freeza","abc 2 ","pokemon_06"));
        pokemons.add(new Pokemon("Slapter","abc 3 ","pokemon_03"));
        pokemons.add(new Pokemon("Ilumis","abc 4 ","pokemon_04"));
        pokemons.add(new Pokemon("Nepus","abc 5 ","pokemon_05"));
    }
}
