package com.example.sg_22.ceramics2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Products> listUsers;
    private RecyclerView recyclerViews;
    private RecyclerAdapter recyclerAdapter;
    private DatabaseHandler databaseHelper;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseHelper = new DatabaseHandler(this, null, null, 1);
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        recyclerViews = (RecyclerView) findViewById(R.id.recyclerViews);
        initObjects(email);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        TextView tv1, tv2;
        tv1 = (TextView) headerView.findViewById(R.id.tv_username);
        tv2 = (TextView) headerView.findViewById(R.id.tv_email);

        String name = databaseHelper.getUser(email);
        tv1.setText(name);
        tv2.setText(email);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cart) {
            Intent i = new Intent(MainActivity.this, CartListActivity.class);
            i.putExtra("email", email);
            startActivity(i);
        } else if (id == R.id.nav_logout) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_tiles) {
            Intent i = new Intent(MainActivity.this, TilesType.class);
            i.putExtra("email", email);
            startActivity(i);
        } else if (id == R.id.nav_basins) {
            Intent i = new Intent(MainActivity.this, BasinTypes.class);
            i.putExtra("email", email);
            startActivity(i);
        } else if (id == R.id.nav_pipes) {
            Intent i = new Intent(MainActivity.this, Pipes.class);
            i.putExtra("email", email);
            startActivity(i);
        }else if (id == R.id.nav_tanks) {
            Intent i = new Intent(MainActivity.this, Tanks.class);
            i.putExtra("email", email);
            startActivity(i);
        }else if (id == R.id.nav_showers) {
            Intent i = new Intent(MainActivity.this, ShowerTypes.class);
            i.putExtra("email", email);
            startActivity(i);
        }else if (id == R.id.nav_tub) {
            Intent i = new Intent(MainActivity.this, Bathtubs.class);
            i.putExtra("email", email);
            startActivity(i);
        }else if (id == R.id.nav_flush) {
            Intent i = new Intent(MainActivity.this, FlusTypes.class);
            i.putExtra("email", email);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void initObjects(String email) {
        listUsers = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(listUsers, email);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViews.setLayoutManager(mLayoutManager);
        recyclerViews.setItemAnimator(new DefaultItemAnimator());
        recyclerViews.setHasFixedSize(true);
        recyclerViews.setAdapter(recyclerAdapter);
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
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllProducts());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                recyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

}
