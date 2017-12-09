
package com.hiren.ecommerce;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

@Table(database = ProductDatabase.class)
public class Ranking {

    @SerializedName("ranking")
    @Expose
    @Column
    @PrimaryKey
    private String ranking;
    @SerializedName("products")
    @Expose
    @Column(typeConverter = Product_TypeConverter.class)
    private List<Product_> products = null;

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public List<Product_> getProducts() {
        return products;
    }

    public void setProducts(List<Product_> products) {
        this.products = products;
    }

}
