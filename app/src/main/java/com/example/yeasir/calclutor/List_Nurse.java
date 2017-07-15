package com.example.yeasir.calclutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class List_Nurse extends AppCompatActivity {
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__nurse);

        display=(TextView) findViewById(R.id.listnurse);
        DatabaseHelper db=new DatabaseHelper(getBaseContext());
        StringBuffer line=new StringBuffer();
        List<Nurse> list=db.nurselist();
        for(Nurse nrs:list)
            line.append(nrs);
        display.setText(line);
    }
}
