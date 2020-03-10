package com.moringa.lyrical_musicalapp.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringa.lyrical_musicalapp.Constants.MUSIXMATCH_BASE_URL;

public class MusixmatchClient {
    private static Retrofit retrofit = null;

    public static MusixmatchApi getClient() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {

                    Request newRequest = chain.request().newBuilder().addHeader("Authorization","Musixmatch_API_KEY").build();

                    return chain.proceed(newRequest);
                }
            })
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(MUSIXMATCH_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit.create(MusixmatchApi.class);
    }
}
