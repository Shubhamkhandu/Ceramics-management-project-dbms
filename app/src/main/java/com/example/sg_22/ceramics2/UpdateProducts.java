package com.example.sg_22.ceramics2;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class UpdateProducts extends AppCompatActivity {

    private TextInputEditText pname;
    private Spinner ptypeu;
    private TextInputEditText price;
    private TextInputEditText quantity;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_products);
        db = new DatabaseHandler(this, null, null, 1);
        // Set up the login form.
        pname = (TextInputEditText) findViewById(R.id.pnameu);
        ptypeu = (Spinner) findViewById(R.id.ptypeu);
        String [] product_types = {"Floor Tiles", "Glazed Vitrified Tiles", "Paving Tiles", "Polished Vitrified Tiles", "Roofing Tiles"
                ,"Wall Tiles", "Colored Ceramic Basin", "Marbel Basin", "Resin Washbasin", "Wall Mounted Basin"
                ,"Table Mounted Basin", "Wooden Basin", "Pipes & Fittings", "Tanks", "Digital Shower", "Electric Shower"
                ,"Mixer Shower", "Power Shower", "Pillar Taps", "Mixer Taps", "Long Handle Taps","Thermostatic Taps"
                ,"Alcove Bathtub", "Drop-In Bathtub", "Corner Bathtub", "Free-Standing Bathtub","Duel FLush"
                ,"Double Cyclone Flush","Gravity Flush","Pressure Assisted Flush"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,product_types);
        ptypeu.setAdapter(adapter);
        price = (TextInputEditText) findViewById(R.id.priceu);
        quantity = (TextInputEditText) findViewById(R.id.quantityu);

        Button ADD = (Button) findViewById(R.id.upp1);
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePro();
                emptyField();
            }
        });


    }
    private void emptyField(){
        pname.setText(null);
        price.setText(null);
        quantity.setText(null);
    }
    public int updateButtonClicked() {
        int i = db.updateProducts(pname.getText().toString(), ptypeu.getSelectedItem().toString(),
                Integer.parseInt(price.getText().toString()), Integer.parseInt(quantity.getText().toString()));
        return i;
    }


    private void updatePro() {
        // Reset errors.
        pname.setError(null);
        price.setError(null);
        quantity.setError(null);

        // Store values at the time of the login attempt.
        String pname1 = pname.getText().toString();
        String price1 = price.getText().toString();
        String quantity1 = quantity.getText().toString();

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


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //showProgress(true);
            int i = updateButtonClicked();
            if (i == 0) {
                Toast.makeText(this, "Product Not Found", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Product Updated", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
