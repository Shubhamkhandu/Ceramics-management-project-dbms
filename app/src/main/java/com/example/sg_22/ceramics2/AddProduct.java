package com.example.sg_22.ceramics2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    private TextInputEditText pname;
    Spinner ptype;
    private TextInputEditText price;
    Spinner brand;
    private TextInputEditText quantity;
    private TextInputEditText suppname;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        db = new DatabaseHandler(this, null, null, 1);
        // Set up the login form.
        pname = (TextInputEditText) findViewById(R.id.pname);
        ptype = (Spinner) findViewById(R.id.ptype);
        String [] product_types = {"Floor Tiles", "Glazed Vitrified Tiles", "Paving Tiles", "Polished Vitrified Tiles", "Roofing Tiles"
                ,"Wall Tiles", "Colored Ceramic Basin", "Marbel Basin", "Resin Washbasin", "Wall Mounted Basin"
                ,"Table Mounted Basin", "Wooden Basin", "Pipes & Fittings", "Tanks", "Digital Shower", "Electric Shower"
                ,"Mixer Shower", "Power Shower", "Pillar Taps", "Mixer Taps", "Long Handle Taps","Thermostatic Taps"
                ,"Alcove Bathtub", "Drop-In Bathtub", "Corner Bathtub", "Free-Standing Bathtub","Duel FLush"
                ,"Double Cyclone Flush","Gravity Flush","Pressure Assisted Flush"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,product_types);
        ptype.setAdapter(adapter);
        price = (TextInputEditText) findViewById(R.id.price);
        brand = (Spinner) findViewById(R.id.brand);
        String [] Brands = {"ARK", "AGL", "Hindware", "Kohler", "Kajaria", "Jaquar", "Nitco", "Safari", "Sintex", "SWR"};
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,Brands);
        brand.setAdapter(adapter2);
        quantity = (TextInputEditText) findViewById(R.id.quantity);
        suppname = (TextInputEditText) findViewById(R.id.suppname);

        Button ADD = (Button) findViewById(R.id.add1);
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPro();
                emptyField();
            }
        });


    }
    private void emptyField(){
        pname.setText(null);
        price.setText(null);
        quantity.setText(null);
        suppname.setText(null);
    }
    public void addButtonClicked() {
        Products products = new Products(pname.getText().toString(), ptype.getSelectedItem().toString(),
                Integer.parseInt(price.getText().toString()),brand.getSelectedItem().toString(), Integer.parseInt(quantity.getText().toString()));
        db.addProducts(products);
        int i = db.getpid(pname.getText().toString(), ptype.getSelectedItem().toString());
        int j = db.getsid(suppname.getText().toString());
        Purchase purchase = new Purchase(i, j);
        db.addPurchase(purchase);
    }


    private void addPro() {
        // Reset errors.
        pname.setError(null);
        price.setError(null);
        quantity.setError(null);
        suppname.setError(null);

        // Store values at the time of the login attempt.
        String pname1 = pname.getText().toString();
        String price1 = price.getText().toString();
        String quantity1 = quantity.getText().toString();
        String suppname1 = suppname.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(pname1)) {
            pname.setError(getString(R.string.error_field_required));
            focusView = pname;
            cancel = true;
        }
        if (TextUtils.isEmpty(price1)) {
            price.setError(getString(R.string.error_field_required));
            focusView = price;
            cancel = true;
        }
        if (TextUtils.isEmpty(quantity1)) {
            quantity.setError(getString(R.string.error_field_required));
            focusView = quantity;
            cancel = true;
        }
        if (TextUtils.isEmpty(suppname1)) {
            suppname.setError(getString(R.string.error_field_required));
            focusView = suppname;
            cancel = true;
        } else if (!isSupplierValid(suppname1)) {
            suppname.setError(getString(R.string.error_field_supplier));
            focusView = suppname;
            cancel = true;
        }


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //showProgress(true);
            addButtonClicked();
            Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isSupplierValid(String suppname12) {
        int i = db.getsid(suppname12);
        if(i == -5) {
            return false;
        }
        return true;
    }
}
