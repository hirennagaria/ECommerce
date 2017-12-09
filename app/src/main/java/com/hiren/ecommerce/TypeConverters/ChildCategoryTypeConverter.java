package com.hiren.ecommerce.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;
import java.util.Locale;

public class ChildCategoryTypeConverter extends TypeConverter<String, List<Integer>> {


    @Override
    public String getDBValue(List<Integer> model) {
        if(model != null) {
            Gson gson = new Gson();
            return gson.toJson(model);
        }
        else
            return "";
    }

    @Override
    public List<Integer> getModelValue(String data) {
        Gson gson = new Gson();
        List<Integer> Integers = gson.fromJson(data, new TypeToken<List<Integer>>(){}.getType());
        return Integers;
    }


}
