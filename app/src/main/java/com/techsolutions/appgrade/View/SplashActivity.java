package com.techsolutions.appgrade.View;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.techsolutions.appgrade.Logic.DataController;
import com.techsolutions.appgrade.Model.ThisUser;
import com.techsolutions.appgrade.R;

/**
 * Created by Udi on 6/10/2017.
 */

public class SplashActivity extends Activity{

    private ProgressBar progressBar;
    private DataController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        //For debug - delete shred preferences
        //getApplicationContext().getSharedPreferences("StudentSharedPref", 0).edit().clear().commit();

        //Initialize DataController with context
        controller = DataController.Instance(getApplicationContext());

        /** For debug - Initialize shared pref data*/
//        controller.getSharedPref().setAge(30);
//        controller.getSharedPref().setName("udi valer");
//        controller.getSharedPref().setEmail("udi.valer@gmail.com");
//        controller.getSharedPref().setPhoneNum("050-6963363");
//        controller.getSharedPref().setRealm("computer");
        controller.getSharedPref().setIsRegister(false); // To ignore the fact that user already register

        // TODO: Yuval - need to do if statement to check if user is registered in sharedPref - if yes set isRegistered = true
        SyncVersionAndUpdates setUpApplication = new SyncVersionAndUpdates();
        setUpApplication.execute();

    }

    class SyncVersionAndUpdates extends AsyncTask<Void, Void, Void> {

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
            if (ThisUser.getInstance().IsRegister()) {
                intent = new Intent("com.techsolutions.appgrade.PROFILEACTIVITY");
            } else {
                intent = new Intent("com.techsolutions.appgrade.FIRSTACTIVITY");
            }
            startActivity(intent);
        }

    }
}
