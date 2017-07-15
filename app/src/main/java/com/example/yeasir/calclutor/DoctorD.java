package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DoctorD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_d);
    }

    public void onclick_back(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);

    }

    public void onclick_addDoctor(View view) {

        Intent intent = new Intent(this,Add_Doctor.class);
        startActivity(intent);

    }

    public void onclick_listDoctor(View view) {

        Intent intent = new Intent(this,List_Doctor.class);
        startActivity(intent);

    }
}
