package com.moringa.lyrical_musicalapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.models.TrackList;
import com.moringa.lyrical_musicalapp.ui.TrackDetailActivity;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//import com.moringa.lyrical_musicalapp.ui.RDetailActivity;
//import com.squareup.picasso.Picasso;
//
//import org.parceler.Parcels;

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.TrackViewHolder> {
    private List<TrackList> mTracks;
    private Context mContext;

    public TrackListAdapter(Context context, List<TrackList> tracks) {
        mContext = context;
        mTracks = tracks;
    }

    @Override
    public TrackListAdapter.TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_list_item, parent, false);
        TrackViewHolder viewHolder = new TrackViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {

    }

    //
//    @Override
//    public void onBindViewHolder( TrackListAdapter.TrackViewHolder holder, int position) {
//        holder.bindTrack(mTracks.get(position));
//
//    }
    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.q_trackTextView)
        ImageView mTrackImageView;
        @BindView(R.id.textView2)
        TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public TrackViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, TrackDetailActivity.class);
            intent.putExtra("q_artist", itemPosition);
            intent.putExtra("q_track", Parcels.wrap(mTracks));
            mContext.startActivity(intent);
        }

//        public void bindTrack(TrackList track) {
//            mNameTextView.setText(track.getName());
//            mCategoryTextView.setText(track.getTrack().getTitle());
//            mRatingTextView.setText("Rating: " + track.getRating() + "/5");
//            Picasso.get().load(track.getImageUrl()).into(mTracksImageView);
//
//        }
    }
}