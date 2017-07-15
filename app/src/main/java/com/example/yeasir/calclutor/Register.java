package com.example.yeasir.calclutor;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHelper db;

    EditText nameET,unameET,passET,emailET,addressET,mobileET;
    Button submitBtn,showDataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        nameET = (EditText) findViewById(R.id.nameet);
        unameET = (EditText) findViewById(R.id.unameet);
        passET =  (EditText) findViewById(R.id.passet);
        emailET  = (EditText) findViewById(R.id.emailet);
        addressET = (EditText) findViewById(R.id.addresset);
        mobileET = (EditText) findViewById(R.id.mobileet);

        submitBtn = (Button) findViewById(R.id.submitbtn);
        showDataBtn = (Button) findViewById(R.id.showdataBtn);

        add_data();
        view_data();

    }

    public void add_data() {

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInsert = db.insertRegisterData(nameET.getText().toString(),unameET.getText().toString(),passET.getText().toString(),emailET.getText().toString(),addressET.getText().toString(),mobileET.getText().toString());

                if (isInsert = true)
                    Toast.makeText(Register.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Register.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void view_data() {
        showDataBtn.setOnClickListener(new View.OnClickListener() {
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
                    buffer.append("User Name: " + res.getString(2) + "\n");
                    buffer.append("Password: " + res.getString(3) + "\n");
                    buffer.append("E-Mail: " + res.getString(4) + "\n");
                    buffer.append("Address: " + res.getString(5) + "\n");
                    buffer.append("Mobile: " + res.getString(6) + "\n\n");
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
}
