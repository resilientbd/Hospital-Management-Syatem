package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NursesD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurses_d);
    }

    public void onclick_addNurse(View view) {

        Intent intent = new Intent(this,Add_Nurse.class);
        startActivity(intent);

    }

    public void onclick_listNurse(View view) {

        Intent intent = new Intent(this,List_Nurse.class);
        startActivity(intent);

    }

    public void onclick_dischargeNurse(View view) {

        Intent intent = new Intent(this,Discharge_Nurse.class);
        startActivity(intent);

    }

    public void onclick_backN(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);

    }
}
