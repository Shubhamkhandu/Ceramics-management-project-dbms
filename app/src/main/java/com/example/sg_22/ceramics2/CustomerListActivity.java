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

public class CustomerListActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCustomers;
    private List<Customers> listCustomers;
    private CustomerRecyclerAdapter customerRecyclerAdapter;
    private DatabaseHandler databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        getSupportActionBar().setTitle("Customers");
        initViews();
        initObjects();

    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        recyclerViewCustomers = (RecyclerView) findViewById(R.id.recyclerViewCustomers);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listCustomers = new ArrayList<>();
        customerRecyclerAdapter = new CustomerRecyclerAdapter(listCustomers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewCustomers.setLayoutManager(mLayoutManager);
        recyclerViewCustomers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCustomers.setHasFixedSize(true);
        recyclerViewCustomers.setAdapter(customerRecyclerAdapter);
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
                listCustomers.clear();
                listCustomers.addAll(databaseHelper.getAllCustomers());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                customerRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
