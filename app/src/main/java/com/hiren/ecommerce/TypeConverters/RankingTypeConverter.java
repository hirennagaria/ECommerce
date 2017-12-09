package com.hiren.ecommerce.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hiren.ecommerce.Models.Ranking;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;

public class RankingTypeConverter extends TypeConverter<String, List<Ranking>> {


    @Override
    public String getDBValue(List<Ranking> model) {
        if(model != null) {
            Gson gson = new Gson();
            return gson.toJson(model);
        }
        else
            return "";
    }

    @Override
    public List<Ranking> getModelValue(String data) {
        Gson gson = new Gson();
        List<Ranking> rankings = gson.fromJson(data, new TypeToken<List<Ranking>>(){}.getType());
        return rankings;
    }


}
