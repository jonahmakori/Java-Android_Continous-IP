package com.moringa.lyrical_musicalapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.models.TrackList;
import com.moringa.lyrical_musicalapp.ui.TrackDetailActivity;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.TrackViewHolder> {
    private List<TrackList> mTracks;
//    private Lyrics mLyrics;
    private Context mContext;

    public TrackListAdapter(Context context, List<TrackList> tracks) {
        mContext = context;
        mTracks = tracks;
    }
//    public TrackListAdapter(Context context,Lyrics lyrics) {
//        mLyrics = lyrics;
//    }


    @Override
    public TrackListAdapter.TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_list_item, parent, false);
        TrackViewHolder viewHolder = new TrackViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(TrackListAdapter.TrackViewHolder holder, int position) {
        holder.bindTrack(mTracks.get(position));
//        holder.bindLyrics(mLyrics);

    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.lyricsBodyTextView) TextView mLyricsTextView;
        @BindView(R.id.textView2) TextView mNameTextView;
        @BindView(R.id.trackRating) TextView mTrackRating;
        @BindView(R.id.albumName) TextView mAlbumName;
        @BindView(R.id.artistName) TextView mArtistName;
        @BindView(R.id.trackShareUrl) TextView mTrackShareUrl;
        @BindView(R.id.seeMoreDetails)
        Button seeMoreDetails;

        private Context mContext;

        public TrackViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();


        }

        @Override
        public void onClick(View v) {
            Log.d("Clicked this now", "Clicked");
            Toast.makeText(this.mContext,"Clicked The View", Toast.LENGTH_SHORT).show();
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, TrackDetailActivity.class);
            intent.putExtra("tracks", Parcels.wrap(mTracks));
//            intent.putExtra("tracks", Parcels.wrap(mLyrics));
            intent.putExtra("position", itemPosition);
            mContext.startActivity(intent);
        }

        @SuppressLint("SetTextI18n")
        public void bindTrack(TrackList track) {
            mNameTextView.setText(track.getTrack().getTrackName());
            mTrackRating.setText("Rating: " + track.getTrack().getTrackRating() + "/100");
            mAlbumName.setText(track.getTrack().getAlbumName());
            mArtistName.setText(track.getTrack().getArtistName());
            mTrackShareUrl.setText("Check Lyrics");
            track.getTrack().getTrackShareUrl();
        }

//        public void bindLyrics(Lyrics lyrics) {
//            mLyricsTextView.setText(lyrics.getLyricsBody());
//        }
    }
}