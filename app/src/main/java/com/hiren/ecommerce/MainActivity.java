
package com.hiren.ecommerce;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.hiren.ecommerce.Models.ProductModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    @Inject SharedPreferences sharedPreferences;
    @Inject OkHttpClient okHttpClient;
    @Inject Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApp) getApplication()).getNetComponent().inject(this);

        Request request = new Request.Builder()
                .url("https://stark-spire-93433.herokuapp.com/json")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                final String responseData = response.body().string();

                try {
                    Gson gson = new Gson();
                    ProductModel productModel = gson.fromJson(responseData, ProductModel.class);

                    productModel.save();
                    JSONObject jsonObject = new JSONObject(responseData);
                    JSONArray categories = jsonObject.getJSONArray("categories");
                    JSONArray rankings = jsonObject.getJSONArray("rankings");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });



/*// Enable caching for OkHttp
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
                .build();*/
    }
}
