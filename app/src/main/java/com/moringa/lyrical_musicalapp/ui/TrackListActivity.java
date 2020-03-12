package com.moringa.lyrical_musicalapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.lyrical_musicalapp.Constants;
import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.adapters.TrackListAdapter;
import com.moringa.lyrical_musicalapp.models.MusixmatchTrackSearchResponse;
import com.moringa.lyrical_musicalapp.models.Track;
import com.moringa.lyrical_musicalapp.network.MusixmatchApi;
import com.moringa.lyrical_musicalapp.network.MusixmatchClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrackListActivity extends AppCompatActivity {
    private static final String TAG = TrackListActivity.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private TrackListAdapter mAdapter;

    public MusixmatchTrackSearchResponse musixmatchTrackSearchResponse;

    private String q_track;
    private String q_artist;
    private List<Track> trackList;
    private String url = "apikey=" + Constants.MUSIXMATCH_API_KEY;
    private String trackName;
    private Track musicTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        q_track = intent.getStringExtra("q_track");
        q_artist = intent.getStringExtra("q_artist");

        //Client
        MusixmatchApi client = MusixmatchClient.getClient();
        Log.e("Client", "client");
        //Make Call Request
        Call<MusixmatchTrackSearchResponse> call = client.getTrack(q_track, q_artist);
        Log.e("added data",String.valueOf( q_artist));

        //Enqueue request.
        call.enqueue(new Callback<MusixmatchTrackSearchResponse>() {

            @Override
            public void onResponse(Call<MusixmatchTrackSearchResponse> call, Response<MusixmatchTrackSearchResponse> response) {
                hideProgressBar();
                if (response.isSuccessful()) {
                    Log.e("Success", String.valueOf(response.body()));

//                    trackName = response.body().getMessage().getBody().getTrackList().get(1).getTrack().getTrackName();
//                    trackList = musixmatchTrackSearchResponse.getMessage().getBody().getTrackList();
//                    trackList = response.body().getMessage().getBody().getTrackList();
//                    mAdapter = new TrackListAdapter(TrackListActivity.this, trackList);
//                    RecyclerView.LayoutManager layoutManager =
//                            new LinearLayoutManager(TrackListActivity.this);
//                    mRecyclerView.setAdapter(mAdapter);
//                    mRecyclerView.setLayoutManager(layoutManager);
//                    mRecyclerView.setHasFixedSize(true);

                    showTracks();
                }
//                    showUnsuccessfulMessage();

            }

            @Override
            public void onFailure(Call<MusixmatchTrackSearchResponse> call, Throwable t) {
                Log.e("error", t.getMessage());
                hideProgressBar();
                showFailureMessage();
            }

        });
    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showTracks() {
        mRecyclerView.setVisibility(View.VISIBLE);

    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
