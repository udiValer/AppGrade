package com.techsolutions.appgrade.model;

import java.sql.Blob;

/**
 * Created by Udi on 6/9/2017.
 */

public class OtherUser extends User{

    public OtherUser(String Email, String Name , String PhoneNumber , int Age , String Realm , Blob Picture){
        this.email = Email;
        this.name = Name;
        this.phoneNumber = PhoneNumber;
        this.age = Age;
        this.faculty = Realm;
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

    public String getFaculty() {
        return faculty;
    }

    public Blob getPicture() {
        return picture;
    }
}
