package com.example.sg_22.ceramics2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import java.util.List;

/**
 * Created by SG-22 on 11/4/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.UserViewHolder> {
    private List<Products> listProducts;
    private String email;
    DatabaseHandler databaseHandler;

    public RecyclerAdapter(List<Products> listProducts, String email) {
        this.listProducts = listProducts;
        this.email = email;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);
        databaseHandler = new DatabaseHandler(itemView.getContext(), null, null, 1);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int position) {
        holder.textViewProductName.setText(listProducts.get(position).get_product_name());
        holder.textViewProductType.setText(listProducts.get(position).get_product_type());
        holder.textViewBrand.setText(listProducts.get(position).get_brand());
        holder.textViewPrice.setText(Integer.toString(listProducts.get(position).get_price()));
        holder.textViewQuantity.setText(Integer.toString(listProducts.get(position).get_quantity()));
        RecyclerAdapter adapter = new RecyclerAdapter(listProducts, email);
        View.OnClickListener clickCard = new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                MyDialog myDialog = new MyDialog(view.getContext(), listProducts.get(position).get_product_name(), email, listProducts.get(position).get_product_id(), listProducts.get(position).get_price(), position);
                myDialog.setTitle("Add To Cart");
                myDialog.show();
                Window window = myDialog.getWindow();
                window.setLayout(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);

                myDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        //Toast.makeText(view.getContext(), String.valueOf(databaseHandler.getQuantityFromProductID(listProducts.get(position).get_product_id())), Toast.LENGTH_SHORT).show();
                        holder.textViewQuantity.setText(String.valueOf(databaseHandler.getQuantityFromProductID(listProducts.get(position).get_product_id())));
                        if(databaseHandler.getQuantityFromProductID(listProducts.get(position).get_product_id()) == 0){
                            removeItem(position);
                        }
                    }
                });
            }
        };
        holder.cv1.setOnClickListener(clickCard);


    }

    @Override
    public int getItemCount() {
        Log.v(RecyclerAdapter.class.getSimpleName(),""+listProducts.size());
        return listProducts.size();
    }

    public void removeItem(int position){
        listProducts.remove(position);
        this.notifyDataSetChanged();
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
        CardView cv1;

        public UserViewHolder(View view) {
            super(view);
            textViewProductName = (AppCompatTextView) view.findViewById(R.id.textViewProductName);
            textViewProductType = (AppCompatTextView) view.findViewById(R.id.textViewProductType);
            textViewBrand = (AppCompatTextView) view.findViewById(R.id.textViewBrandname);
            textViewPrice = (AppCompatTextView) view.findViewById(R.id.textViewPrice);
            textViewQuantity = (AppCompatTextView) view.findViewById(R.id.textViewQuantity);
            cv1 = (CardView) view.findViewById(R.id.iur_cv_card);
        }

    }

}
