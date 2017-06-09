package com.techsolutions.appgrade.Model;

import org.apache.commons.validator.routines.EmailValidator;

import java.sql.Blob;

/**
 * Created by Udi on 6/6/2017.
 * Root class of users. contain the base information we want every user will have
 * *the remote DB. holding his email , name , phoneNumber , age , realm , picture
 */

public abstract class User {

    private String email;
    private String name;
    private int phoneNumber;
    private int age;
    private String realm;
    private Blob picture;

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

    public int getPhoneNumber() {   return phoneNumber; }

    public boolean setPhoneNumber(int phoneNumber) {
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

}
