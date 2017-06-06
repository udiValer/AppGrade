package com.techsolutions.appgrade.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.techsolutions.appgrade.R;

import java.util.ArrayList;

/**
 * Created by Udi on 6/6/2017.
 * Activity to choose the relevant Course on the current search records
 */

public class CourseActivity extends Activity {

    private Spinner spinnerForDeg;
    private Spinner spinnerForCourse;
    private Button btnProceed;
    //private NewSearchingRecord curSearchRecord;
    private boolean first = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_layout);

        Intent i = getIntent();
        //curSearchRecord = (NewSearchingRecord) i.getSerializableExtra("course");
        //Log.d("CourseActivity", curSearchRecord.getSemester());
        btnProceed = (Button) findViewById(R.id.btnProceed2);
        spinnerForDeg = (Spinner) findViewById(R.id.spinnerForDeg);
        spinnerForCourse = (Spinner) findViewById(R.id.spinnerForCourse);
        spinnerForCourse.setVisibility(View.GONE);

        ArrayAdapter<CharSequence> adapterForDeg = ArrayAdapter.createFromResource(this, R.array.spinnerarrayForDeg, android.R.layout.simple_spinner_item);
        adapterForDeg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerForDeg.setAdapter(adapterForDeg);


        //When user select degree - search in SQLite all courses for specific degree
        spinnerForDeg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!first) {
                    first = true;
                    return;
                }
                String selectedRealm = spinnerForDeg.getSelectedItem().toString();

                //DB_SQLiteManipulation SQLiteDB = new DB_SQLiteManipulation(getApplicationContext());
                //ArrayList<String> arr = SQLiteDB.getCoursesByDegree(selectedRealm);
                //System.out.println("aaa arr is:"+arr);

                //ArrayAdapter<String> adapterForCourse = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arr);
                //ArrayAdapter.createFromResource(getApplicationContext(), arr, android.R.layout.simple_spinner_item);
                //adapterForCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //spinnerForCourse.setAdapter(adapterForCourse);

                spinnerForCourse.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (spinnerForDeg.getSelectedItemPosition() > 0) {
            spinnerForCourse.setVisibility(View.VISIBLE);
        }


        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //curSearchRecord.setName(spinnerForCourse.getSelectedItem().toString());
                Intent cityActivity = new Intent("com.techsolutions.appgrade.CITYACTIVITY");
                //cityActivity.putExtra("searchingRecord", curSearchRecord);
                startActivity(cityActivity);
            }
        });

    }

}
