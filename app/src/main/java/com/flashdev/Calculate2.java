package com.flashdev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculate2 extends AppCompatActivity {
    protected EditText num1, num2;
    protected Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate2);

        this.config();
        this.setOKEvent();
    }

    protected void config() {
        this.num1 = (EditText) findViewById(R.id.atv_cal2_num1);
        this.num2 = (EditText) findViewById(R.id.atv_cal2_num2);
        this.btnCalculate = (Button) findViewById(R.id.atv_cal2_btn_switch);
    }

    protected void setOKEvent() {
        this.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());

                Intent cal1 = new Intent();
                cal1.putExtra("number1", n1);
                cal1.putExtra("number2", n2);
                cal1.putExtra("Result", n1 + n2);
                setResult(Config.MANUAL_CAL_CODE, cal1);
                finish();
            }
        });
    }
}
