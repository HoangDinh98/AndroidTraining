package com.flashdev;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
    protected EditText email, password;
    protected Button btnLogin;
    protected String error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.config();
    }

    protected void config() {
        this.email = (EditText) findViewById(R.id.act_log_edit_phone);
        this.password = (EditText) findViewById(R.id.act_log_edit_password);
        this.btnLogin = (Button) findViewById(R.id.act_log_btn_login);
    }

    protected void setAction() {
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInfo();

                if(error != "") {
                    Toast.makeText(Login.this, error, Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
    }

    protected void checkInfo() {
        String strEmail = email.getText().toString();
        String strPassword = password.getText().toString();

        if (strEmail != "admin") {
            this.error = "Email or Password incorect!";
            return;
        }

        if (strPassword != "admin") {
            this.error = "Password incorect!";
            return;
        }

        this.error = "";
    }



}
