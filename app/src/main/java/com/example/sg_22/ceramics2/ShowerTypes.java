package com.example.sg_22.ceramics2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ShowerTypes extends AppCompatActivity {
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower_types);
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        TextView shower1 = (TextView) findViewById(R.id.sh1);
        shower1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowerTypes.this, s1.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView shower2 = (TextView) findViewById(R.id.sh2);
        shower2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowerTypes.this, s2.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView shower3 = (TextView) findViewById(R.id.sh3);
        shower3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowerTypes.this, s3.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView shower4 = (TextView) findViewById(R.id.sh4);
        shower4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowerTypes.this, s4.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView shower5 = (TextView) findViewById(R.id.sh5);
        shower5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowerTypes.this, s5.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });
        TextView shower6 = (TextView) findViewById(R.id.sh6);
        shower6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowerTypes.this, s6.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });
        TextView shower7 = (TextView) findViewById(R.id.sh7);
        shower7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowerTypes.this, s7.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView shower8 = (TextView) findViewById(R.id.sh8);
        shower8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowerTypes.this, s8.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

    }
}