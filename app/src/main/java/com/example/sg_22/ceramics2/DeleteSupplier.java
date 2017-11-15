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

public class DeleteSupplier extends AppCompatActivity {

    private TextInputEditText snamed;
    private TextInputEditText semaild;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_supplier);
        db = new DatabaseHandler(this, null, null, 1);
        // Set up the login form.
        snamed = (TextInputEditText) findViewById(R.id.snamed);
        semaild = (TextInputEditText) findViewById(R.id.semaild);
        Button Delete = (Button) findViewById(R.id.del2);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPro();
                emptyField();
            }
        });


    }
    private void emptyField(){
        snamed.setText(null);
        semaild.setText(null);
    }
    public int deleteButtonClicked() {
        int i = db.deleteSupplier(snamed.getText().toString(), semaild.getText().toString());
        return i;
    }


    private void addPro() {
        // Reset errors.
        snamed.setError(null);
        // Store values at the time of the login attempt.
        String pnamed1 = snamed.getText().toString();
        String pemaild1 = semaild.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(pnamed1)) {
            snamed.setError(getString(R.string.error_field_required));
            focusView = snamed;
            cancel = true;
        }
        if (TextUtils.isEmpty(pemaild1)) {
            semaild.setError(getString(R.string.error_field_required));
            focusView = semaild;
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
                Toast.makeText(this, "Supplier Not Found", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Supplier Deleted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
