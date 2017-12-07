
package com.hiren.ecommerce;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



// Enable caching for OkHttp
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(getApplication().getCacheDir(), cacheSize);
        OkHttpClient.Builder client = new OkHttpClient.Builder().cache(cache);

// Used for caching authentication tokens
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

// Instantiate Gson
        Gson gson = new GsonBuilder().create();
        GsonConverterFactory converterFactory = GsonConverterFactory.create(gson);

// Build Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(converterFactory)
                .client(client.build())  // custom client
                .build();
    }
}
