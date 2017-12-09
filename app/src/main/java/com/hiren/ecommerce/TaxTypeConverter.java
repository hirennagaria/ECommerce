package com.hiren.ecommerce;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;

public class TaxTypeConverter extends TypeConverter<String, Tax> {


    @Override
    public String getDBValue(Tax model) {
        if(model != null) {
            Gson gson = new Gson();
            return gson.toJson(model);
        }
        else
            return "";
    }

    @Override
    public Tax getModelValue(String data) {
        Gson gson = new Gson();
        Tax taxes = gson.fromJson(data, new TypeToken<List<Tax>>(){}.getType());
        return taxes;
    }


}
