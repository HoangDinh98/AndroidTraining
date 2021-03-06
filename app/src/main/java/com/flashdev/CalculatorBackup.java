package com.flashdev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculatorBackup extends AppCompatActivity {

    protected TextView screenResult;
    protected Button btn;
    protected Button btnMulti;
    protected Button btnDiv;
    protected Button btnAC;
    protected Button btnPlus;
    protected Button btnMinus;
    protected Button btnEqual;
    protected ArrayList<Button> buttons = new ArrayList<Button>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        screenResult = (TextView) findViewById(R.id.text_result);

        for (int i = 0; i <= 9; i++) {
            btn = (Button) findViewById(getResources().getIdentifier("btn_" + i, "id",
                    this.getPackageName()));

            this.buttons.add(btn);
            final int index = i;
            this.buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = (String) buttons.get(index).getText();
                    screenResult.setText(text);
                }
            });

//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Toast.makeText(Calculator.this, "OK", Toast.LENGTH_SHORT).show();
//                    String text = (String) btn.getText();
//                    screenResult.setText(text);
//                }
//            });


        }

//        btn = (Button) findViewById(R.id.btn_9);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Calculator.this, "OK", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}


//public class Calculator extends AppCompatActivity implements View.OnClickListener {
//
//    protected Button btn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_calculator);
//
//        btn = (Button) findViewById(R.id.btn_9);
//    }
//
//    @Override
//    public void onClick(View v) {
//        Toast.makeText(Calculator.this, "OK", Toast.LENGTH_SHORT).show();
//    }
//}
