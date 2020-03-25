package com.moringa.lyrical_musicalapp.network;


import com.moringa.lyrical_musicalapp.Constants;
import com.moringa.lyrical_musicalapp.models.MusixmatchTrackSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusixmatchApi {
    @GET("/ws/1.1/track.search&" + "apikey=" + Constants.MUSIXMATCH_API_KEY)
    Call<MusixmatchTrackSearchResponse> getTracks(
            @Query("q_track") String q_track,
            @Query("q_artist") String q_artist
    );

//        @GET("/ws/1.1/matcher.lyrics.get&" + "apikey=" + Constants.MUSIXMATCH_API_KEY)
//    Call<MusixmatchTrackSearchResponse2> getLyrics(
//            @Query("q_track") String q_track,
//            @Query("q_artist") String q_artist
//    );

}