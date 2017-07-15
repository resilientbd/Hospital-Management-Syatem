package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddRoom extends AppCompatActivity {

    EditText roomNumberET,roomTypeET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        init();
    }

    public void onClick_back(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);
    }

    public void onClick_clear() {

        roomNumberET.setText("");
        roomTypeET.setText("");
    }

    public void init() {

        roomNumberET = (EditText) findViewById(R.id.roomNumberEt);
        roomTypeET = (EditText) findViewById(R.id.roomTypeEt);
    }
}
