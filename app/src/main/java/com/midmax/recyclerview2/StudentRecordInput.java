package com.midmax.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentRecordInput extends AppCompatActivity {

    Button save, show;
    EditText Student_Name,
            Roll_no,
            Age,Phone_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_record_input);
        save=findViewById(R.id.save);
        show=findViewById(R.id.show);
        Student_Name=findViewById(R.id.name);
        Roll_no=findViewById(R.id.rollno);
        Roll_no.setInputType(InputType.TYPE_CLASS_NUMBER);
        Age=findViewById(R.id.age);
        Age.setInputType(InputType.TYPE_CLASS_NUMBER);
        Phone_no=findViewById(R.id.phoneno);
        Phone_no.setInputType(InputType.TYPE_CLASS_NUMBER);
        final ArrayList<Model> arrayList=new ArrayList<>();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= Student_Name.getText().toString();
                String roll= Roll_no.getText().toString();
                String ag= Age.getText().toString();
                String phone= Phone_no.getText().toString();
                if(arrayList.contains(name) && arrayList.contains(roll) && arrayList.contains(ag) && arrayList.contains(phone) ){
                    Toast.makeText(getApplicationContext(),"Record Already Added To The Array!",Toast.LENGTH_SHORT).show();
                }
                else if(name==null || name.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter Name!",Toast.LENGTH_SHORT).show();
                }
                else if(roll==null || roll.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter Roll Number!",Toast.LENGTH_SHORT).show();
                }
                else if(ag==null || ag.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter Age!",Toast.LENGTH_SHORT).show();
                }
                else if(phone==null || phone.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter Phone Number!",Toast.LENGTH_SHORT).show();
                }
                else{
                    arrayList.add(new Model(name,roll,ag,phone));
                    ((EditText) findViewById(R.id.name)).setText("");
                    ((EditText) findViewById(R.id.rollno)).setText("");
                    ((EditText) findViewById(R.id.age)).setText("");
                    ((EditText) findViewById(R.id.phoneno)).setText("");
                }
                Student_Name.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if(arrayList.size()>4)
                {
                    show.setEnabled(true);
                }
            }

        });

         show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(StudentRecordInput.this,MainActivity.class);
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST",(Serializable)arrayList);
                    intent.putExtra("BUNDLE",args);
                    startActivity(intent);
                }
            });
    }
}