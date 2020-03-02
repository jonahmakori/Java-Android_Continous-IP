package com.moringa.lyrical_musicalapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {


    EditText usernameRegTxt, passwordRegTxt, emailRegTxt;
    Button submitRegBtn;
    Context context = this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setTitle("Register");

        final EditText usernameRegTxt = (EditText) findViewById(R.id.usernameRegTxt);
        final EditText passwordRegTxt = (EditText) findViewById(R.id.passwordRegTxt);
        final EditText emailRegTxt = (EditText) findViewById(R.id.emailRegTxt);
        final Button submitRegBtn = (Button) findViewById(R.id.submitRegBtn);

        submitRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = usernameRegTxt.getText().toString();
                String password = passwordRegTxt.getText().toString();
                String email = emailRegTxt.getText().toString();

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
                if(email.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Email is vacant",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {

                    Toast.makeText(getApplicationContext(),
                            "Account Created", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(RegisterActivity.this,
                            MainActivity.class);
                    startActivity(i);

                }
            }
        });
    }

}
