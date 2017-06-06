package com.techsolutions.appgrade.View;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.techsolutions.appgrade.R;

/**
 * Created by Udi on 6/6/2017.
 */

public class RegisterActivity extends Activity {

    //private Student studentForReg;
    private EditText studentEmail;
    private EditText studentName;
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
        studentEmail = (EditText) findViewById(R.id.txtEmail);
        studentName = (EditText) findViewById(R.id.txtFullName);
        phoneNumber = (EditText) findViewById(R.id.txtPhoneNumber);
        age = (EditText) findViewById(R.id.txtAge);
        realm = (Spinner) findViewById(R.id.spRealm);
        reg = (Button) findViewById(R.id.btnSignIn);

        String callerStatus = getIntent().getStringExtra("CurrentStatus");
        //Set the text title according to the activity the user arrived from
        if (callerStatus.equals("FirstUser_NotRegister")) {
            //You are the first - Enter your details
            firstTitleText.setText("תלמיד חרוץ! אתה הראשון");
            secondTitleText.setText("אנא מלא את הפרטים הבאים:\nואנו נודיע לך ברגע שנמצא עבורך סטודנט מתאים ללמוד איתו");
            addToMyCourses = true;
        } else if (callerStatus.equals("Found_Match_NotRegister")) {
            //Matches found - enter your details to contact
            firstTitleText.setText("נמצאו סטודנטים מתאימים!");
            secondTitleText.setText("אנא מלא את הפרטים הבאים כדי ליצור קשר עם הפרטנר שבחרת");
            cameFromSearchResult = true;
            addToMyCourses = true;
        } else { //Create new profile
            firstTitleText.setText("צור את פרופיל הסטודנט שלך");
            secondTitleText.setText("אנא מלא את הפרטים הבאים כדי למצוא שותפים נהדרים ללמוד איתם");
        }

        ArrayAdapter<CharSequence> adapterForDeg = ArrayAdapter.createFromResource(this, R.array.spinnerarrayForDeg, android.R.layout.simple_spinner_item);
        adapterForDeg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        realm.setAdapter(adapterForDeg);

        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = layoutInflater.inflate(R.layout.register_popup, null);
        //popupWindow = new PopupWindow(popupView, AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT);
        btnDismiss = (Button) popupView.findViewById(R.id.goToProfile);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                studentForReg = new Student();
//                if(Validation.isValidEmailAddress(studentEmail.getText().toString())) {
//                    studentForReg.setEmail(studentEmail.getText().toString());
//                    System.out.println("In validation ok");
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "The mail you entered is not valid", Toast.LENGTH_SHORT);
//                    System.out.println("Validation not ok!! Toast didn't show up");
//                }
//                studentForReg.setName(studentName.getText().toString());
//                studentForReg.setPhoneNumber(Integer.valueOf(phoneNumber.getText().toString()));
//                studentForReg.setAge(Integer.valueOf(age.getText().toString()));
//                studentForReg.setRealm(realm.getSelectedItem().toString());
//
//                DBExcute dbEx = new DBExcute();
//                dbEx.execute();
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