package com.hiren.ecommerce;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class CategoriesAdapter extends RecyclerView.Adapter {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
