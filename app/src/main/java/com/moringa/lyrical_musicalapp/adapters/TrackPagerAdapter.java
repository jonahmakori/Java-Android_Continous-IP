package com.moringa.lyrical_musicalapp.adapters;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringa.lyrical_musicalapp.models.Track;
import com.moringa.lyrical_musicalapp.ui.TrackDetailFragment;

import java.util.List;

public class TrackPagerAdapter extends FragmentPagerAdapter {
    private List<Track> mTracks;

    public TrackPagerAdapter(FragmentManager fm, int behavior, List<Track> tracks) {
        super(fm, behavior);
        mTracks = tracks;
    }

    @Override
    public TrackDetailFragment getItem(int position) {
        return TrackDetailFragment.newInstance(mTracks.get(position));
    }

    @Override
    public int getCount() {
        return mTracks.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTracks.get(position).getArtistName();
    }
}