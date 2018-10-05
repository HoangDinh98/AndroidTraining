package com.flashdev;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SQLiteSimple extends Activity {
    EditText edtName, edtEmail;
    Button btnSave, btnView;
    MyDatabase myDatabase = new MyDatabase(this,"",null,1);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_simple);
        edtName = (EditText)findViewById(R.id.act_sql_edit_name);
        edtEmail = (EditText)findViewById(R.id.act_sql_edit_email);
        btnSave = (Button) findViewById(R.id.act_sql_btn_save);
        btnView = (Button) findViewById(R.id.act_sql_btn_view);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.insertUser(edtName.getText().toString(), edtEmail.getText().toString());
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list =  myDatabase.getUsers();
                for(int i=0;i<list.size();i++)
                    Log.d("User", list.get(i));
            }
        });
    }
}
