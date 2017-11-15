package com.example.sg_22.ceramics2;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by SG-22 on 11/4/2017.
 */

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {
    private List<Products> listProducts;

    public UserRecyclerAdapter(List<Products> listProducts) {
        this.listProducts = listProducts;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewProductName.setText(listProducts.get(position).get_product_name());
        holder.textViewProductType.setText(listProducts.get(position).get_product_type());
        holder.textViewBrand.setText(listProducts.get(position).get_brand());
        holder.textViewPrice.setText(Integer.toString(listProducts.get(position).get_price()));
        holder.textViewQuantity.setText(Integer.toString(listProducts.get(position).get_quantity()));
    }

    @Override
    public int getItemCount() {
        Log.v(UserRecyclerAdapter.class.getSimpleName(),""+listProducts.size());
        return listProducts.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewProductName;
        public AppCompatTextView textViewProductType;
        public AppCompatTextView textViewBrand;
        public AppCompatTextView textViewPrice;
        public AppCompatTextView textViewQuantity;

        public UserViewHolder(View view) {
            super(view);
            textViewProductName = (AppCompatTextView) view.findViewById(R.id.textViewProductName);
            textViewProductType = (AppCompatTextView) view.findViewById(R.id.textViewProductType);
            textViewBrand = (AppCompatTextView) view.findViewById(R.id.textViewBrandname);
            textViewPrice = (AppCompatTextView) view.findViewById(R.id.textViewPrice);
            textViewQuantity = (AppCompatTextView) view.findViewById(R.id.textViewQuantity);
        }
    }

}
