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

public class PurchaseListActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPurchase;
    private List<Purchase> listPurchase;
    private PurchaseRecyclerAdapter purchaseRecyclerAdapter;
    private DatabaseHandler databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_list);
        getSupportActionBar().setTitle("Purchase List");
        initViews();
        initObjects();

    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        recyclerViewPurchase = (RecyclerView) findViewById(R.id.recyclerViewOrders);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listPurchase = new ArrayList<>();
        purchaseRecyclerAdapter = new PurchaseRecyclerAdapter(listPurchase);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewPurchase.setLayoutManager(mLayoutManager);
        recyclerViewPurchase.setItemAnimator(new DefaultItemAnimator());
        recyclerViewPurchase.setHasFixedSize(true);
        recyclerViewPurchase.setAdapter(purchaseRecyclerAdapter);
        databaseHelper = new DatabaseHandler(this, null, null, 1);

        getDataFromSQLite();
    }

    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listPurchase.clear();
                listPurchase.addAll(databaseHelper.getAllPurchase());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                purchaseRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
