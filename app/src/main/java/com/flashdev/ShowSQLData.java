package com.flashdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.flashdev.models.UserModel;
import com.flashdev.objects.User;
import com.flashdev.viewadapter.SQLiteViewAdapter;

import java.util.ArrayList;

public class ShowSQLData extends AppCompatActivity {

    private RecyclerView userList;
    private ArrayList<User> users = new ArrayList<>();
    UserModel userModel = new UserModel(this, Config.DATABASE_NAME,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sqldata);

        this.setup();
        this.getData();
        this.setApater();
    }

    protected void setup() {
        this.userList = (RecyclerView) findViewById(R.id.act_sql_show);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        userList.setLayoutManager(layoutManager);
        userList.setHasFixedSize(true);
    }

    protected void getData() {
        this.users = userModel.getUsers();
    }

    protected void setApater() {
        this.userList.setAdapter(new SQLiteViewAdapter(this, users));
    }

}
