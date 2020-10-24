package com.midmax.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText Title;
    Button button;
    RecyclerView recyclerView;
    Context context;
    ArrayList<Model> arraylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        int itemPosition = recyclerView.getChildLayoutPosition(view);
                        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                        intent.putExtra("Name",arraylist.get(itemPosition).getStudent_Name());
                        intent.putExtra("Rollno",arraylist.get(itemPosition).getRoll_no());
                        intent.putExtra("Age",arraylist.get(itemPosition).getAge());
                        intent.putExtra("Phoneno",arraylist.get(itemPosition).getPhone_no());
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(),"Long Press",Toast.LENGTH_SHORT).show();
                    }
                })
        );
//        Title=findViewById(R.id.input);
//        button=findViewById(R.id.button);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        arraylist = (ArrayList<Model>) args.getSerializable("ARRAYLIST");
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String getInput= Title.getText().toString();
//                if(arrayList.contains(getInput)){
//                    Toast.makeText(getApplicationContext(),"Language Already Added To The Array!",Toast.LENGTH_SHORT).show();
//                }
//                else if(getInput==null || getInput.trim().equals("")){
//                    Toast.makeText(getApplicationContext(),"Input Field is Empty!",Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    arrayList.add(new Model(getInput));
//                    ((EditText) findViewById(R.id.input)).setText("");
//                }
//                Title.onEditorAction(EditorInfo.IME_ACTION_DONE);
//            }
//        });



//        arrayList.add(new Model("C++"));
//        arrayList.add(new Model("Java"));
//        arrayList.add(new Model("FORTRAN"));
//        arrayList.add(new Model("COBOL"));
//        arrayList.add(new Model("C#"));
//        arrayList.add(new Model("PYTHON"));

        TestAdapter adapter=new TestAdapter(arraylist,this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}