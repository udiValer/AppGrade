package com.techsolutions.appgrade.Logic;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.techsolutions.appgrade.Model.ThisUser;
import com.techsolutions.appgrade.Model.User;

import org.apache.commons.validator.routines.EmailValidator;

import java.sql.Blob;

//Singleton class
public class DataController{

    private MySharedPreferences sharedPref;

    private String email;
    private String name;
    private String phoneNumber;
    private int age;
    private String realm;
    private Blob picture;

    private static DataController mInstance = null;

    public static DataController Instance(){
        if(mInstance==null)
        {
            mInstance = new DataController();
        }
        return mInstance;
    }

    public static DataController Instance(Context context){
        if(mInstance==null)
        {
            mInstance = new DataController();
            mInstance.sharedPref = new MySharedPreferences(context);
            if(mInstance.sharedPref.IsRegister()){
                ThisUser.getInstance().init(context, mInstance.sharedPref.getEmail() , mInstance.sharedPref.getName(),
                        mInstance.sharedPref.getPhoneNum() , mInstance.sharedPref.getAge(),
                        mInstance.sharedPref.getRealm() , null);
            }
        }
        return mInstance;
    }

    public MySharedPreferences getSharedPref() {
        return sharedPref;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getRealm() {
        return realm;
    }

    public Blob getPicture() {
        return picture;
    }
}
