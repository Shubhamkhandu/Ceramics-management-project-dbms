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

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.UserViewHolder> {
    private List<Orders> listOrders;

    public OrderRecyclerAdapter(List<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewOrderID.setText(Integer.toString(listOrders.get(position).get_order_id()));
        holder.textViewCName.setText(listOrders.get(position).get_customer_name());
        holder.textViewCEmail.setText(listOrders.get(position).get_cusemail());
        holder.textViewPName.setText(listOrders.get(position).get_product_name());
        holder.textViewPQuantity.setText(Integer.toString(listOrders.get(position).get_quantity()));
        holder.textViewTotalPrice.setText(Integer.toString(listOrders.get(position).get_total_price()));
    }

    @Override
    public int getItemCount() {
        Log.v(CustomerRecyclerAdapter.class.getSimpleName(),""+listOrders.size());
        return listOrders.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewOrderID;
        public AppCompatTextView textViewCName;
        public AppCompatTextView textViewCEmail;
        public AppCompatTextView textViewPName;
        public AppCompatTextView textViewPQuantity;
        public AppCompatTextView textViewTotalPrice;


        public UserViewHolder(View view) {
            super(view);
            textViewOrderID = (AppCompatTextView) view.findViewById(R.id.textViewOrderID);
            textViewCName = (AppCompatTextView) view.findViewById(R.id.textViewCName);
            textViewCEmail = (AppCompatTextView) view.findViewById(R.id.textViewCEmail);
            textViewPName = (AppCompatTextView) view.findViewById(R.id.textViewPName);
            textViewPQuantity = (AppCompatTextView) view.findViewById(R.id.textViewPQuantity);
            textViewTotalPrice = (AppCompatTextView) view.findViewById(R.id.textViewTotalPrice);
        }
    }

}
