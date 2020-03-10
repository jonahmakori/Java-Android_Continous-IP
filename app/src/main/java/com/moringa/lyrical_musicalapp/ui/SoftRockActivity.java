package com.moringa.lyrical_musicalapp.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.moringa.lyrical_musicalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoftRockActivity extends Activity {
    @BindView(R.id.textView3)
    TextView mSoftRock;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_rock);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String musicGenres = intent.getStringExtra("musicGenres");
        mSoftRock.setText(" Artist : 1986 \n Song : It Must Have Been Love \n Go to  Lyrics " );


    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {


    }
}
