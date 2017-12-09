
package com.hiren.ecommerce.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hiren.ecommerce.ProductDatabase;
import com.hiren.ecommerce.TypeConverters.CategoryTypeConverter;
import com.hiren.ecommerce.TypeConverters.RankingTypeConverter;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = ProductDatabase.class)
public class ProductModel extends BaseModel {

    @PrimaryKey
    @Column
    private int id = 1;

    @SerializedName("categories")
    @Expose
    @Column(typeConverter = CategoryTypeConverter.class)
    private List<Category> categories = null;
    @SerializedName("rankings")
    @Column(typeConverter = RankingTypeConverter.class)
    @Expose
    private List<Ranking> rankings = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

}
