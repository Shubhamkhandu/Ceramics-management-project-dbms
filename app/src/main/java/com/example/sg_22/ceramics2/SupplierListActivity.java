package com.example.sg_22.ceramics2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SupplierListActivity extends AppCompatActivity {
    private RecyclerView recyclerViewSuppliers;
    private List<Suppliers> listSuppliers;
    private SupplierRecyclerAdapter supplierRecyclerAdapter;
    private DatabaseHandler databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_list);
        getSupportActionBar().setTitle("Suppliers");
        initViews();
        initObjects();

    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        recyclerViewSuppliers = (RecyclerView) findViewById(R.id.recyclerViewSuppliers);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listSuppliers = new ArrayList<>();
        supplierRecyclerAdapter = new SupplierRecyclerAdapter(listSuppliers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewSuppliers.setLayoutManager(mLayoutManager);
        recyclerViewSuppliers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewSuppliers.setHasFixedSize(true);
        recyclerViewSuppliers.setAdapter(supplierRecyclerAdapter);
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
                listSuppliers.clear();
                listSuppliers.addAll(databaseHelper.getAllSuppliers());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                supplierRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
