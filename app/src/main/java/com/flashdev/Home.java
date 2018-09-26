package com.flashdev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    protected Button btnCalculator, btnManualCal, btnListView, btnRecyclerView;
    protected TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.config();
        this.receiveData();
        this.setEvent();
    }

    protected void config() {
        this.btnCalculator = (Button) findViewById(R.id.act_home_btn_calculator);
        this.btnManualCal = (Button) findViewById(R.id.act_home_btn_manual_cal);
        this.btnListView = (Button) findViewById(R.id.act_home_btn_listview);
        this.btnRecyclerView = (Button) findViewById(R.id.act_home_btn_recyclerview);
        this.txtWelcome = (TextView) findViewById(R.id.act_home_text_welcome);
    }

    protected void receiveData() {
        if (getIntent() == null) {
            this.txtWelcome.setText("Welcome Guest!");
            return;
        }
        String userName = getIntent().getStringExtra("userName");
        this.txtWelcome.setText("Welcome " + userName + " !");
    }

    protected void setEvent() {
        this.btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculator = new Intent(Home.this, Calculator.class);
                startActivity(calculator);
            }
        });

        this.btnManualCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent manualCal = new Intent(Home.this, Calculate1.class);
                startActivity(manualCal);
            }
        });

        this.btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listViewDemo = new Intent(Home.this, ListViewDemo.class);
                startActivity(listViewDemo);
            }
        });

        this.btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recyclerViewDemo = new Intent(Home.this, RecyclerViewDemo.class);
                startActivity(recyclerViewDemo);
            }
        });
    }
}
