package com.example.yeasir.calclutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_Nurse extends AppCompatActivity {

    private EditText name,contact,email;
    private Spinner department;
    private Button save,view;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__nurse);

        name=(EditText) findViewById(R.id.nursename);
        contact=(EditText) findViewById(R.id.nurseContact);
        email=(EditText) findViewById(R.id.nurseemail);
        department=(Spinner) findViewById(R.id.nursedepartment);
        save=(Button) findViewById(R.id.addnursebtn);

        db=new DatabaseHelper(getBaseContext());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inName=name.getText().toString();
                String incontact=contact.getText().toString();
                String inemail=email.getText().toString();
                String indepartment=department.getSelectedItem().toString();

                boolean result=  db.insertNurse(inName,incontact,inemail,indepartment);
                if(result==true)
                    Toast.makeText(getBaseContext(),"NURSE ADDED SUCCESSFULL !!",Toast.LENGTH_LONG).show();
                else Toast.makeText(getBaseContext(),"NURSE NOT ADDED !!",Toast.LENGTH_LONG).show();

            }
        });

    }
}
