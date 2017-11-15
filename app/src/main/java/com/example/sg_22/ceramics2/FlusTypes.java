package com.example.sg_22.ceramics2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class FlusTypes extends AppCompatActivity {
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flus_types);
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        TextView flush1 = (TextView) findViewById(R.id.f1);
        flush1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FlusTypes.this, f1.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });


        TextView flush2 = (TextView) findViewById(R.id.f2);
        flush2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FlusTypes.this, f2.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });


        TextView flush3 = (TextView) findViewById(R.id.f3);
        flush3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FlusTypes.this, f3.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });


        TextView flush4 = (TextView) findViewById(R.id.f4);
        flush4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FlusTypes.this, f4.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });


    }
}
