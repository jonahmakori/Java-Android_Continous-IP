package com.moringa.lyrical_musicalapp.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moringa.lyrical_musicalapp.models.MusixmatchTrackSearchResponse;

import java.lang.reflect.Type;

public class MusixmatchTrackSearchResponseConverter {
    //Convert DailyBean DataBeanXX from List to String and vice versa.
    @TypeConverter
    public static MusixmatchTrackSearchResponse fromBodyBeanString(String value){
        Type listType = new TypeToken<MusixmatchTrackSearchResponse>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromBodyBeanList(MusixmatchTrackSearchResponse list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
