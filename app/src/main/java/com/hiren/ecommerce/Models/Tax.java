
package com.hiren.ecommerce.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hiren.ecommerce.ProductDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

@Table(database = ProductDatabase.class)
public class Tax {

    @SerializedName("id")
    @Expose
    @Column
    @PrimaryKey(autoincrement = true)
    private int id;
    @SerializedName("name")
    @Expose
    @Column
    private String name;
    @SerializedName("value")
    @Expose
    @Column
    private float value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

}
