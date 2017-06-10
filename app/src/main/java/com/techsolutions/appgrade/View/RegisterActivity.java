package com.techsolutions.appgrade.View;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.techsolutions.appgrade.Model.ThisUser;
import com.techsolutions.appgrade.R;

/**
 * Created by Udi on 6/6/2017.
 */

public class RegisterActivity extends Activity {

    //private Student studentForReg;
    private EditText userEmail;
    private EditText userName;
    private EditText phoneNumber;
    private EditText age;
    private TextView firstTitleText;
    private TextView secondTitleText;
    private Spinner realm;
    private Button reg;
    private LayoutInflater layoutInflater;
    private View popupView;
    private PopupWindow popupWindow;
    private Button btnDismiss;
    private View parent;
    private Boolean cameFromSearchResult = false;
    private Boolean addToMyCourses = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        parent = this.findViewById(android.R.id.content);

        firstTitleText = (TextView) findViewById(R.id.firstTitleText);
        secondTitleText = (TextView) findViewById(R.id.secondTitleText);
        userEmail = (EditText) findViewById(R.id.txtEmail);
        userName = (EditText) findViewById(R.id.txtFullName);
        phoneNumber = (EditText) findViewById(R.id.txtPhoneNumber);
        age = (EditText) findViewById(R.id.txtAge);
        realm = (Spinner) findViewById(R.id.spRealm);
        reg = (Button) findViewById(R.id.btnSignIn);

        firstTitleText.setText(R.string.RegisterActivityFirstTitleText);
        secondTitleText.setText(R.string.RegisterActivitySecondTitleText);

        ArrayAdapter<CharSequence> adapterForDeg = ArrayAdapter.createFromResource(this, R.array.spinnerarrayForDeg, android.R.layout.simple_spinner_item);
        adapterForDeg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        realm.setAdapter(adapterForDeg);

        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = layoutInflater.inflate(R.layout.register_popup, null);
        popupWindow = new PopupWindow(popupView, AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT);
        btnDismiss = (Button) popupView.findViewById(R.id.goToProfile);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RegisterActivity" , "Inside reg clicked");
                ThisUser thisUser = ThisUser.getInstance();
                Log.d("RegisterActivity" , "After initialized user");
                String resultForPopUp = thisUser.getInstance().init(getApplicationContext() ,userEmail.getText().toString() , userName.getText().toString() , phoneNumber.getText().toString()
                        , Integer.valueOf(age.getText().toString()) , realm.getSelectedItem().toString() , null);
                Log.d("RegisterActivity" , resultForPopUp);
                Log.d("RegisterActivity" , thisUser.toString());
            }
        });

        btnDismiss.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Intent nextActivity;
//                if (cameFromSearchResult) {
//                    nextActivity = new Intent("yuvallevy.finalproject_correct.MAKECONTACT");
//                    Student studentToPass = (Student) getIntent().getSerializableExtra("student");
//                    nextActivity.putExtra("student", studentToPass);
//                } else {
//                    nextActivity = new Intent("yuvallevy.finalproject_correct.REGISTEREDUSERPROFILE");
//                }
//                startActivity(nextActivity);
            }
        });


    }

//    class DBExcute extends AsyncTask<Void, Void, Void> {
//
////        @Override
////        protected Void doInBackground(Void... params) {
////            DBmanipulation myDB = new DBmanipulation();
////            myDB.insertNewStudnt(studentForReg);
////
////            //Store personal details on device shared preferences
////            MySharedPreferences mySharedPrefences = new MySharedPreferences(getApplicationContext());
////            mySharedPrefences.storePersonalDetails(studentForReg);
////            mySharedPrefences.changeRegisterUserStatus(true);
////
////            //check if new searching record exist and to myCourse List in sharedPreferences
////            if (addToMyCourses) {
////                //Get new searching record details
////                NewSearchingRecord newSearchingRecord = (NewSearchingRecord) getIntent().getSerializableExtra("searchingRecord");
////                //Add new course details to sqlite db
////                DB_SQLiteManipulation SQLiteDB = new DB_SQLiteManipulation(getApplicationContext());
////                SQLiteDB.addCourseToMyCourses(newSearchingRecord);
////                //add new searching record to server database
////                myDB.insertNewSearchingRecord(mySharedPrefences.getMyEmail(), newSearchingRecord.getSemester(), newSearchingRecord.getName(), newSearchingRecord.getPlace());
////            }
////            return null;
////        }
////
////        @Override
////        protected void onPostExecute(Void curVoid) {
////            super.onPostExecute(curVoid);
////
////            popupWindow.showAtLocation(parent, Gravity.CENTER, 50, -30);
////
////        }
    }