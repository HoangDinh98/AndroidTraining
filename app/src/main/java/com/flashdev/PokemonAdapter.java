package com.flashdev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PokemonAdapter extends BaseAdapter {
    private Context currentContext;
    ArrayList<Pokemon> listPokemon;

    public PokemonAdapter(Context currentContext, ArrayList<Pokemon> listPokemon) {
        this.currentContext = currentContext;
        this.listPokemon = listPokemon;
    }

    @Override
    public int getCount() {
        return this.listPokemon.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.currentContext);
        View view = inflater.inflate(R.layout.listview_pokemon, null);
        TextView title = (TextView) view.findViewById(R.id.listview_fruit_tilte);
        TextView content = (TextView) view.findViewById(R.id.listview_fruit_content);
        ImageView imgv = (ImageView) view.findViewById(R.id.listview_fruit_avatar);

        title.setText(listPokemon.get(position).getTitle());
        content.setText(listPokemon.get(position).getContent());
        imgv.setImageDrawable(this.currentContext.getResources().getDrawable(this.currentContext.getResources()
                .getIdentifier(listPokemon.get(position).getImage(), "drawable", this.currentContext.getPackageName())));

        return view;
    }
}
