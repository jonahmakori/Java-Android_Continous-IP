package com.moringa.lyrical_musicalapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.adapters.TrackPagerAdapter;
import com.moringa.lyrical_musicalapp.models.TrackList;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private TrackPagerAdapter adapterViewPager;
    List<TrackList> mTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_detail);
        ButterKnife.bind(this);

        mTracks = Parcels.unwrap(getIntent().getParcelableExtra("tracks"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new com.moringa.lyrical_musicalapp.adapters.TrackPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mTracks);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
