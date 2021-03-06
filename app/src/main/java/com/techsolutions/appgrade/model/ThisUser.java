package com.techsolutions.appgrade.model;

import android.content.Context;
import com.techsolutions.appgrade.logic.DataController;
import com.techsolutions.appgrade.R;
import java.sql.Blob;

/**
 * Created by Udi on 6/9/2017.
 */

public class ThisUser extends User{

    protected boolean isRegister;

    // todo - replace picture blob with url path to firebase storage service, add date field to user metadata
    //private String pictureUrl
    //private Long dateAdded

    private static ThisUser mInstance = null;

    public static ThisUser getInstance() {
        if(mInstance==null)
        {
            mInstance = new ThisUser();
        }
        return mInstance;
    }

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
        this.setIsRegister(true);
        return result;
    }

    public String getEmail() {  return email;   }

    public boolean setEmail(String email) {
        if(DataController.Instance().getSharedPref().setEmail(email)) {
            this.email = email;
            return true;
        } else {
            return false;
        }
    }

    public String getName() {   return name;    }

    public void setName(String name) {
        this.name = name;
        DataController.Instance().getSharedPref().setName(name);
    }

    public String getPhoneNumber() {   return phoneNumber; }

    public boolean setPhoneNumber(String phoneNumber) {
        if(DataController.Instance().getSharedPref().setPhoneNum(phoneNumber)) {
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
        if(DataController.Instance().getSharedPref().setAge(age)) {
            this.age = age;
            return  true;
        }else{
            return  false;
        }
    }

    public String getFaculty() {
        return faculty;
    }

    public void setRealm(String realm) {
        this.faculty = realm;
        DataController.Instance().getSharedPref().setRealm(realm);
    }

    public Blob getPicture() { return picture; }

    public void setPicture(Blob pic) {

        this.picture = pic;
    }

    public void setIsRegister(boolean isRegister) {
        this.isRegister = isRegister;
        DataController.Instance().getSharedPref().setIsRegister(isRegister);
    }

    public boolean IsRegister(){
        return DataController.Instance().getSharedPref().IsRegister();
    }

    public String toString(){
        return "User Data: \n Email:    " + email + "\n Name:   " + name + "\n PhoneNumber:     " + phoneNumber +
                "\n Age:    " + age;
    }


}
