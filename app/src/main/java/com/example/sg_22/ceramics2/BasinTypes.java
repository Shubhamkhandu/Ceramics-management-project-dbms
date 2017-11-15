package com.example.sg_22.ceramics2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BasinTypes extends AppCompatActivity {
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basin_types);
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        TextView basin1 = (TextView) findViewById(R.id.b1);
        basin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BasinTypes.this, b1.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView basin2 = (TextView) findViewById(R.id.b2);
        basin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BasinTypes.this, b2.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView basin3 = (TextView) findViewById(R.id.b3);
        basin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BasinTypes.this, b3.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView basin4 = (TextView) findViewById(R.id.b4);
        basin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BasinTypes.this, b4.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView basin5 = (TextView) findViewById(R.id.b5);
        basin5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BasinTypes.this, b5.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView basin6 = (TextView) findViewById(R.id.b6);
        basin6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BasinTypes.this, b6.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

    }
}
