package com.techsolutions.appgrade.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.techsolutions.appgrade.R;

/**
 * Created by Udi on 6/10/2017.
 */

public class SplashActivity extends Activity{

    private boolean isRegistered;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        // TODO: Yuval - need to do if statement to check if user is registered in sharedPref - if yes set isRegistered = true
        SetUpLastVersinAndUpdates setUpApplication = new SetUpLastVersinAndUpdates();
        setUpApplication.execute();

        //this.context = getApplicationContext();
    }

    class SetUpLastVersinAndUpdates extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // TODO: DB request to get the last version - need to think what about the first time connection

            // TODO: DB request to getAllCourses - need to check if sqlite contain different courses from db and if yes - update the sqlite

            // MeanWhile perform thread sleep in order it to look like in progress
            try{
                Thread.sleep(4000);
            }catch (Exception e){ e.printStackTrace();
           }

       return null;
        }

        protected void onPostExecute(Void result) {

            Intent intent;
            if (!isRegistered) {
                intent = new Intent("com.techsolutions.appgrade.FIRSTACTIVITY");
            } else {
                intent = new Intent("com.techsolutions.appgrade.PROFILEACTIVITY");
            }
            startActivity(intent);
        }

    }
}
