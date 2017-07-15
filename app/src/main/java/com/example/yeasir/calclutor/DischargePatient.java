package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DischargePatient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discharge_patient);
    }

    public void onClick_back(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);
    }

}
