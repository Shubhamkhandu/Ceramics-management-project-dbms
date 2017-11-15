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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup1 extends AppCompatActivity {

    private TextInputEditText fname;
    private TextInputEditText lname;
    private TextInputEditText emailid;
    private TextInputEditText password;
    private TextInputEditText cpassword;
    private TextInputEditText address;
    private TextInputEditText city;
    private TextInputEditText state;
    private TextInputEditText country;
    private TextInputEditText pincode;
    private TextInputEditText contact;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        db = new DatabaseHandler(this, null, null, 1);
        // Set up the login form.
        fname = (TextInputEditText) findViewById(R.id.fn);
        lname = (TextInputEditText) findViewById(R.id.ln);
        emailid = (TextInputEditText) findViewById(R.id.ema);
        password = (TextInputEditText) findViewById(R.id.pass);
        cpassword = (TextInputEditText) findViewById(R.id.cpass);
        address = (TextInputEditText) findViewById(R.id.add);
        city = (TextInputEditText) findViewById(R.id.city);
        state = (TextInputEditText) findViewById(R.id.state);
        country = (TextInputEditText) findViewById(R.id.countary);
        pincode = (TextInputEditText) findViewById(R.id.pin);
        contact = (TextInputEditText) findViewById(R.id.contact);

        Button Already = (Button) findViewById(R.id.already);
        Already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alre();
            }
        });

        fname.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptSignup();
                    return true;
                }
                return false;
            }
        });

        Button SignUpButton = (Button) findViewById(R.id.sign_up_button);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSignup();
            }
        });

    }

    public void addButtonClicked() {
        Customers customers = new Customers(fname.getText().toString(), lname.getText().toString(),
                emailid.getText().toString(),contact.getText().toString(), address.getText().toString(),
                city.getText().toString(), state.getText().toString(), country.getText().toString(), pincode.getText().toString());
        db.addCustomer(customers);

        Users users = new Users(emailid.getText().toString(), password.getText().toString());
        db.addUser(users);
    }

    private void alre() {
        Intent i = new Intent(Signup1.this, LoginActivity.class);
        startActivity(i);
    }

    private void attemptSignup() {
        // Reset errors.
        fname.setError(null);
        lname.setError(null);
        emailid.setError(null);
        password.setError(null);
        cpassword.setError(null);
        address.setError(null);
        city.setError(null);
        state.setError(null);
        country.setError(null);
        pincode.setError(null);
        contact.setError(null);

        // Store values at the time of the login attempt.
        String fname1 = fname.getText().toString();
        String lname1 = lname.getText().toString();
        String email1 = emailid.getText().toString();
        String password1 = password.getText().toString();
        String cpassword1 = cpassword.getText().toString();
        String address1 = address.getText().toString();
        String city1 = city.getText().toString();
        String state1 = state.getText().toString();
        String country1 = country.getText().toString();
        String pincode1 = pincode.getText().toString();
        String contact1 = contact.getText().toString();

        boolean cancel = false;
        View focusView = null;
        boolean flag = false;

        // Check for a valid email address.
        if (TextUtils.isEmpty(email1)) {
            emailid.setError(getString(R.string.error_field_required));
            focusView = emailid;
            cancel = true;
        } else if (!isEmailValid(email1)) {
            emailid.setError(getString(R.string.error_invalid_email));
            focusView = emailid;
            cancel = true;
        }
        if (TextUtils.isEmpty(password1)) {
            password.setError(getString(R.string.error_field_required));
            focusView = password;
            cancel = true;
        } else if (!isPasswordValid(password1)) {
            password.setError(getString(R.string.error_invalid_password));
            focusView = password;
            cancel = true;
        }
        if (TextUtils.isEmpty(cpassword1)) {
            cpassword.setError(getString(R.string.error_field_required));
            focusView = cpassword;
            cancel = true;
        } else if (!isCPasswordValid(cpassword1, password1)) {
            cpassword.setError(getString(R.string.error_unmatched_password));
            focusView = cpassword;
            cancel = true;
            flag = true;
        }
        if (TextUtils.isEmpty(fname1)) {
            fname.setError(getString(R.string.error_field_required));
            focusView = fname;
            cancel = true;
        }
        if (TextUtils.isEmpty(lname1)) {
            lname.setError(getString(R.string.error_field_required));
            focusView = lname;
            cancel = true;
        }
        if (TextUtils.isEmpty(address1)) {
            address.setError(getString(R.string.error_field_required));
            focusView = address;
            cancel = true;
        }
        if (TextUtils.isEmpty(city1)) {
            city.setError(getString(R.string.error_field_required));
            focusView = city;
            cancel = true;
        }
        if (TextUtils.isEmpty(state1)) {
            state.setError(getString(R.string.error_field_required));
            focusView = state;
            cancel = true;
        }
        if (TextUtils.isEmpty(country1)) {
            country.setError(getString(R.string.error_field_required));
            focusView = country;
            cancel = true;
        }
        if (TextUtils.isEmpty(pincode1)) {
            pincode.setError(getString(R.string.error_field_required));
            focusView = pincode;
            cancel = true;
        }
        if (TextUtils.isEmpty(contact1)) {
            contact.setError(getString(R.string.error_field_required));
            focusView = contact;
            cancel = true;
        }else if(!isContactValid(contact1)) {
            contact.setError(getString(R.string.error_field_contact));
            focusView = contact;
            cancel = true;
        }


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            if(flag == true) {
                cpassword.setText(null);
            }
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //showProgress(true);
            addButtonClicked();
            Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Signup1.this, LoginActivity.class);
            startActivity(i);
        }
    }


    private boolean isEmailValid(String email1) {
        //TODO: Replace this with your own logic
        return email1.contains("@") && email1.contains(".");
    }

    private boolean isContactValid(String contact1) {
        //TODO: Replace this with your own logic
        return contact1.length() == 10;
    }

    private boolean isPasswordValid(String password1) {
        //TODO: Replace this with your own logic
        return password1.length() > 4;
    }

    private boolean isCPasswordValid(String cpassword1, String password1) {
        //TODO: Replace this with your own logic
        return cpassword1.equals(password1);
    }

}