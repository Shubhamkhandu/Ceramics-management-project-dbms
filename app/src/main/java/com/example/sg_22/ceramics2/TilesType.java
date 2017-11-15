package com.example.sg_22.ceramics2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TilesType extends AppCompatActivity {
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiles_type);
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        TextView tile1 = (TextView) findViewById(R.id.text);
        tile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TilesType.this, TilesFloor.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView tile2 = (TextView) findViewById(R.id.text1);
        tile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TilesType.this, TilesGlazed.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView tile6 = (TextView) findViewById(R.id.text2);
        tile6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TilesType.this, TilesPaving.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView tile3 = (TextView) findViewById(R.id.text4);
        tile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TilesType.this, TilesPolished.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView tile4 = (TextView) findViewById(R.id.text5);
        tile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TilesType.this, TilesRoofing.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        TextView tile5 = (TextView) findViewById(R.id.text6);
        tile5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TilesType.this, TilesWall.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });
    }
}
