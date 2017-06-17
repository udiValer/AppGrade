package com.techsolutions.appgrade.Model;

import android.content.Context;

import com.techsolutions.appgrade.Logic.DataController;
import com.techsolutions.appgrade.R;

import java.sql.Blob;

/**
 * Created by Udi on 6/9/2017.
 */

public class ThisUser {

//    private String email;
//    private String name;
//    private String phoneNumber;
//    private int age;
//    private String realm;
    private Blob picture;

    private static final ThisUser INSTANCE = new ThisUser();

    public static ThisUser getInstance() {  return INSTANCE;  }

    private ThisUser(){}

    public String init(Context c, String email, String name , String phoneNumber , int age , String realm , Blob picture){
        String result = c.getString(R.string.registerApproved);
        DataController.Instance().setName(name);
        DataController.Instance().setRealm(realm);

        if(!DataController.Instance().setEmail(email)){
            result = c.getString(R.string.EmailNotValid);
        }

        if(!DataController.Instance().setAge(age)){
            result = c.getString(R.string.AgeNotValid);
        }

        if(!DataController.Instance().setPhoneNum(phoneNumber)){
            result = c.getString(R.string.DigitsNotValid);
        }

        this.setPicture(picture); // TODO: Add validation
        return result;
    }


    public Blob getPicture() { return picture; }

    public void setPicture(Blob pic) { this.picture = pic;  }

//    public String toString(){
//        return "User Data: \n Email:    " + email + "\n Name:   " + name + "\n PhoneNumber:     " + phoneNumber +
//                "\n Age:    " + age;
//    }

}
