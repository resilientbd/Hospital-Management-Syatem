package com.example.yeasir.calclutor;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;
    Button bank_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }



    public void onclick_logout(View view) {

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void onclick_patient(View view) {

        Intent intent = new Intent(this,PatientD.class);
        startActivity(intent);

    }

    public void onclick_doctor(View view) {

        Intent intent = new Intent(this,DoctorD.class);
        startActivity(intent);

    }

    public void onclick_nurse(View view) {

        Intent intent = new Intent(this,NursesD.class);
        startActivity(intent);

    }

    public void onclick_report(View view) {

        Intent intent = new Intent(this,ReportsD.class);
        startActivity(intent);

    }

    public void onclick_employee(View view) {

        Intent intent = new Intent(this,EmployeesD.class);
        startActivity(intent);

    }

    public void onclick_bloodBank(View view) {

        Intent intent = new Intent(this,BloodBankD.class);
        startActivity(intent);

    }

    public void onclick_department(View view) {

        Intent intent = new Intent(this,DepartmentD.class);
        startActivity(intent);

    }

    public void onclick_room(View view) {

        Intent intent = new Intent(this,AddRoom.class);
        startActivity(intent);

    }

    public void onclick_search(View view) {

        Intent intent = new Intent(this,Search.class);
        startActivity(intent);

    }

    public void buckysButtonClicked(View view){
        //Build the notification
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("Emergency Call");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("New Emergency");
        notification.setContentText("You have an emergency call on room number : (###) Patient ID: (####)");

        Intent intent = new Intent(this, NotificationF.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

    }

}
