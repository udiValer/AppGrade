package com.techsolutions.appgrade.Model;

import android.content.Context;
import android.content.res.Resources;

import com.techsolutions.appgrade.R;

import org.apache.commons.validator.routines.EmailValidator;

import java.sql.Blob;

/**
 * Created by Udi on 6/9/2017.
 */

public class ThisUser {

    private String email;
    private String name;
    private String phoneNumber;
    private int age;
    private String realm;
    private Blob picture;

    private static final ThisUser INSTANCE = new ThisUser();

    public static ThisUser getInstance() {  return INSTANCE;  }

    private ThisUser(){}

    public String init(Context c, String email, String name , String phoneNumber , int age , String realm , Blob picture){
        String result = c.getString(R.string.registerApproved);
        this.setName(name);
        this.setRealm(realm);

        if(!this.setEmail(email)){
            result = c.getString(R.string.EmailNotValid);
        }
        if(!this.setAge(age)){
            result = c.getString(R.string.AgeNotValid);
        }
        if(!this.setPhoneNumber(phoneNumber)){
            result = c.getString(R.string.DigitsNotValid);
        }

        this.setPicture(picture); // TODO: Add validation
        return result;

    }

    public String getEmail() {  return email;   }

    public boolean setEmail(String email) {
        if(EmailValidator.getInstance().isValid(email)) {
            this.email = email;
            return true;
        } else {
            return false;
        }
    }

    public String getName() {   return name;    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {   return phoneNumber; }

    public boolean setPhoneNumber(String phoneNumber) {
        if(String.valueOf(phoneNumber).length() == 10) {
            this.phoneNumber = phoneNumber;
            return true;
        }else{
            return false;
        }
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if(!(age<=0)) {
            this.age = age;
            return  true;
        }else{
            return  false;
        }
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public Blob getPicture() { return picture; }

    public void setPicture(Blob pic) { this.picture = pic;  }

    public String toString(){
        return "User Data: \n Email:    " + email + "\n Name:   " + name + "\n PhoneNumber:     " + phoneNumber +
                "\n Age:    " + age;
    }

}
