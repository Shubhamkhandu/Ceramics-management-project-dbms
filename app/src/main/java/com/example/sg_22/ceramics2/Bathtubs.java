package com.example.sg_22.ceramics2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Bathtubs extends AppCompatActivity{
    String  email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tub_types);
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");

        TextView tub1 = (TextView) findViewById(R.id.t1);
        tub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bathtubs.this, t1.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });


        TextView tub2 = (TextView) findViewById(R.id.t2);
        tub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bathtubs.this, t2.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });


        TextView tub3 = (TextView) findViewById(R.id.t3);
        tub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bathtubs.this, t3.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });



        TextView tub4 = (TextView) findViewById(R.id.t4);
        tub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bathtubs.this, t4.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });
    }
}
