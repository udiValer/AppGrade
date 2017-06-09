package com.techsolutions.appgrade.Model;

import com.techsolutions.appgrade.R;

import java.sql.Blob;

/**
 * Created by Udi on 6/9/2017.
 */

public class ThisUser extends User {

    private static ThisUser INSTANCE = null;

    protected ThisUser(){}

    public static ThisUser getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ThisUser();
        }
        return INSTANCE;
    }

    public String init(String email, String name , int phoneNumber , int age , String realm ,Blob picture){
        String result = String.valueOf(R.string.registerApproved);
        this.setName(name);
        this.setRealm(realm);

        if(!this.setEmail(email)){
            result = String.valueOf(R.string.EmailNotValid);
        }
        if(!this.setAge(age)){
            result = String.valueOf(R.string.AgeNotValid);
        }
        if(!this.setPhoneNumber(phoneNumber)){
            result = String.valueOf(R.string.DigitsNotValid);
        }

        this.setPicture(picture); // TODO: Add validation
        return result;

    }


}
