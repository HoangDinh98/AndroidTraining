package com.flashdev.viewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flashdev.Pokemon;
import com.flashdev.R;
import com.flashdev.objects.User;

import java.util.ArrayList;

public class SQLiteViewAdapter extends RecyclerView.Adapter<SQLiteViewAdapter.DataViewHolder> {
    private ArrayList<User> users;
    private Context context;

    public SQLiteViewAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getItemCount() {
        return this.users == null ? 0 : this.users.size();
    }

    @Override
    public SQLiteViewAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sql_list_user, parent, false);
        return new DataViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(SQLiteViewAdapter.DataViewHolder holder, int position) {
        String name = this.users.get(position).getName();
        String email = this.users.get(position).getEmail();

        holder.name.setText(name);
        holder.email.setText(email);
        holder.avatar.setImageResource(R.drawable.pokemon_01);
    }

    /**
     * Data ViewHolder class.
     */
    public static class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView name, email;
        private ImageView avatar;

        public DataViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_sql_name);
            email = (TextView) itemView.findViewById(R.id.item_sql_email);
            avatar = (ImageView) itemView.findViewById(R.id.item_sql_avatar);
        }
    }
}
