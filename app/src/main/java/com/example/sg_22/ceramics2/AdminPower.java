package com.example.sg_22.ceramics2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminPower extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_power);

        TextView p1 = (TextView) findViewById(R.id.p1);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, AddProduct.class);
                startActivity(i);
            }
        });

        TextView p2 = (TextView) findViewById(R.id.p2);
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, DeleteProduct.class);
                startActivity(i);
            }
        });

        TextView p3 = (TextView) findViewById(R.id.p3);
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, UsersListActivity.class);
                startActivity(i);
            }
        });

        TextView p4 = (TextView) findViewById(R.id.p4);
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, UpdateProducts.class);
                startActivity(i);
            }
        });

        TextView cu1 = (TextView) findViewById(R.id.cu1);
        cu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, CustomerListActivity.class);
                startActivity(i);
            }
        });
        TextView cu2 = (TextView) findViewById(R.id.cu2);
        cu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, OrderListActivity.class);
                startActivity(i);
            }
        });

        TextView s1 = (TextView) findViewById(R.id.s1);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, AddSupplier.class);
                startActivity(i);
            }
        });
        TextView s2 = (TextView) findViewById(R.id.s2);
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, DeleteSupplier.class);
                startActivity(i);
            }
        });
        TextView s3 = (TextView) findViewById(R.id.s3);
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, SupplierListActivity.class);
                startActivity(i);
            }
        });
        TextView s4 = (TextView) findViewById(R.id.s4);
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, PurchaseListActivity.class);
                startActivity(i);
            }
        });

        Button l = (Button) findViewById(R.id.logout);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPower.this, AdminLogin.class);
                startActivity(i);
            }
        });
    }
}
