package com.moringa.lyrical_musicalapp.network;

import com.moringa.lyrical_musicalapp.models.MusixmatchTrackSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusixmatchApi {
    @GET("track.search")
    Call<MusixmatchTrackSearchResponse> getTrack(
            @Query("q_track") String q_track,
            @Query("q_artist") String q_artist
    );
}
