package com.example.chiriku711.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveActivity extends AppCompatActivity {

    public static  String EXTRA_NAME = "extra_name";
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        txtResult = findViewById(R.id.txt_result);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String hasil = "Name" + name +" itu";
        txtResult.setText(hasil);
    }
}
