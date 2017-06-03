package com.techsolutions.appgrade.View

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.techsolutions.appgrade.Model.User
import com.techsolutions.appgrade.R

/**
 * Created by Udi on 6/2/2017.
 */

class Register : Activity() {

    // UI Component
    private lateinit var studentEmail: EditText
    private lateinit var studentName: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var age: EditText
    private lateinit var firstTitleText: TextView
    private lateinit var secondTitleText: TextView
    private lateinit var realm: Spinner
    private lateinit var reg: Button
    private lateinit var popupView: View
    private lateinit var popupWindow: PopupWindow
    private lateinit var btnDismiss: Button
    private lateinit var parent: View

    // DB components
    private lateinit var userToRegister: User

    // Logic Components
    private var cameFromSearchResult: Boolean = false
    private var addToMyCourses: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        parent = this.findViewById(android.R.id.content)

        firstTitleText = findViewById(R.id.firstTitleText) as TextView
        secondTitleText = findViewById(R.id.secondTitleText) as TextView
        studentEmail = findViewById(R.id.txtEmail) as EditText
        studentName = findViewById(R.id.txtFullName) as EditText
        phoneNumber = findViewById(R.id.txtPhoneNumber) as EditText
        age = findViewById(R.id.txtAge) as EditText
        realm = findViewById(R.id.spRealm) as Spinner
        reg = findViewById(R.id.btnSignIn) as Button

        val callerStatus = intent.getStringExtra("CurrentStatus")
        //Set the text title according to the activity the user arrived from
        if (callerStatus == "FirstUser_NotRegister") {
            //You are the first - Enter your details
            firstTitleText.text = "תלמיד חרוץ! אתה הראשון"
            secondTitleText.text = "אנא מלא את הפרטים הבאים:\nואנו נודיע לך ברגע שנמצא עבורך סטודנט מתאים ללמוד איתו"
            addToMyCourses = true
        } else if (callerStatus == "Found_Match_NotRegister") {
            //Matches found - enter your details to contact
            firstTitleText.text = "נמצאו סטודנטים מתאימים!"
            secondTitleText.text = "אנא מלא את הפרטים הבאים כדי ליצור קשר עם הפרטנר שבחרת"
            cameFromSearchResult = true
            addToMyCourses = true
        } else { //Create new profile
            firstTitleText.text = "צור את פרופיל הסטודנט שלך"
            secondTitleText.text = "אנא מלא את הפרטים הבאים כדי למצוא שותפים נהדרים ללמוד איתם"
        }

        val adapterForDeg = ArrayAdapter.createFromResource(this, R.array.spinnerarrayForDeg, android.R.layout.simple_spinner_item)
        adapterForDeg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        realm.adapter = adapterForDeg

        popupView = LayoutInflater.from(parent.context).inflate(R.layout.register_popup, null)
        popupWindow = PopupWindow(popupView, AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT)
        btnDismiss = popupView.findViewById(R.id.goToProfile) as Button

        reg.setOnClickListener {
            try {
                userToRegister = User(studentEmail.text.toString(),
                        studentEmail.text.toString(),
                        (phoneNumber.text.toString()).toInt(),
                                (age.text.toString()).toInt(),
                                        realm.selectedItem.toString(),null)

                Log.d("Regiser" , "userToRegistr ${userToRegister}")


            }
            catch (e: Exception) {
                // handler
            }
        }

    }
}


        //reg.setOnClickListener {
            //studentForReg = Student()
//            if (Validation.isValidEmailAddress(studentEmail!!.text.toString())) {
//                studentForReg!!.setEmail(studentEmail!!.text.toString())
//                println("In validation ok")
//            } else {
//                Toast.makeText(applicationContext, "The mail you entered is not valid", Toast.LENGTH_SHORT)
//                println("Validation not ok!! Toast didn't show up")
//            } TODO: Add validation

//            studentForReg.setAge(Integer.valueOf(age!!.text.toString()))
//            studentForReg.setRealm(realm!!.selectedItem.toString())

//            val dbEx = DBExcute()
//            dbEx.execute()
//        }
//
//        btnDismiss!!.setOnClickListener(object : Button.OnClickListener {
//
//            override fun onClick(v: View) {
//                val nextActivity: Intent
//                if (cameFromSearchResult!!) {
//                    nextActivity = Intent("yuvallevy.finalproject_correct.MAKECONTACT")
//                    val studentToPass = intent.getSerializableExtra("student") as Student
//                    nextActivity.putExtra("student", studentToPass)
//                } else {
//                    nextActivity = Intent("yuvallevy.finalproject_correct.REGISTEREDUSERPROFILE")
//                }
//                startActivity(nextActivity)
//            }
//        })
//
//
//    }
//
//    internal inner class DBExcute : AsyncTask<Void, Void, Void>() {
//
//        override fun doInBackground(vararg params: Void): Void? {
//            val myDB = DBmanipulation()
//            myDB.insertNewStudnt(studentForReg)
//
//            //Store personal details on device shared preferences
//            val mySharedPrefences = MySharedPreferences(applicationContext)
//            mySharedPrefences.storePersonalDetails(studentForReg)
//            mySharedPrefences.changeRegisterUserStatus(true)
//
//            //check if new searching record exist and to myCourse List in sharedPreferences
//            if (addToMyCourses!!) {
//                //Get new searching record details
//                val newSearchingRecord = intent.getSerializableExtra("searchingRecord") as NewSearchingRecord
//                //Add new course details to sqlite db
//                val SQLiteDB = DB_SQLiteManipulation(applicationContext)
//                SQLiteDB.addCourseToMyCourses(newSearchingRecord)
//                //add new searching record to server database
//                myDB.insertNewSearchingRecord(mySharedPrefences.getMyEmail(), newSearchingRecord.getSemester(), newSearchingRecord.getName(), newSearchingRecord.getPlace())
//            }
//            return null
//        }
//
//        override fun onPostExecute(curVoid: Void) {
//            super.onPostExecute(curVoid)
//
//            popupWindow!!.showAtLocation(parent, Gravity.CENTER, 50, -30)
//
//        }
//    }
//}


