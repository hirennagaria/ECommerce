package com.hiren.ecommerce;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;
import java.util.Locale;

public class VariantTypeConverter extends TypeConverter<String, List<Variant>> {


    @Override
    public String getDBValue(List<Variant> model) {
        if(model != null) {
            Gson gson = new Gson();
            return gson.toJson(model);
        }
        else
            return "";
    }

    @Override
    public List<Variant> getModelValue(String data) {
        Gson gson = new Gson();
        List<Variant> variants = gson.fromJson(data, new TypeToken<List<Variant>>(){}.getType());
        return variants;
    }


}
