package com.techsolutions.appgrade.view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
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

import com.techsolutions.appgrade.model.ThisUser;
import com.techsolutions.appgrade.R;

/**
 * Created by Udi on 6/6/2017.
 * Activity for new user registration
 */

public class RegisterActivity extends Activity {

    private static int RESULT_LOAD_IMAGE = 1;
    private EditText userEmail;
    private EditText userName;
    private EditText phoneNumber;
    private EditText age;
    private TextView firstTitleText;
    private TextView secondTitleText;
    private Button btnForPickPicture;
    private Spinner realm;
    private Button reg;
    private LayoutInflater layoutInflater;
    private View popupView;
    private PopupWindow popupWindow;
    private Button btnDismiss;
    private View parent;



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
        btnForPickPicture = (Button) findViewById(R.id.btnImportPic);

        firstTitleText.setText(R.string.RegisterActivityFirstTitleText);
        secondTitleText.setText(R.string.RegisterActivitySecondTitleText);

        ArrayAdapter<CharSequence> adapterForDeg = ArrayAdapter.createFromResource(this, R.array.spinnerarrayForDeg, android.R.layout.simple_spinner_item);
        adapterForDeg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        realm.setAdapter(adapterForDeg);

        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = layoutInflater.inflate(R.layout.register_popup, null);
        popupWindow = new PopupWindow(popupView, AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT);
        btnDismiss = (Button) popupView.findViewById(R.id.goToProfile);


        btnForPickPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThisUser thisUser = ThisUser.getInstance();
                String resultForPopUp = thisUser.getInstance().init(getApplicationContext(), userEmail.getText().toString(), userName.getText().toString(), phoneNumber.getText().toString()
                        , Integer.valueOf(age.getText().toString()), realm.getSelectedItem().toString(), null);
                // TODO: if resultForPopUp not equal R.string.registerApproved we should pop up error and stay on the screen

                //add user to db
                //FireBaseDBUtils.addUser(thisUser);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            Log.d("RegisterActivity" , picturePath.toString());
            cursor.close();

            //ImageView imageView = (ImageView) findViewById(R.id.imgView);
            //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }

    }

    class RegisterThisUserInBackGround extends AsyncTask<Object, Object, Void> {

        @Override
        protected Void doInBackground(Object... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void curVoid) {
        }
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