package com.example.sg_22.ceramics2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/**
 * Created by SG-22 on 11/7/2017.
 */

public class MyDialog extends Dialog implements View.OnClickListener {

    Button b1, b2;
    int position;
    int proID;
    int price;
    String name;
    String cusemail;
    AppCompatTextView t1;
    TextInputEditText quan;
    int i;

    public MyDialog(@NonNull Context context, String name, String cusemail, int proID, int price, int position) {
        super(context);
        this.position = position;
        this.proID = proID;
        this.price = price;
        this.name = name;
        this.cusemail = cusemail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_box_order);
        b1 = (Button)findViewById(R.id.dialog_add);
        b2 = (Button)findViewById(R.id.dialog_close);
        t1 = (AppCompatTextView) findViewById(R.id.dialog_name);
        t1.setText(name);
        quan = (TextInputEditText) findViewById(R.id.dialog_quantity);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = Integer.parseInt(quan.getText().toString());
                if(i != 0) {
                    DatabaseHandler db = new DatabaseHandler(getContext(), null, null, 1);
                    int TotalPrice = i*price;
                    int k = db.updateQuantity(proID, i);
                    if(k == -5) {
                        Toast.makeText(getContext(), "This Much Quantity Not Available", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    db.addOrder(cusemail, proID, i, TotalPrice);
                    Toast.makeText(getContext(), "Added To Cart", Toast.LENGTH_SHORT).show();
                }
                dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
