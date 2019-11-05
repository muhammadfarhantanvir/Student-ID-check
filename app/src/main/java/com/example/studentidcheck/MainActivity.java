package com.example.studentidcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText studentID;
    Button btnSubmit, btnSubmit2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentID = findViewById(R.id.studentID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        btnSubmit2 = findViewById(R.id.btnSubmit2);

        tvResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "You press Submit", Toast.LENGTH_SHORT).show();
                String id = studentID.getText().toString();
                if(id.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter your Student ID", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String tempDept = id.substring(0,3);
                    String tempSemester = id.substring(3, 6);
                    String dept="", semester="";
                    if(tempDept.matches("011"))
                    {
                        dept = "Dept. of CSE";
                    }
                    else if(tempDept.matches("021"))
                    {
                        dept = "Dept. of EEE";
                    }
                    else if(tempDept.matches("111"))
                    {
                        dept = "Dept. of BBA";
                    }

                    if(tempSemester.matches("152"))
                    {
                        semester = "Summer 2015";
                    }
                    else if(tempSemester.matches("153"))
                    {
                        semester = "Fall 2015";
                    }

                    String result="You are from "+ dept + " and your enrolled semester: "+semester;
                    tvResult.setText(result);

                    tvResult.setVisibility(View.VISIBLE);

                }

            }
        });

        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = studentID.getText().toString();
                Intent intent = new Intent(MainActivity.this, com.example.studentidcheck.MainActivity2.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
