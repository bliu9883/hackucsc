package com.example.brian.hackucsc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner start = (Spinner)findViewById(R.id.start);
        Spinner end = (Spinner)findViewById(R.id.end);
        String[] items = new String[]{"Base", "Lower Campus", "Village", "East Remote", "East Field House", "Coweel/Stevenson", "Crown/Merrill", "College 9/10 & Health Center", "Science Hill", "Kresge", "College 8/Porter", "Family Student Housing", "Oakes", "Empire Grade", "Empire Grade/Tosca Terrace", "High/Western"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        start.setAdapter(adapter);
        end.setAdapter(adapter);
    }

    public void test(View view){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
