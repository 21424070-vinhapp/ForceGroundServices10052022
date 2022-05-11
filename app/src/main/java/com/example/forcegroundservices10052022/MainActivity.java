package com.example.forcegroundservices10052022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtnStartServices, mBtnStopServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mBtnStartServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyServices.class);
                intent.putExtra("text","hello");
                startService(intent);
                //Log.d("BBB","Hello");
            }
        });

        mBtnStopServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyServices.class);
                stopService(intent);
            }
        });
    }

    private void init()
    {
        mBtnStartServices=findViewById(R.id.btnStartServices);
        mBtnStopServices=findViewById(R.id.btnStopServices);
    }
}