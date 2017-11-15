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

public class AddSupplier extends AppCompatActivity {


    private TextInputEditText sname;
    private TextInputEditText semail;
    private TextInputEditText saddress;
    private TextInputEditText scontact;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supplier);
        db = new DatabaseHandler(this, null, null, 1);
        // Set up the login form.
        sname = (TextInputEditText) findViewById(R.id.sname);
        semail = (TextInputEditText) findViewById(R.id.semail);
        saddress = (TextInputEditText) findViewById(R.id.saddress);
        scontact = (TextInputEditText) findViewById(R.id.scontact);

        Button ADD = (Button) findViewById(R.id.sadd);
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSupplier();
                emptyField();
            }
        });


    }
    private void emptyField(){
        sname.setText(null);
        semail.setText(null);
        saddress.setText(null);
        scontact.setText(null);
    }
    public void addButtonClicked() {
        Suppliers suppliers = new Suppliers(sname.getText().toString(), semail.getText().toString(),
                saddress.getText().toString(), scontact.getText().toString());
        db.addSupplier(suppliers);

    }


    private void addSupplier() {
        // Reset errors.
        sname.setError(null);
        semail.setError(null);
        saddress.setError(null);
        scontact.setError(null);

        // Store values at the time of the login attempt.
        String sname1 = sname.getText().toString();
        String semail1 = semail.getText().toString();
        String saddress1 = saddress.getText().toString();
        String scontact1 = scontact.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(sname1)) {
            sname.setError(getString(R.string.error_field_required));
            focusView = sname;
            cancel = true;
        }
        if (TextUtils.isEmpty(semail1)) {
            semail.setError(getString(R.string.error_field_required));
            focusView = semail;
            cancel = true;
        } else if (!isEmailValid(semail1)) {
            semail.setError(getString(R.string.error_invalid_email));
            focusView = semail;
            cancel = true;
        }
        if (TextUtils.isEmpty(saddress1)) {
            saddress.setError(getString(R.string.error_field_required));
            focusView = saddress;
            cancel = true;
        }
        if (TextUtils.isEmpty(scontact1)) {
            scontact.setError(getString(R.string.error_field_required));
            focusView = scontact;
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
            Toast.makeText(this, "Supplier Added", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmailValid(String email1) {
        //TODO: Replace this with your own logic
        return email1.contains("@") && email1.contains(".");
    }

}
