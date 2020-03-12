package com.moringa.lyrical_musicalapp.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moringa.lyrical_musicalapp.models.Track;

import java.lang.reflect.Type;
import java.util.List;


public class TrackListConverter {
    //Convert String list from List to String and vice versa.
    @TypeConverter
    public static List<Track> fromTrackBeanString(String value){
        Type listType = new TypeToken<Track>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromTrackBeanList(List<Track> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
