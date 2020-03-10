
package com.moringa.lyrical_musicalapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;


@Parcel
public class MusixmatchTrackSearchResponse {

    @SerializedName("track_list")
    @Expose
    private List<TrackList> trackList = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public MusixmatchTrackSearchResponse() {
    }

    /**
     *
     * @param trackList
     */
    public MusixmatchTrackSearchResponse(List<TrackList> trackList) {
        super();
        this.trackList = trackList;
    }

    public List<TrackList> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<TrackList> trackList) {
        this.trackList = trackList;
    }

}
