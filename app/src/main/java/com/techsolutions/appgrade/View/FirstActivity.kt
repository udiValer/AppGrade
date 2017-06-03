package com.techsolutions.appgrade.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.first_activity.*
import android.widget.Button
import com.techsolutions.appgrade.R

class FirstActivity : AppCompatActivity() {

    // UI Component
    private lateinit var btnFindPartner: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        btnFindPartner = findViewById(R.id.btnFindFast) as Button
        btnRegister = findViewById(R.id.btnBuildProfile) as Button

        // User pressed on find partner fast button
        btnFindPartner.setOnClickListener {
            val findFast = Intent("com.techsolutions.appgrade.SEMESTERACTIVITY")
            startActivity(findFast)
        }

        // User pressed on create profile button
        btnRegister.setOnClickListener {
            val registerIntent = Intent("com.techsolutions.appgrade.REGISTER")
            registerIntent.putExtra("CurrentStatus", "User_NotRegister")
            startActivity(registerIntent)
        }
    }
}
