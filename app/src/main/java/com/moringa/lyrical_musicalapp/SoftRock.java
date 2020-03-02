package com.moringa.lyrical_musicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoftRock extends AppCompatActivity {
    @BindView(R.id.softrock) TextView mSoftRock;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_rock);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String musicGenres = intent.getStringExtra("musicGenres");
        mSoftRock.setText("These is HipHop Music " );
    }
}
