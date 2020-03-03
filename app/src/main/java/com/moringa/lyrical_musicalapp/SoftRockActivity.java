package com.moringa.lyrical_musicalapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoftRockActivity extends Activity {
    @BindView(R.id.textView2)
    TextView mSoftRock;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_rock);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String musicGenres = intent.getStringExtra("musicGenres");
        mSoftRock.setText(" Soft-Rock Music Available " );
    }
}
