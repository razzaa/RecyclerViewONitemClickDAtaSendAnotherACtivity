package com.midmax.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView Student_Name,
            Roll_no,
            Age,Phone_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle extras=getIntent().getExtras();
        String v1=extras.getString("Name");
        String v2=extras.getString("Rollno");
        String v3=extras.getString("Age");
        String v4=extras.getString("Phoneno");
        Student_Name=findViewById(R.id.name);
        Roll_no=findViewById(R.id.rollno);
        Age=findViewById(R.id.age);
        Phone_no=findViewById(R.id.phoneno);
        Student_Name.setText(v1);
        Roll_no.setText(v2);
        Age.setText(v3);
        Phone_no.setText(v4);
    }
}