
package com.moringa.lyrical_musicalapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class MusicGenreList_ {

    @SerializedName("music_genre")
    @Expose
    private MusicGenre_ musicGenre;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MusicGenreList_() {
    }

    /**
     * 
     * @param musicGenre
     */
    public MusicGenreList_(MusicGenre_ musicGenre) {
        super();
        this.musicGenre = musicGenre;
    }

    public MusicGenre_ getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre_ musicGenre) {
        this.musicGenre = musicGenre;
    }

}
