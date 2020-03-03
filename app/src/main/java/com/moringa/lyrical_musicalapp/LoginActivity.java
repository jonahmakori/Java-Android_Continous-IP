package com.moringa.lyrical_musicalapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userNameTxt, passwordTxt;
    Button signInBtn;
    Context context = this;
    @BindView(R.id.signInBtn)
    Button getSignInBtn;
    @BindView(R.id.userNameTxt)
    EditText getUserNameTxt;
    @BindView(R.id.registerBtn)
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

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
                    Toast.makeText(getApplicationContext(),"Your UserName Is **Required**",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if(password.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Your Password Is **Required**",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (userName.equals("") && password.equals(""))
                {

                    Toast.makeText(getApplicationContext(),
                            "Login Was Successful", Toast.LENGTH_LONG).show();
                    Intent signInIntent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(signInIntent);
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

    @Override
    public void onClick(View view) {

    }
}
