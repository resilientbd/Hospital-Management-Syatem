package com.example.yeasir.calclutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BloodBankD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_d);
    }

    public void onclick_addDonner(View view) {

        Intent intent = new Intent(this,Donater.class);
        startActivity(intent);

    }

    public void onclick_listDonation(View view) {

        Intent intent = new Intent(this,List_Donation.class);
        startActivity(intent);

    }

    public void onclick_bloodQuantity(View view) {

        Intent intent = new Intent(this,Blood_Quantity.class);
        startActivity(intent);

    }

    public void onclick_backDD(View view) {

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);

    }
}
