package com.moringa.lyrical_musicalapp.TypeConverters;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moringa.lyrical_musicalapp.models.Body;

import java.lang.reflect.Type;

public class BodyCoverter {
    //Convert DailyBean DataBeanXX from List to String and vice versa.
    @TypeConverter
    public static Body fromBodyBeanString(String value){
        Type listType = new TypeToken<Body>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromBodyBeanList(Body list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
