
package com.hiren.ecommerce.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hiren.ecommerce.ProductDatabase;
import com.hiren.ecommerce.TypeConverters.ChildCategoryTypeConverter;
import com.hiren.ecommerce.TypeConverters.ProductTypeConverter;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = ProductDatabase.class)
public class Category extends BaseModel {

    @SerializedName("id")
    @Expose
    @Column
    @PrimaryKey
    private Integer id;
    @SerializedName("name")
    @Expose
    @Column
    private String name;
    @SerializedName("products")
    @Expose
    @Column(typeConverter = ProductTypeConverter.class)
    private List<Product> products = null;
    @SerializedName("child_categories")
    @Expose
    @Column(typeConverter = ChildCategoryTypeConverter.class)
    private List<Integer> childCategories = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Integer> childCategories) {
        this.childCategories = childCategories;
    }

}
