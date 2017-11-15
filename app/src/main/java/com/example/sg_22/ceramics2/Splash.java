package com.example.sg_22.ceramics2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by SG-22 on 10/25/2017.
 */

public class Splash extends Activity {

    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        databaseHandler = new DatabaseHandler(this, null, null, 1);
        databaseHandler.InsertInitialValues();
        databaseHandler.InsertInitialValu();

        Thread timerThread = new Thread() {
            public void run() {
                try{
                    sleep(1200);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(Splash.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
        }

        @Override
        protected void onPause() {
            super.onPause();
            finish();
        }
}

