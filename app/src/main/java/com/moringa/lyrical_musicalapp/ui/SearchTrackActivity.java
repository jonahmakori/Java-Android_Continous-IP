package com.moringa.lyrical_musicalapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.lyrical_musicalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchTrackActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.searchTrack)
    EditText searchTrackEditText;
    @BindView(R.id.searchLyrics) EditText searchLyrics;
    @BindView(R.id.submitTrackDetails)
    Button searchTrackDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_track);

        ButterKnife.bind(this);

        searchTrackDetailsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == searchTrackDetailsButton){
            String q_track = searchTrackEditText.getText().toString();
            String q_artist = searchTrackEditText.getText().toString();
            Log.d("Entered Track:", q_track);
            Intent trackIntent = new Intent(SearchTrackActivity.this, TrackListActivity.class);
            trackIntent.putExtra("q_track",q_track);
            trackIntent.putExtra("q_artist",q_artist);
            startActivity(trackIntent);
        }

    }
}
