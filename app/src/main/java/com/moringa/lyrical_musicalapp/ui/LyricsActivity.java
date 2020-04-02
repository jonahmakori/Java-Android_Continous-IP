package com.moringa.lyrical_musicalapp.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.models.TrackList;
import com.moringa.lyrical_musicalapp.models2.MusixmatchTrackSearchResponse2;
import com.moringa.lyrical_musicalapp.network.MusixmatchApi;
import com.moringa.lyrical_musicalapp.network.MusixmatchClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LyricsActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.trackNameTextView)
    TextView mTrackNameTextView;
    @BindView(R.id.artistNameTextView) TextView mArtistNameTextView;
    @BindView(R.id.lyricsTextView) TextView mLyricsTextView;
    @BindView(R.id.moreLyricsButton)
    Button mMoreLyricsButton;
    private String mLyrics;
    private TrackList mTracks;
    private String lyricsUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String artist = intent.getStringExtra("artist");
        String track = intent.getStringExtra("track");
        lyricsUrl = intent.getStringExtra("lyricsUrl");

        mMoreLyricsButton.setOnClickListener(this);

        mTrackNameTextView.setText(track);
        mArtistNameTextView.setText(artist);
        mLyricsTextView.setMovementMethod(new ScrollingMovementMethod());
        mMoreLyricsButton.setMovementMethod(LinkMovementMethod.getInstance());

        MusixmatchApi client = MusixmatchClient.getClient();
        Call<MusixmatchTrackSearchResponse2> call = client.getLyrics(track, artist);

        call.enqueue(new Callback<MusixmatchTrackSearchResponse2>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<MusixmatchTrackSearchResponse2> call, Response<MusixmatchTrackSearchResponse2> response) {
                if(response.isSuccessful()){
                    Log.d("Response Successful", "RESPONSE ------");
                    if(response.body() != null){
                        mLyrics = response.body().getMessage().getBody().getLyrics().getLyricsBody();
                        mLyricsTextView.setText(mLyrics);
                    }else{
                        mLyricsTextView.setText("Lyrics not found");
                    }

                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFailure(Call<MusixmatchTrackSearchResponse2> call, Throwable t) {
                Log.d("NOT SUCCESSFUL", "Was not successful");
                mLyricsTextView.setText("Lyrics not found");
                mMoreLyricsButton.setVisibility(View.GONE);

            }
        });


    }

    @Override
    public void onClick(View view) {
        if( view == mMoreLyricsButton){
            Log.d("clicked", "See more");
            Intent webIntent = new Intent (Intent.ACTION_VIEW, Uri.parse(lyricsUrl));
            startActivity(webIntent);
        }
    }
}
