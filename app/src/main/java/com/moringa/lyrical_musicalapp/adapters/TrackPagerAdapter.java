package com.moringa.lyrical_musicalapp.adapters;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringa.lyrical_musicalapp.models.TrackList;
import com.moringa.lyrical_musicalapp.ui.TrackDetailFragment;

import java.util.List;

public class TrackPagerAdapter extends FragmentPagerAdapter {
    private List<TrackList> mTracks;

    public TrackPagerAdapter(FragmentManager fm, int behavior, List<TrackList> tracks) {
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


}