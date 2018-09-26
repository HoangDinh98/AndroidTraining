package com.flashdev;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.DataViewHolder> {
    private ArrayList<Pokemon> pokemons;
    private Context context;

    public RecyclerDataAdapter(Context context, ArrayList<Pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
    }

    @Override
    public int getItemCount() {
        return this.pokemons == null ? 0 : this.pokemons.size();
    }

    @Override
    public RecyclerDataAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_pokemon, parent, false);
        return new DataViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(RecyclerDataAdapter.DataViewHolder holder, int position) {
        String name = this.pokemons.get(position).getTitle();
        String content = this.pokemons.get(position).getContent();
        String imgName = this.pokemons.get(position).getImage();
        int imgID = this.context.getResources().getIdentifier(imgName, "drawable", null);

        holder.title.setText(name);
        holder.content.setText(content);
        holder.avatar.setImageDrawable(this.context.getResources().getDrawable(this.context.getResources()
                .getIdentifier(pokemons.get(position).getImage(), "drawable", this.context.getPackageName())));
    }

    /**
     * Data ViewHolder class.
     */
    public static class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView title, content;
        private ImageView avatar;

        public DataViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.rv_pokemon_title);
            content = (TextView) itemView.findViewById(R.id.rv_pokemon_content);
            avatar = (ImageView) itemView.findViewById(R.id.rv_pokemon_avatar);
        }
    }
}
