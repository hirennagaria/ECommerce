package com.hiren.ecommerce;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hiren.ecommerce.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        products = new ArrayList<>();
    }
}
