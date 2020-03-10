package com.moringa.lyrical_musicalapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.adapters.TrackListAdapter;
import com.moringa.lyrical_musicalapp.models.MusixmatchTrackSearchResponse;
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

    public List<com.moringa.lyrical_musicalapp.models.TrackList> tracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String q_track = intent.getStringExtra("q_track");
        MusixmatchApi client = MusixmatchClient.getClient();

        Call<MusixmatchTrackSearchResponse> call = client.getTrack(q_track, "q_artist");

        call.enqueue(new Callback<MusixmatchTrackSearchResponse>() {
            @Override
            public void onResponse(Call<MusixmatchTrackSearchResponse> call, Response<MusixmatchTrackSearchResponse> response) {
                hideProgressBar();
                if (response.isSuccessful()) {

                    tracks = response.body().getTrackList();
                    mAdapter = new TrackListAdapter(TrackListActivity.this, tracks);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(TrackListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showTracks();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<MusixmatchTrackSearchResponse> call, Throwable t) {

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
