package com.example.studentidcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textViewID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String id = getIntent().getStringExtra("id");
        textViewID = findViewById(R.id.textViewID);
        textViewID.setText("You have typed "+ id);
    }
}
