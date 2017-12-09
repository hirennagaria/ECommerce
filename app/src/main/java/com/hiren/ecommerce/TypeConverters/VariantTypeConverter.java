package com.hiren.ecommerce.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hiren.ecommerce.Models.Variant;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;

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
