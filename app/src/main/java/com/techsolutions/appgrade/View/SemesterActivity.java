package com.techsolutions.appgrade.View;

/**
 * Created by Udi on 6/6/2017.
 * Activity to choose the relevant semester on the current search records
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.techsolutions.appgrade.R;
import java.util.ArrayList;
import java.util.Calendar;

public class SemesterActivity extends Activity {

    private Spinner spinner;
    private Button btnProceed;
    private ArrayList<String> relevantSemesters = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    //private NewSearchingRecord curSearchRecord = new NewSearchingRecord();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semester_activity);

        btnProceed = (Button) findViewById(R.id.btnProceed1);
        spinner = (Spinner) findViewById(R.id.spinner);

        getRelevantSemseter();

        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, relevantSemesters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem().toString().contains(getString(R.string.addingCurrentSemester))) {
                    String toAdd = spinner.getSelectedItem().toString().substring(12);
                    //curSearchRecord.setSemester(toAdd);
                    System.out.println(toAdd);
                } else {
                    //curSearchRecord.setSemester(spinner.getSelectedItem().toString());
                    //Log.d("SemesterActivity", "semester from Object: " + curSearchRecord.getSemester());
                }
                Intent courseActivity = new Intent("com.techsolutions.appgrade.COURSEACTIVITY");
                //courseActivity.putExtra("course", curSearchRecord);
                Log.d("SemesterActivity", "after put extars");
                startActivity(courseActivity);
            }
        });

    }

    private void getRelevantSemseter() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH) + 1; //zero-based

        switch (month) {
            case 1:
            case 2:
            case 3:
            case 4:
                relevantSemesters.add(getString(R.string.addingCurrentSemester) + String.valueOf(year) + "א");
                relevantSemesters.add(String.valueOf(year) + "ב");
                relevantSemesters.add(String.valueOf(year) + "ג");
                relevantSemesters.add(String.valueOf(year + 1) + "א");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                relevantSemesters.add(getString(R.string.addingCurrentSemester) + String.valueOf(year) + "ב");
                relevantSemesters.add(String.valueOf(year) + "ג");
                relevantSemesters.add(String.valueOf(year + 1) + "א");
                relevantSemesters.add(String.valueOf(year + 1) + "ב");
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                relevantSemesters.add(getString(R.string.addingCurrentSemester) + String.valueOf(year) + "ג");
                relevantSemesters.add(String.valueOf(year + 1) + "א");
                relevantSemesters.add(String.valueOf(year + 1) + "ב");
                relevantSemesters.add(String.valueOf(year + 1) + "ג");
                break;

        }

    }
}
