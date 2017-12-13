
package com.hiren.ecommerce;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.hiren.ecommerce.Models.Category;
import com.hiren.ecommerce.Models.Product;
import com.hiren.ecommerce.Models.ProductModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    public static final String CATEGORYID = "CategoryId";
    @Inject SharedPreferences sharedPreferences;
    @Inject OkHttpClient okHttpClient;
    @Inject Retrofit retrofit;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ProductModel productModel;
    ArrayList<Category> categories;
    CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApp) getApplication()).getNetComponent().inject(this);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateData();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.categoriesRV);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        categories = new ArrayList<>();

        fetchData();


        categoriesAdapter = new CategoriesAdapter(categories);

        recyclerView.setAdapter(categoriesAdapter);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Category category = categories.get(position);

                if(category.getChildCategories().size() > 0) {
                    categories.clear();
                    for (Category cat :
                            productModel.getCategories()) {
                        for (int i = 0; i < category.getChildCategories().size(); i++) {
                            if (cat.getId() == category.getChildCategories().get(i)) {
                                categories.add(cat);
                            }
                        }
                    }

                    categoriesAdapter.notifyDataSetChanged();
                }

                else {
                    Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                    intent.putExtra(CATEGORYID, category.getId());
                    startActivity(intent);
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

    void fetchData(){
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

                Gson gson = new Gson();
                productModel = gson.fromJson(responseData, ProductModel.class);

                productModel.save();


                for (Category category :
                        productModel.getCategories()) {
                    if (category.getChildCategories().size() > 0) {
                        categories.add(category);
                    }
                }

                for (int i = 0; i < categories.size(); i++) {
                    for (int j = 0; j < categories.size(); j++) {
                        if(categories.get(i).getChildCategories().contains(categories.get(j).getId())){
                            categories.remove(j);
                            j--;
                        }
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        categoriesAdapter.notifyDataSetChanged();
                    }
                });

            }
        });
    }

    void updateData(){
        fetchData();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_refresh :
                swipeRefreshLayout.setRefreshing(true);

                updateData();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
