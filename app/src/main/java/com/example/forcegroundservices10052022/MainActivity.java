package com.example.forcegroundservices10052022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

            }
        });
    }

    private void init()
    {
        mBtnStartServices=findViewById(R.id.btnStartServices);
        mBtnStopServices=findViewById(R.id.btnStopServices);
    }
}