package com.example.yeasir.calclutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class List_Doctor extends AppCompatActivity {
TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__doctor);

        display=(TextView) findViewById(R.id.listdoc);
        DatabaseHelper db=new DatabaseHelper(getBaseContext());
        StringBuffer line=new StringBuffer();
        List<Doctor>  list=db.doclist();
        for(Doctor dr:list)
            line.append(dr);
        display.setText(line);
    }
}
