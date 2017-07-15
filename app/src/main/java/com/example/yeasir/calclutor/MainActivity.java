package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
    }

    public void onclic_login(View view) {

        user = (EditText) findViewById(R.id.nameet);
        pass = (EditText) findViewById(R.id.passet);

        String un = user.getText().toString();
        String pas = pass.getText().toString();

        if (un.equals("admin") && pas.equals("pass123"))
        {
            Intent intent = new Intent(this,Admin.class);
            startActivity(intent);
        }
    }

    public void onclick_register(View view) {

        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
