package com.example.brian.hackucsc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Spinner start;
    Spinner end;
    TextView result;
    Button request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        start = (Spinner)findViewById(R.id.start);
        end = (Spinner)findViewById(R.id.end);
        result = (TextView)findViewById(R.id.result);
        request = (Button)findViewById(R.id.request);

        String[] items = new String[]{"Base", "Lower Campus", "Village", "East Remote", "East Field House", "Cowell/Stevenson", "Crown/Merrill", "College 9/10 & Health Center", "Science Hill", "Kresge", "College 8/ Porter", "Family Student Housing", "Oakes", "Empire Grade", "Empire Grade/ Tosca Terrace", "High/Western"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        start.setAdapter(adapter);
        end.setAdapter(adapter);

        addData();
    }

    public void addData(){
        request.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    boolean isInserted=myDb.insertData(start.getSelectedItem().toString(), end.getSelectedItem().toString());
                    if (isInserted==true){
                        Toast.makeText(MainActivity.this,"DataInsertedIntoDatabase",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"DataNotInserted",Toast.LENGTH_LONG).show();
                    }
                }
            }
        );
    }

//    public void test(View view){
//        Intent intent = new Intent(this, Activity2.class);
//        startActivity(intent);
////        result.setText("Request Sent");
//
//    }
}
