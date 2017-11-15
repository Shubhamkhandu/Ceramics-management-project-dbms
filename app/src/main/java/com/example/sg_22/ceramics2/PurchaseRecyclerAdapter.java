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

public class PurchaseRecyclerAdapter extends RecyclerView.Adapter<PurchaseRecyclerAdapter.UserViewHolder> {
    private List<Purchase> listPurchase;
    DatabaseHandler db;

    public PurchaseRecyclerAdapter(List<Purchase> listPurchase) {
        this.listPurchase = listPurchase;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_purchase_recycler, parent, false);
        db = new DatabaseHandler(itemView.getContext(), null, null, 1);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewPurchaseID.setText(Integer.toString(listPurchase.get(position).get_purchase_id()));
        String i = db.getpname(listPurchase.get(position).get_pid());
        holder.textViewPID.setText(i);
        String j = db.getsname(listPurchase.get(position).get_sid());
        holder.textViewSID.setText(j);
    }

    @Override
    public int getItemCount() {
        Log.v(CustomerRecyclerAdapter.class.getSimpleName(),""+listPurchase.size());
        return listPurchase.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewPurchaseID;
        public AppCompatTextView textViewPID;
        public AppCompatTextView textViewSID;

        public UserViewHolder(View view) {
            super(view);
            textViewPurchaseID = (AppCompatTextView) view.findViewById(R.id.textViewPurchaseID);
            textViewPID = (AppCompatTextView) view.findViewById(R.id.textViewPurName);
            textViewSID = (AppCompatTextView) view.findViewById(R.id.textViewPurSu);
        }
    }

}
