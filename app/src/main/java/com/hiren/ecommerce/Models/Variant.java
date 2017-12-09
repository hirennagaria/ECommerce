
package com.hiren.ecommerce.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hiren.ecommerce.ProductDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

@Table(database = ProductDatabase.class)
public class Variant {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    @Column
    private Integer id;
    @SerializedName("color")
    @Expose
    @Column
    private String color;
    @SerializedName("size")
    @Expose
    @Column
    private String size;
    @SerializedName("price")
    @Expose
    @Column
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
