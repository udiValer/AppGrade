package com.techsolutions.appgrade.model;

/**
 * Created by Udi on 6/12/2017.
 */

public class SearchRecord {

    private String email;
    private String semester;
    private String course;
    private String city;

    private static final SearchRecord ourInstance = new SearchRecord();

    public static SearchRecord getInstance() {
        return ourInstance;
    }

    private SearchRecord() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString(){
        return "Search record Data: \n Email:    " + email + "\n Semester:   " + semester + "\n Course:     " + course +
                "\n City:    " + city;
    }
}
