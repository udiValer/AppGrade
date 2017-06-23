package com.techsolutions.appgrade.logic;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * Created by Udi on 6/17/2017.
 */

public class MySharedPreferences {

    private static SharedPreferences sharedPref;
    private static SharedPreferences.Editor editor;

    private static String PREF_NAME = "StudentSharedPref";
    private static String KEY_IS_REGISTER = "isRegister";
    private static String KEY_Name = "name";
    private static String KEY_Email = "email";
    private static String KEY_PhoneNum = "phoneNum";
    private static String KEY_Age = "age";
    private static String KEY_Realm = "realm";

    public MySharedPreferences(Context context){
        sharedPref = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void setName(String name)
    {
        editor.putString(KEY_Name, name);
        editor.apply();
    }

    public String getName(){
        if(sharedPref.contains(KEY_Name))
        {
            return sharedPref.getString(KEY_Name, "");
        }
        return "";
    }

    public boolean setEmail(String email)
    {
        if(!EmailValidator.getInstance().isValid(email))
            return false;

        editor.putString(KEY_Email, email);
        editor.apply();
        return true;
    }

    public String getEmail(){
        if(sharedPref.contains(KEY_Email))
        {
            return sharedPref.getString(KEY_Email, "");
        }
        return "";
    }

    public boolean setPhoneNum(String phoneNum)
    {
        if(String.valueOf(phoneNum).length() == 10)
            return false;

        editor.putString(KEY_PhoneNum, phoneNum);
        editor.apply();
        return true;
    }

    public String getPhoneNum(){
        if(sharedPref.contains(KEY_PhoneNum))
        {
            return sharedPref.getString(KEY_PhoneNum, "");
        }
        return "";
    }

    public boolean setAge(int age)
    {
        if(age <= 0 || age>120)
            return false;

        editor.putInt(KEY_Age, age);
        editor.apply();
        return true;

    }

    public int getAge(){
        if(sharedPref.contains(KEY_Age))
        {
            return sharedPref.getInt(KEY_Age, 0);
        }
        return 0;
    }

    public void setRealm(String realm)
    {
        editor.putString(KEY_Realm, realm);
        editor.apply();
    }

    public String getRealm(){
        if(sharedPref.contains(KEY_Realm))
        {
            return sharedPref.getString(KEY_Realm, "");
        }
        return "";
    }

    public void setIsRegister(boolean isRegister)
    {
        editor.putBoolean(KEY_IS_REGISTER, isRegister);
        editor.apply();
    }

    public boolean IsRegister(){
        if(sharedPref.contains(KEY_IS_REGISTER))
        {
            return sharedPref.getBoolean(KEY_IS_REGISTER, false);
        }
        return false;
    }
}
