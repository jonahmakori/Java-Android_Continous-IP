package com.moringa.lyrical_musicalapp.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.lyrical_musicalapp.Constants;
import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.models.TrackList;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackDetailFragment extends Fragment implements View.OnClickListener{


    @BindView(R.id.trackNameTextView)
    TextView mTrackNameTextView;
    @BindView(R.id.fragmentRatingTextView) TextView mRatingTextView;
    @BindView(R.id.lyricsTextView) TextView mLyricsTextView;
    @BindView(R.id.fragmentAlbumName) TextView mFragmentAlbumName;
    @BindView(R.id.saveTrackButton) Button mSaveTrackButton;
    @BindView(R.id.artistNameTextView) TextView mArtistNameTextView;

    private TrackList mTracks;

    public TrackDetailFragment() {
        // Required empty public constructor
    }

    public static TrackDetailFragment newInstance(TrackList track) {
        TrackDetailFragment trackDetailFragment = new TrackDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("tracks", Parcels.wrap(track));
        trackDetailFragment.setArguments(args);
        return trackDetailFragment;
    }

//    public static TrackDetailFragment newInstance(Track track) {
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTracks = Parcels.unwrap(getArguments().getParcelable("tracks"));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_track_detail, container, false);
        ButterKnife.bind(this, view);

        //Picasso.get().load(mTracks.getLyricsId()).into(mImageLabel);



        mRatingTextView.setText(Double.toString(mTracks.getTrack().getTrackRating()) + "/35");
        mTrackNameTextView.setText(mTracks.getTrack().getTrackName());
        mFragmentAlbumName.setText(mTracks.getTrack().getAlbumName());
        mArtistNameTextView.setText(mTracks.getTrack().getArtistName());
        mLyricsTextView.setOnClickListener(this);
        mSaveTrackButton.setOnClickListener(this);
        return view;
    }



    @Override
    public void onClick(View v){
        if (v == mLyricsTextView){

                    Toast.makeText(this.getContext(), "Going to Lyrics", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this.getContext(), LyricsActivity.class);
                    String track = mTracks.getTrack().getTrackName();
                    String artist = mTracks.getTrack().getArtistName();
                    String lyricsUrl = mTracks.getTrack().getTrackShareUrl();
                    intent.putExtra("lyricsUrl", lyricsUrl);
                    intent.putExtra("track", track);
                    intent.putExtra("artist", artist);
                    startActivity(intent);

//            Intent webIntent = new Intent (Intent.ACTION_VIEW, Uri.parse(mTracks.getTrack().getTrackShareUrl()));
//            startActivity(webIntent);
        }
        if(v == mSaveTrackButton){
            DatabaseReference trackRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TRACKS);
            trackRef.push().setValue(mTracks);
            Toast.makeText(getContext(), "Saved Track", Toast.LENGTH_SHORT).show();
        }

    }
}
