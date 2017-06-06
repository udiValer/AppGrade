package com.techsolutions.appgrade.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.techsolutions.appgrade.R;

import java.util.ArrayList;

/**
 * Created by Udi on 6/6/2017.
 * Activity to choose the relevant City on the current search records
 * Decide if the user need to register after it or nnot
 */

public class CityActivity extends Activity {

    final Context context = this;
    private Spinner spinner;
    //private NewSearchingRecord curSearchRecord;
    private Button btnProceed;
    //private DBmanipulation myDB = new DBmanipulation();
    //private ArrayList<Student> studentsFound = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_activity);

        Intent i = getIntent();
        //curSearchRecord = (NewSearchingRecord) i.getSerializableExtra("searchingRecord");

        btnProceed = (Button) findViewById(R.id.btnProceed3);
        spinner = (Spinner) findViewById(R.id.spinnerForCity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerarrayForCity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //curSearchRecord.setPlace(spinner.getSelectedItem().toString());
                //DBExcuteForFindFast myDB = new DBExcuteForFindFast();
                //myDB.execute();

            }
        });


    }


//    class DBExcuteForFindFast extends AsyncTask<Void, Void, Integer> {
//
//        @Override
//        protected Integer doInBackground(Void... params) {
//            studentsFound = myDB.findPartnersFast(curSearchRecord.getSemester(), curSearchRecord.getName(), curSearchRecord.getPlace());
//            Integer numberOfStudentFound = studentsFound.size();
//
//            //If the user is already registered - add
//            MySharedPreferences mySharedPreferences = new MySharedPreferences(getApplicationContext());
//            if (mySharedPreferences.getIsRegistered()) {
//                myDB.insertNewSearchingRecord(mySharedPreferences.getMyEmail(), curSearchRecord.getSemester(), curSearchRecord.getName(), curSearchRecord.getPlace());
//
//                //Insert new course record to personal courses in SQLite
//                DB_SQLiteManipulation SQLiteDB = new DB_SQLiteManipulation(getApplicationContext());
//                SQLiteDB.addCourseToMyCourses(curSearchRecord);
//            }
//            return numberOfStudentFound;
//        }
//
//        @Override
//        protected void onPostExecute(final Integer numberOfStudent) {
//            super.onPostExecute(numberOfStudent);
//            if (numberOfStudent == 0) {
//                MySharedPreferences mySharedPreferences = new MySharedPreferences(getApplicationContext());
//                //No match for the current search
//                if (mySharedPreferences.getIsRegistered()) {
//                    //User already registered
//                    new AlertDialog.Builder(context)
//                            .setTitle("חיפוש שותף")
//                            .setMessage(getString(R.string.firstStudent) + "\n" + getString(R.string.firstStudentRegistered))
//                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    Intent backToProfile = new Intent("yuvallevy.finalproject_correct.REGISTEREDUSERPROFILE");
//                                    startActivity(backToProfile);
//                                }
//                            }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            // do nothing
//                        }
//                    })
//                            .setIcon(android.R.drawable.gallery_thumb)
//                            .show();
//                } else {
//                    //User not registered - 0 matches found
//                    new AlertDialog.Builder(context)
//                            .setTitle("חיפוש שותף")
//                            .setMessage(getString(R.string.firstStudent) + "\n" + getString(R.string.firstStudentNotRegistered))
//                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    Intent toRegister = new Intent("yuvallevy.finalproject_correct.REGISTER");
//                                    toRegister.putExtra("CurrentStatus", "FirstUser_NotRegister");
//                                    toRegister.putExtra("searchingRecord", curSearchRecord);
//                                    startActivity(toRegister);
//                                }
//                            }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            // do nothing
//                        }
//                    })
//                            .setIcon(android.R.drawable.gallery_thumb)
//                            .show();
//                }
//            } else {
//                //Found some other student match
//                //User already registered
//                new AlertDialog.Builder(context)
//                        .setTitle("חיפוש שותף")
//                        .setMessage(getString(R.string.NotFirstStart) + " " + numberOfStudent + " " + getString(R.string.NotFirstEnd))
//                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                Intent searchResultActivity = new Intent("yuvallevy.finalproject_correct.SEARCHRESULT");
//                                MySharedPreferences mySharedPreferences = new MySharedPreferences(getApplicationContext());
//                                if (!mySharedPreferences.getIsRegistered()) {
//                                    searchResultActivity.putExtra("searchingRecord", curSearchRecord);
//                                }
//                                searchResultActivity.putExtra("studentsFound", studentsFound);
//                                startActivity(searchResultActivity);
//                            }
//                        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // do nothing
//                    }
//                })
//                        .setIcon(android.R.drawable.gallery_thumb)
//                        .show();
//            }
//        }
    }
