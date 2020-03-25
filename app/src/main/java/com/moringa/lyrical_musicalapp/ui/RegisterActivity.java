package com.moringa.lyrical_musicalapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringa.lyrical_musicalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends Activity implements View.OnClickListener {
    public static final String TAG = RegisterActivity.class.getSimpleName();
    private String mLoggedUser;

    private FirebaseAuth mAuthentication;
    private FirebaseAuth.AuthStateListener mAuthenticationListener;


    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @BindView(R.id.createUserButton) Button mSubmitRegButton;
    @BindView(R.id.loginTextView) TextView mLoginTextView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        this.setTitle("Register");
        mLoginTextView.setOnClickListener(this);
        mSubmitRegButton.setOnClickListener(this);


        mAuthentication = FirebaseAuth.getInstance();
        createAuthenticationStateListener();



    }

    private void createAuthenticationStateListener() {

        mAuthenticationListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if(firebaseUser != null){
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }

        };
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuthentication.addAuthStateListener(mAuthenticationListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if(mAuthenticationListener != null){
            mAuthentication.removeAuthStateListener(mAuthenticationListener);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == mLoginTextView){
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if(view == mSubmitRegButton){
            createNewUser();

        }

    }

    private void createNewUser() {
        final String name = mNameEditText.getText().toString().trim();
        final String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();

        mAuthentication.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
                        } else {
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
