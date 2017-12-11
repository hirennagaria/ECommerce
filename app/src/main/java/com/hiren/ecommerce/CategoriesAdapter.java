package com.hiren.ecommerce;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hiren.ecommerce.Models.Category;

import java.util.ArrayList;


public class CategoriesAdapter extends RecyclerView.Adapter {

    private ArrayList<Category> categories;

    public CategoriesAdapter(ArrayList<Category> data) {
        this.categories = data;
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;

        public CategoriesViewHolder(View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.category_name);

        }

        public TextView getTextView() {
            return textView;
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_view, parent, false);

        CategoriesViewHolder viewHolder = new CategoriesViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        TextView cat_name = ((CategoriesViewHolder) holder).getTextView();

        cat_name.setText(categories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
