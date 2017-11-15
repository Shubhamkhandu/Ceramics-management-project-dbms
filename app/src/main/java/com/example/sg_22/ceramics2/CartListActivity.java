package com.example.sg_22.ceramics2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SG-22 on 11/4/2017.
 */

public class CartListActivity extends AppCompatActivity {
    private RecyclerView recyclerViewOrders;
    private List<Orders> listOrders;
    private CartRecyclerAdapter cartRecyclerAdapter;
    private DatabaseHandler databaseHelper;
    String email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        getSupportActionBar().setTitle("My Cart");
        initViews();
        initObjects();

    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        recyclerViewOrders = (RecyclerView) findViewById(R.id.recyclerViewCart);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listOrders = new ArrayList<>();
        cartRecyclerAdapter = new CartRecyclerAdapter(listOrders);
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewOrders.setLayoutManager(mLayoutManager);
        recyclerViewOrders.setItemAnimator(new DefaultItemAnimator());
        recyclerViewOrders.setHasFixedSize(true);
        recyclerViewOrders.setAdapter(cartRecyclerAdapter);
        databaseHelper = new DatabaseHandler(this, null, null, 1);

        getDataFromSQLite(email);
    }

    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite(final String email1) {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listOrders.clear();
                listOrders.addAll(databaseHelper.getCartOrders(email1));

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                cartRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
