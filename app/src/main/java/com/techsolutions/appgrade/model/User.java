package com.techsolutions.appgrade.model;

import java.sql.Blob;

/**
 * Created by Udi on 6/19/2017.
 */

public abstract class User {

    protected String email;
    protected String name;
    protected String phoneNumber;
    protected int age;
    protected String faculty;
    protected Blob picture;

    protected abstract String getEmail();

    protected abstract String getName();

    protected abstract String getPhoneNumber();

    protected abstract int getAge();

    protected abstract String getFaculty();

    protected abstract Blob getPicture();
}
