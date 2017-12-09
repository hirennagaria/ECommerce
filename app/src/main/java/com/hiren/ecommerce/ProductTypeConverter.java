package com.hiren.ecommerce;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;
import java.util.Locale;

public class ProductTypeConverter extends TypeConverter<String, List<Product>> {


    @Override
    public String getDBValue(List<Product> model) {
        if(model != null) {
            Gson gson = new Gson();
            return gson.toJson(model);
        }
        else
            return "";
    }

    @Override
    public List<Product> getModelValue(String data) {
        Gson gson = new Gson();
        List<Product> products = gson.fromJson(data, new TypeToken<List<Product>>(){}.getType());
        return products;
    }


}
