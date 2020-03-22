
package com.moringa.lyrical_musicalapp.models2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lyrics {

    @SerializedName("lyrics_id")
    @Expose
    private Integer lyricsId;
    @SerializedName("explicit")
    @Expose
    private Integer explicit;
    @SerializedName("lyrics_body")
    @Expose
    private String lyricsBody;
    @SerializedName("script_tracking_url")
    @Expose
    private String scriptTrackingUrl;
    @SerializedName("pixel_tracking_url")
    @Expose
    private String pixelTrackingUrl;
    @SerializedName("lyrics_copyright")
    @Expose
    private String lyricsCopyright;
    @SerializedName("updated_time")
    @Expose
    private String updatedTime;

    /**
     * No args constructor for use in serialization
     *
     */
    public Lyrics() {
    }

    /**
     *
     * @param lyricsId
     * @param explicit
     * @param scriptTrackingUrl
     * @param updatedTime
     * @param pixelTrackingUrl
     * @param lyricsCopyright
     * @param lyricsBody
     */
    public Lyrics(Integer lyricsId, Integer explicit, String lyricsBody, String scriptTrackingUrl, String pixelTrackingUrl, String lyricsCopyright, String updatedTime) {
        super();
        this.lyricsId = lyricsId;
        this.explicit = explicit;
        this.lyricsBody = lyricsBody;
        this.scriptTrackingUrl = scriptTrackingUrl;
        this.pixelTrackingUrl = pixelTrackingUrl;
        this.lyricsCopyright = lyricsCopyright;
        this.updatedTime = updatedTime;
    }

    public Integer getLyricsId() {
        return lyricsId;
    }

    public void setLyricsId(Integer lyricsId) {
        this.lyricsId = lyricsId;
    }

    public Integer getExplicit() {
        return explicit;
    }

    public void setExplicit(Integer explicit) {
        this.explicit = explicit;
    }

    public String getLyricsBody() {
        return lyricsBody;
    }

    public void setLyricsBody(String lyricsBody) {
        this.lyricsBody = lyricsBody;
    }

    public String getScriptTrackingUrl() {
        return scriptTrackingUrl;
    }

    public void setScriptTrackingUrl(String scriptTrackingUrl) {
        this.scriptTrackingUrl = scriptTrackingUrl;
    }

    public String getPixelTrackingUrl() {
        return pixelTrackingUrl;
    }

    public void setPixelTrackingUrl(String pixelTrackingUrl) {
        this.pixelTrackingUrl = pixelTrackingUrl;
    }

    public String getLyricsCopyright() {
        return lyricsCopyright;
    }

    public void setLyricsCopyright(String lyricsCopyright) {
        this.lyricsCopyright = lyricsCopyright;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

}
