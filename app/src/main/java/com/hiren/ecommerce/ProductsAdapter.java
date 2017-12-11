package com.hiren.ecommerce;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hiren.ecommerce.Models.Product;

import java.util.List;
import java.util.zip.Inflater;


public class ProductsAdapter extends RecyclerView.Adapter {
    List<Product> products;

    ProductsAdapter(List<Product> data) {
        this.products = data;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.product_title);
        }

        public TextView getProductName() {
            return productName;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_view, parent, false);

        ProductViewHolder viewHolder = new ProductViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Product product = products.get(position);

        ((ProductViewHolder) holder).getProductName().setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
