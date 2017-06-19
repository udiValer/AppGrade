package com.techsolutions.appgrade.Model;

import java.sql.Blob;

/**
 * Created by Udi on 6/19/2017.
 */

public abstract class User {

    private String email;
    private String name;
    private String phoneNumber;
    private int age;
    private String realm;
    private Blob picture;

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
