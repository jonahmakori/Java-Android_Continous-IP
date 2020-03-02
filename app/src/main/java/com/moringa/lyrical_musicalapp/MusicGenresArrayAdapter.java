package com.moringa.lyrical_musicalapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.moringa.lyrical_musicalapp.ui.home.HomeFragment;

public class MusicGenresArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mMusicGenres;

    public MusicGenresArrayAdapter(Context mContext, int resource, String[] musicGenres){
        super(mContext, resource);
        this.mMusicGenres = musicGenres;
        this.mContext = mContext;
    }

    @Override
    public Object getItem(int position){
        String musicGenres = mMusicGenres[position];
        return String.format( musicGenres);
    }

    @Override
    public int getCount(){
        return mMusicGenres.length;
    }

}
