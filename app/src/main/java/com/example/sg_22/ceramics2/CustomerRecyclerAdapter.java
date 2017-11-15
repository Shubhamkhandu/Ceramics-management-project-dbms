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

public class CustomerRecyclerAdapter extends RecyclerView.Adapter<CustomerRecyclerAdapter.UserViewHolder> {
    private List<Customers> listCustomers;

    public CustomerRecyclerAdapter(List<Customers> listCustomers) {
        this.listCustomers = listCustomers;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_customer_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewName.setText(listCustomers.get(position).getfirstName() + " " + listCustomers.get(position).getlastName());
        holder.textViewEmail.setText(listCustomers.get(position).getemailid());
        holder.textViewContact.setText(listCustomers.get(position).getContact());
        holder.textViewAddress.setText((listCustomers.get(position).getaddress() + ", " + listCustomers.get(position).getcity() + " - " + listCustomers.get(position).getpin()));
        holder.textViewState.setText((listCustomers.get(position).getstate()));
        holder.textViewCountry.setText((listCustomers.get(position).getcountry()));
    }

    @Override
    public int getItemCount() {
        Log.v(CustomerRecyclerAdapter.class.getSimpleName(),""+listCustomers.size());
        return listCustomers.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewContact;
        public AppCompatTextView textViewAddress;
        public AppCompatTextView textViewState;
        public AppCompatTextView textViewCountry;

        public UserViewHolder(View view) {
            super(view);
            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
            textViewContact = (AppCompatTextView) view.findViewById(R.id.textViewContact);
            textViewAddress = (AppCompatTextView) view.findViewById(R.id.textViewAddress);
            textViewState = (AppCompatTextView) view.findViewById(R.id.textViewState);
            textViewCountry = (AppCompatTextView) view.findViewById(R.id.textViewCountry);
        }
    }

}
