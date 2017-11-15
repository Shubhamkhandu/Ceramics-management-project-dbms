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

public class DeleteProduct extends AppCompatActivity {

    private TextInputEditText pnamed;
    private Spinner ptyped;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);
        db = new DatabaseHandler(this, null, null, 1);
        // Set up the login form.
        pnamed = (TextInputEditText) findViewById(R.id.pnamed);
        ptyped = (Spinner) findViewById(R.id.ptyped);
        String [] product_types = {"Floor Tiles", "Glazed Vitrified Tiles", "Paving Tiles", "Polished Vitrified Tiles", "Roofing Tiles"
                ,"Wall Tiles", "Colored Ceramic Basin", "Marbel Basin", "Resin Washbasin", "Wall Mounted Basin"
                ,"Table Mounted Basin", "Wooden Basin", "Pipes & Fittings", "Tanks", "Digital Shower", "Electric Shower"
                ,"Mixer Shower", "Power Shower", "Pillar Taps", "Mixer Taps", "Long Handle Taps","Thermostatic Taps"
                ,"Alcove Bathtub", "Drop-In Bathtub", "Corner Bathtub", "Free-Standing Bathtub","Duel FLush"
                ,"Double Cyclone Flush","Gravity Flush","Pressure Assisted Flush"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,product_types);
        ptyped.setAdapter(adapter);
        Button Delete = (Button) findViewById(R.id.del1);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPro();
                emptyField();
            }
        });


    }
    private void emptyField(){
        pnamed.setText(null);
    }
    public int deleteButtonClicked() {
        int i = db.deleteProduct(pnamed.getText().toString(), ptyped.getSelectedItem().toString());
        return i;
    }


    private void addPro() {
        // Reset errors.
        pnamed.setError(null);
        // Store values at the time of the login attempt.
        String pnamed1 = pnamed.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(pnamed1)) {
            pnamed.setError(getString(R.string.error_field_required));
            focusView = pnamed;
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
            int i = deleteButtonClicked();
            if (i == 0) {
                Toast.makeText(this, "Product Not Found", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Product Deleted", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
