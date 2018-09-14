package com.flashdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    protected TextView screenResult;
    protected TextView screen;
    protected Button btn;
    protected ArrayList<Button> buttons = new ArrayList<Button>();
    protected Calculate cal = new Calculate();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        this.screenResult = (TextView) findViewById(R.id.text_result);
        this.screen = (TextView) findViewById(R.id.text_screen);

        this.getGeneralButton();
        this.getFunctionButton();

        this.setGeneralButtonEvent();
        this.setFunctionButtonEvent();


    }

    protected void getGeneralButton() {
        for (int i = 0; i <= 9; i++) {
            this.btn = (Button) findViewById(getResources().getIdentifier("btn_" + i, "id",
                    this.getPackageName()));

            this.buttons.add(this.btn);
        }

        this.btn = (Button) findViewById(R.id.btn_plus);
        this.buttons.add(this.btn);
        this.btn = (Button) findViewById(R.id.btn_minus);
        this.buttons.add(this.btn);
        this.btn = (Button) findViewById(R.id.btn_multi);
        this.buttons.add(this.btn);
        this.btn = (Button) findViewById(R.id.btn_div);
        this.buttons.add(this.btn);
    }

    protected void getFunctionButton() {
        this.btn = (Button) findViewById(R.id.btn_ac);
        this.buttons.add(this.btn);
        this.btn = (Button) findViewById(R.id.btn_equal);
        this.buttons.add(this.btn);
    }


    protected void setGeneralButtonEvent() {
        for (int i = 0; i <= this.buttons.size() - 3; i++) {
            final int index = i;
            this.buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = (String) buttons.get(index).getText();
                    text = (String) screen.getText() + text;
                    screen.setText(text);
                }
            });

        }
    }

    protected void setFunctionButtonEvent() {
        this.buttons.get( this.buttons.size()-1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                screenResult.setText("Feature is coming soon!");
                String expression = (String) screen.getText();
                double results = cal.exe(expression);
                screenResult.setText("" + results);
            }
        });

        this.buttons.get( this.buttons.size()-2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screenResult.setText("0");
            }
        });
    }
}
