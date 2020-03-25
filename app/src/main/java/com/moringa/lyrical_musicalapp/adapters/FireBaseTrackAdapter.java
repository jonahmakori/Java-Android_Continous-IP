package com.moringa.lyrical_musicalapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringa.lyrical_musicalapp.Constants;
import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.models.TrackList;
import com.moringa.lyrical_musicalapp.ui.TrackDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FireBaseTrackAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
    Context mContext;
    View mView;
    private TextView mArtistTextView;
    private TextView mTrackNameTextView;
    private TextView mAlbumTextView;
    private TextView mRatingTextView;


    public FireBaseTrackAdapter(@NonNull View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mView = itemView;
        itemView.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    public void bindTrack(TrackList track){
        mArtistTextView = mView.findViewById(R.id.artistName);
        mTrackNameTextView = mView.findViewById(R.id.trackNameTextView);
        mAlbumTextView = mView.findViewById(R.id.albumName);
        mRatingTextView = mView.findViewById(R.id.trackRating);

        mArtistTextView.setText(track.getTrack().getArtistName());
        mTrackNameTextView.setText(track.getTrack().getTrackName());
        mAlbumTextView.setText(track.getTrack().getAlbumName());
        mRatingTextView.setText(Double.toString(track.getTrack().getTrackRating()));



    }


    @Override
    public void onClick(View view) {

        final ArrayList<TrackList> tracks = new ArrayList<>();
        DatabaseReference trackRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TRACKS);
        trackRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot mDataSnapshot: dataSnapshot.getChildren() ){
                    tracks.add(mDataSnapshot.getValue(TrackList.class));
                }

                Intent intent = new Intent(mContext, TrackDetailActivity.class);
                int trackPosition = getLayoutPosition();
                intent.putExtra("position", trackPosition +"");
                intent.putExtra("tracks", Parcels.wrap(tracks));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });


    }
}
