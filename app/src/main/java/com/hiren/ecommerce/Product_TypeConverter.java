package com.hiren.ecommerce;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;
import java.util.Locale;

public class Product_TypeConverter extends TypeConverter<String, List<Product_>> {


    @Override
    public String getDBValue(List<Product_> model) {
        if(model != null) {
            Gson gson = new Gson();
            return gson.toJson(model);
        }
        else
            return "";
    }

    @Override
    public List<Product_> getModelValue(String data) {
        Gson gson = new Gson();
        List<Product_> products = gson.fromJson(data, new TypeToken<List<Product_>>(){}.getType());
        return products;
    }


}
