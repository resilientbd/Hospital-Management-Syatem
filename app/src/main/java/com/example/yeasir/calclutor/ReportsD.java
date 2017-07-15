package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ReportsD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_d);
    }

    public void onclick_addReport(View view) {

        Intent intent = new Intent(this,Add_Report.class);
        startActivity(intent);

    }

    public void onclick_birthReport(View view) {

        Intent intent = new Intent(this,Birth_Report.class);
        startActivity(intent);

    }

    public void onclick_deathReport(View view) {

        Intent intent = new Intent(this,Death_Report.class);
        startActivity(intent);

    }

    public void onclick_backR(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);

    }
}
