package com.example.murid;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
        public static final String BASE_URL="https://api.myjson.com/";
        public static Retrofit retrofit;
        public  static Retrofit getApiClient() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

            }
            return retrofit;
        }
    }


