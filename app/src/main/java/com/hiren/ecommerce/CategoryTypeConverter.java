package com.hiren.ecommerce;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;
import java.util.Locale;

public class CategoryTypeConverter extends TypeConverter<String, List<Category>> {


    @Override
    public String getDBValue(List<Category> model) {
        if(model != null) {
            Gson gson = new Gson();
            return gson.toJson(model);
        }
        else
            return "";
    }

    @Override
    public List<Category> getModelValue(String data) {
        Gson gson = new Gson();
        List<Category> categories = gson.fromJson(data, new TypeToken<List<Category>>(){}.getType());
        return categories;
    }


}
