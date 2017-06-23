package com.techsolutions.appgrade.database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.techsolutions.appgrade.model.ThisUser;

import java.util.Collection;
import java.util.HashMap;


/**
 * Created by orenga on 6/10/17.
 * Class containing FireBase Database utility methods
 */

public class FireBaseDBUtils {

    public static final String INSTITUTE = "institute";
    public static final String DEPARTMENT = "department";
    public static final String SEMESTERS = "semesters";
    public static final String METADATA = "metadata";
    public static final String USERS = "users";

    public static void checkVersion(){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef = database.child(METADATA);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Metadata metadata = dataSnapshot.getValue(Metadata.class);
                if (metadata != null && metadata.getVersion() != null){
                    String version = getAppVersion();
                    if (!metadata.getVersion().equals(version)){
                        // DOWNLOAD NEW VERSION
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public static void addUser(ThisUser user){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef = database.child(USERS);

        DatabaseReference newUserRef = myRef.push();
        newUserRef.setValue(user);

        //update user count after user is added
        updateUserCounter();

    }

    public static void getCourses(String institute, String semester, String department){

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef = database.child(INSTITUTE).child(institute)
                .child(SEMESTERS).child(semester).child(DEPARTMENT).child(department);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object courses = dataSnapshot.getValue();
                //todo - update sqllite courses db
                Collection values = ((HashMap) courses).values();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }


    //todo implement for sqlite/shared pref version once app is installed for the first time
    private static String getAppVersion(){
        return "1.0";
    }

    // todo - implement
    private static void updateUserCounter(){
    }
}
