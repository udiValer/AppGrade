package com.techsolutions.appgrade.Model;

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {   return name;    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {   return phoneNumber; }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
