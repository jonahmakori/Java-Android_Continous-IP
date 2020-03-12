
package com.moringa.lyrical_musicalapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusixmatchTrackSearchResponse {

    @SerializedName("message")
    @Expose
    private Message message;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MusixmatchTrackSearchResponse() {
    }

    /**
     * 
     * @param message
     */
    public MusixmatchTrackSearchResponse(Message message) {
        super();
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
