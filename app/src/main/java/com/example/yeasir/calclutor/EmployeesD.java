package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EmployeesD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_d);
    }

    public void onclick_addEmployee(View view) {

        Intent intent = new Intent(this,Add_Employee.class);
        startActivity(intent);

    }

    public void onclick_viewEmployee(View view) {

        Intent intent = new Intent(this,List_Employee.class);
        startActivity(intent);

    }

    public void onclick_dischargeEmployee(View view) {

        Intent intent = new Intent(this,Discharge_Employee.class);
        startActivity(intent);

    }

    public void onclick_backE(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);

    }
}
