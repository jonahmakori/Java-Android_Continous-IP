
package com.moringa.lyrical_musicalapp.models2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusixmatchTrackSearchResponse2 {

    @SerializedName("message")
    @Expose
    private Message message;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MusixmatchTrackSearchResponse2() {
    }

    /**
     * 
     * @param message
     */
    public MusixmatchTrackSearchResponse2(Message message) {
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
