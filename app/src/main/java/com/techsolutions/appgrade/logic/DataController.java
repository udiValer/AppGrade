package com.techsolutions.appgrade.logic;

import android.content.Context;

import com.techsolutions.appgrade.model.ThisUser;

//Singleton class
public class DataController{

    private MySharedPreferences sharedPref;
    private static DataController mInstance = null;

    private DataController(){

    }

    public static DataController Instance(){
        if(mInstance == null)
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

}
