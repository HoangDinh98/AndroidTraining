package com.flashdev;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculate1 extends AppCompatActivity {
    protected Button btnCalculate;
    protected TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate1);

        this.btnCalculate = (Button) findViewById(R.id.atv_cal1_btn_switch);
        this.screen = (TextView) findViewById(R.id.atv_cal1_text_result);

        this.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cal2 = new Intent(Calculate1.this, Calculate2.class);
                startActivityForResult(cal2, Config.MANUAL_CAL_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Config.MANUAL_CAL_CODE) {
            int num1 = data.getIntExtra("number1", 0);
            int num2 = data.getIntExtra("number2", 0);
            int result = data.getIntExtra("Result", 0);
            screen.setText(num1 + " + "+ num2 + " = " + result);
        }
    }
}
