package com.example.yeasir.calclutor;

import android.content.Intent;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientD extends AppCompatActivity {

    NewPatientDatabase db;
    Button viewPatientBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_d);

        db = new NewPatientDatabase(this);
        viewPatientBtn = (Button) findViewById(R.id.listPatient_btn);
        onclick_listPatient();
    }

    public void onclick_addPatient(View view) {

        Intent intent = new Intent(this,NewPatient.class);
        startActivity(intent);

    }

    public void onclick_dischargePatient(View view) {

        Intent intent = new Intent(this,DischargePatient.class);
        startActivity(intent);

    }

    public void onclick_listPatient() {

        viewPatientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res = db.getAllData();

                if (res.getCount() == 0)
                {
                    //Toast.makeText(Admin.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    showMessage("Error","No Data Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (res.moveToNext())
                {
                    buffer.append("ID: " + res.getString(0) + "\n");
                    buffer.append("Name: " + res.getString(1) + "\n");
                    buffer.append("Mobile: " + res.getString(2) + "\n");
                    buffer.append("Age: " + res.getString(3) + "\n");
                    buffer.append("Disease: " + res.getString(4) + "\n");
                    buffer.append("Department: " + res.getString(5) + "\n");
                   // buffer.append("Mobile: " + res.getString(6) + "\n\n");
                }

                showMessage("Data",buffer.toString());
            }
        });

    }

    public void showMessage(String tittle,String message) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(true);
        dialog.setTitle(tittle);
        dialog.setMessage(message);
        dialog.show();
    }

    public void onclick_back(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);

    }

}
