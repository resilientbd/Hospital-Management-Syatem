package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DepartmentD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_d);
    }

    public void onclick_backDep(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);

    }
}
