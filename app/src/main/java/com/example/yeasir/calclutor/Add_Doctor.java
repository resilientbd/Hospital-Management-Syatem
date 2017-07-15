package com.example.yeasir.calclutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_Doctor extends AppCompatActivity {
private EditText name,contact,email;
    private Spinner department;
    private Button save,view;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__doctor);

        name=(EditText) findViewById(R.id.docname);
        contact=(EditText) findViewById(R.id.doccontact);
        email=(EditText) findViewById(R.id.docemail);
        department=(Spinner) findViewById(R.id.docdepartment);
        save=(Button) findViewById(R.id.addDocbtn);

        db=new DatabaseHelper(getBaseContext());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inName=name.getText().toString();
                String incontact=contact.getText().toString();
                String inemail=email.getText().toString();
                String indepartment=department.getSelectedItem().toString();

              boolean result=  db.insertDocData(inName,incontact,inemail,indepartment);
                if(result==true)
                    Toast.makeText(getBaseContext(),"DOCTOR ADDED SUCCESSFULL !!",Toast.LENGTH_LONG).show();
                else Toast.makeText(getBaseContext(),"DOCTOR NOT ADDED !!",Toast.LENGTH_LONG).show();

            }
        });

    }
}
