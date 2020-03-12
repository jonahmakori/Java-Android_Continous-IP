package com.moringa.lyrical_musicalapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.models.Track;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackDetailFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.textView2)
    ImageView mImageLabel;
    @BindView(R.id.restaurantNameTextView)
    TextView mNameLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveSearcTrackButton) TextView mSaveSearchTrackButton;

    private Track mTracks;

    public TrackDetailFragment() {
        // Required empty public constructor
    }

    public static TrackDetailFragment newInstance(Track track) {
        TrackDetailFragment trackDetailFragment = new TrackDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("q_track", Parcels.wrap(track));
        trackDetailFragment.setArguments(args);
        return trackDetailFragment;
    }

//    public static TrackDetailFragment newInstance(Track track) {
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTracks = Parcels.unwrap(getArguments().getParcelable("q_artist"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_track_detail, container, false);
        ButterKnife.bind(this, view);

        //Picasso.get().load(mTracks.getLyricsId()).into(mImageLabel);

        List<Class<Locale.Category>> categories = new ArrayList<>();

        for (Locale.Category category: mSaveSearchTrackButton()) {
            categories.add(category.getDeclaringClass());
        }

        //mNameLabel.setText(mTracks.);
        //mSaveSearchTrackButton.setText(android.text.TextUtils.join(", ", categories));
        //mRatingLabel.setText(Double.toString(mTracks.getHasLyrics()) + "/5");
        //mPhoneLabel.setText(mTracks.getTrackSpotifyId());
//        mAddressLabel.setText(mTracks.getHasLyrics().toString());
        //mWebsiteLabel.setOnClickListener(this);
        //mPhoneLabel.setOnClickListener(this);
        //mAddressLabel.setOnClickListener(this);
        return view;
    }

    private Locale.Category[] mSaveSearchTrackButton() {
        return mSaveSearchTrackButton();
    }


    @Override
    public void onClick(View v){
        if (v == mWebsiteLabel){
            Intent webIntent = new Intent (Intent.ACTION_VIEW, Uri.parse(mTracks.getTrackEditUrl()));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mTracks.getTrackShareUrl()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel){
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + mTracks.getHasLyrics()
                    + "," + mSaveSearchTrackButton.getAutoLinkMask() + "?q=(" + mSaveSearchTrackButton.getBaseline() +")"));
            startActivity(mapIntent);
        }



    }
}
