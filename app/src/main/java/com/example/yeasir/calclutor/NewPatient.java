package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class NewPatient extends AppCompatActivity {

    EditText nameET,phoneET,ageET,patientET;
    TextView patientIdTV;
    Spinner genderSP,disSP,departmentSP,availableRoomSP;
    Button saveBTN,clearBTN;
    String gender,disease,department,room;

    NewPatientDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);

        init();

        db = new NewPatientDatabase(this);
        patientET.setText("758783883");


        loadGenderSpinnerData();
        loadDiseaseSpinnerData();
        loadDepartmentSpinnerData();
        loadRoomSpinnerData();

        add_data();
        onClick_clear();

    }



    public void onClick_back(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);
    }

    public void onClick_clear() {
        clearBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameET.setText("");
                phoneET.setText("");
                ageET.setText("");
            }
        });
    }

    public void init() {

        nameET = (EditText) findViewById(R.id.nameet);
        phoneET = (EditText) findViewById(R.id.phoneet);
        ageET = (EditText) findViewById(R.id.ageet);
        patientIdTV = (TextView) findViewById(R.id.pIdTv);
        patientET = (EditText) findViewById(R.id.pIdEt);

        genderSP = (Spinner) findViewById(R.id.genderSp);
        disSP = (Spinner) findViewById(R.id.diasesSp);
        departmentSP = (Spinner) findViewById(R.id.departmentSp);
        availableRoomSP = (Spinner) findViewById(R.id.avRoomSp);

        saveBTN = (Button) findViewById(R.id.save_btn);
        clearBTN = (Button) findViewById(R.id.clear_btn);
    }


    private void loadGenderSpinnerData() {
        //disSP.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        disSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), "You selected Gender: " + gender,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadDiseaseSpinnerData() {
        //disSP.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        disSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                disease = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), "You selected Gender: " + disease,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadDepartmentSpinnerData() {
        //disSP.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        disSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                department = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), "You selected Gender: " + department,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadRoomSpinnerData() {
        //disSP.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        disSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                room = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), "You selected Gender: " + room,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void add_data() {

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInsert = db.insertRegisterData(nameET.getText().toString(),phoneET.getText().toString()
                        ,ageET.getText().toString(),gender,disease
                        ,department,room);

                if (isInsert = true)
                    Toast.makeText(NewPatient.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(NewPatient.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
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
}
