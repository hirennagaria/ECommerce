package com.hiren.ecommerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hiren.ecommerce.Models.Category;
import com.hiren.ecommerce.Models.Category_Table;
import com.hiren.ecommerce.Models.Product;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import static com.hiren.ecommerce.MainActivity.CATEGORYID;

public class ProductListActivity extends AppCompatActivity {

    List<Product> products;
    List<Category> categories;
    RecyclerView productsRV;
    ProductsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        productsRV = (RecyclerView) findViewById(R.id.productListRV);

        Intent intent = getIntent();
        if(intent != null) {
            int catId = intent.getIntExtra(CATEGORYID, 0);

            categories = new ArrayList<>();

            categories = SQLite.select()
                    .from(Category.class)
                    .where(Category_Table.id.is(catId))
                    .queryList();


            if(categories.size() == 1){
                products = categories.get(0).getProducts();

                adapter = new ProductsAdapter(products);
                productsRV.setAdapter(adapter);
            }
        }
    }
}
