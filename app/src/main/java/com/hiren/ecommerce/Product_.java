
package com.hiren.ecommerce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

@Table(database = ProductDatabase.class)
public class Product_ {

    @SerializedName("id")
    @Expose
    @Column
    @PrimaryKey
    private Integer id;
    @SerializedName("view_count")
    @Expose
    @Column
    private Integer viewCount;
    @SerializedName("order_count")
    @Expose
    @Column
    private Integer orderCount;
    @SerializedName("shares")
    @Expose
    @Column
    private Integer shares;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

}
