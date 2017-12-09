
package com.hiren.ecommerce;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

@Table(database = ProductDatabase.class)
public class Product {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    @Column
    private Integer id;
    @SerializedName("name")
    @Expose
    @Column
    private String name;
    @SerializedName("date_added")
    @Expose
    @Column
    private String dateAdded;
    @SerializedName("variants")
    @Expose
    @Column(typeConverter = VariantTypeConverter.class)
    private List<Variant> variants = null;
    @SerializedName("tax")
    @Expose
    @Column(typeConverter = TaxTypeConverter.class)
    private Tax tax;

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

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

}
