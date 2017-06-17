package com.techsolutions.appgrade.Model;

import java.sql.Blob;

/**
 * Created by Udi on 6/9/2017.
 */

public class OtherUser {

    private String email;
    private String name;
    private String phoneNumber;
    private int age;
    private String realm;
    private Blob picture;

    public OtherUser(String Email, String Name , String PhoneNumber , int Age , String Realm , Blob Picture){
        this.email = Email;
        this.name = Name;
        this.phoneNumber = PhoneNumber;
        this.age = Age;
        this.realm = Realm;
        this.picture = Picture;
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
