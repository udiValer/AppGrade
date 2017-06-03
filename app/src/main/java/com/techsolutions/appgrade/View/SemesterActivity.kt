package com.techsolutions.appgrade.View

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.techsolutions.appgrade.R
import java.util.*

class SemesterActivity : Activity() {

    // UI Components
    private lateinit var spinner: Spinner
    private lateinit var btnProceed: Button

    // DB components
    //private val curSearchRecord = NewSearchingRecord()

    // Logic Components
    private val relevantSemesters = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.semester_activity)

        btnProceed = findViewById(R.id.btnProceed1) as Button
        spinner = findViewById(R.id.spinner) as Spinner

        getRelevantSemseter()

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, relevantSemesters)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnProceed.setOnClickListener {
            if (spinner.selectedItem.toString().contains(getString(R.string.addingCurrentSemester))) {
                val toAdd = spinner.selectedItem.toString().substring(12)
                //curSearchRecord.setSemester(toAdd)
                println(toAdd)
            } else {
                //curSearchRecord.setSemester(spinner!!.selectedItem.toString())
                //Log.d("SemesterActivity", "semester from Object: " + curSearchRecord.getSemester())
            }
            val courseActivity = Intent("yuvallevy.finalproject_correct.COURSEACTIVITY")
            //courseActivity.putExtra("course", curSearchRecord)
            Log.d("SemesterActivity", "after put extars")
            startActivity(courseActivity)
        }

    }

    private fun getRelevantSemseter() {

        val now = Calendar.getInstance()
        val year = now.get(Calendar.YEAR)
        val month =  now.get(Calendar.MONTH) + 1//zero-based

        when (month) {
            1, 2, 3, 4 -> {
                relevantSemesters.add(getString(R.string.addingCurrentSemester) + " " +year.toString() + "א")
                relevantSemesters.add(year.toString() + "ב")
                relevantSemesters.add(year.toString() + "ג")
                relevantSemesters.add((year + 1).toString() + "א")
            }
            5, 6, 7, 8 -> {
                relevantSemesters.add(getString(R.string.addingCurrentSemester) + " " +year.toString() + "ב")
                relevantSemesters.add(year.toString() + "ג")
                relevantSemesters.add((year + 1).toString() + "א")
                relevantSemesters.add((year + 1).toString() + "ב")
            }
            9, 10, 11, 12 -> {
                relevantSemesters.add(getString(R.string.addingCurrentSemester) + " " + year.toString() + "ג")
                relevantSemesters.add((year + 1).toString() + "א")
                relevantSemesters.add((year + 1).toString() + "ב")
                relevantSemesters.add((year + 1).toString() + "ג")
            }
        }

    }


}