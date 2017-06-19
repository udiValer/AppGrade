package com.techsolutions.appgrade.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.techsolutions.appgrade.R;
import com.techsolutions.appgrade.database.FireBaseDBUtils;

/**
 * Created by Udi on 6/6/2017.
 * Activity for unregister user.
 * Let him decide if he want to navigate to start register in normal way or just find partner fast
 */

public class FirstActivity extends Activity {

    private Button btnRegister;
    private Button btnFindPartner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        btnRegister = (Button) findViewById(R.id.btnBuildProfile);
        btnFindPartner = (Button) findViewById(R.id.btnFindFast);

        // User pressed on find partner fast button
        btnFindPartner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent findFast = new Intent("com.techsolutions.appgrade.SEMESTERACTIVITY");
                startActivity(findFast);
            }
        });

        // User pressed on create profile button
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent("com.techsolutions.appgrade.REGISTERACTIVITY");
                startActivity(registerIntent);
            }
        });

        FireBaseDBUtils.checkVersion();
    }
}

