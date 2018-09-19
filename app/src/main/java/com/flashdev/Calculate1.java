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
                startActivityForResult(cal2, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2) {
            int result = data.getIntExtra("Result", 0);
            screen.setText(result + "");
        }
    }
}
