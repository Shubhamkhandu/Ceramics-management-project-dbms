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

public class SupplierRecyclerAdapter extends RecyclerView.Adapter<SupplierRecyclerAdapter.UserViewHolder> {
    private List<Suppliers> listSuppliers;

    public SupplierRecyclerAdapter(List<Suppliers> listSuppliers) {
        this.listSuppliers = listSuppliers;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_supplier_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewSName.setText(listSuppliers.get(position).get_supplier_name());
        holder.textViewSEmail.setText(listSuppliers.get(position).get_supplier_email());
        holder.textViewSAddress.setText((listSuppliers.get(position).get_supplier_address()));
        holder.textViewSContact.setText((listSuppliers.get(position).get_supplier_contact()));
    }

    @Override
    public int getItemCount() {
        Log.v(SupplierRecyclerAdapter.class.getSimpleName(),""+listSuppliers.size());
        return listSuppliers.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewSName;
        public AppCompatTextView textViewSEmail;
        public AppCompatTextView textViewSContact;
        public AppCompatTextView textViewSAddress;

        public UserViewHolder(View view) {
            super(view);
            textViewSName = (AppCompatTextView) view.findViewById(R.id.textViewSName);
            textViewSEmail = (AppCompatTextView) view.findViewById(R.id.textViewSEmail);
            textViewSAddress = (AppCompatTextView) view.findViewById(R.id.textViewSAddress);
            textViewSContact = (AppCompatTextView) view.findViewById(R.id.textViewSContact);
        }
    }

}
