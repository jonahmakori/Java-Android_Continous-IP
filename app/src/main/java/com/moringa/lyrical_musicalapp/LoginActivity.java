package com.moringa.lyrical_musicalapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText userNameTxt, passwordTxt;
    Button signInBtn;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText userNameTxt = (EditText) findViewById(R.id.userNameTxt);
        final EditText passwordTxt = (EditText) findViewById(R.id.passwordTxt);
        final Button registerBtn = (Button) findViewById(R.id.registerBtn);
        final Button sighInBtn = (Button) findViewById(R.id.signInBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        sighInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = userNameTxt.getText().toString();
                String password = passwordTxt.getText().toString();

                if(userName.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"User Name is vacant",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if(password.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Password is vacant",
                            Toast.LENGTH_LONG).show();
                    return;
                }
               else
                {
                    Toast.makeText(getApplicationContext(),
                            "Account is not registered", Toast.LENGTH_LONG).show();
                    Intent signInIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                    LoginActivity.this.startActivity(signInIntent);
                }
            }
        });

    }

}
