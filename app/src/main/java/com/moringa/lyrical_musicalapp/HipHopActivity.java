package com.moringa.lyrical_musicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HipHopActivity extends AppCompatActivity {
    @BindView(R.id.textView2) TextView mHiphop;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hip_hop);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String musicGenres = intent.getStringExtra("musicGenres");
        mHiphop.setText("Artist : Khaligraph Jones \n Song : Instagram Girls \n Got to  Lyrics " );
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {


    }
}
