package com.example.chiriku711.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {

    public static String EXTTRA_PERSON ="extra_person";
    private TextView txtHasilObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        txtHasilObject = findViewById(R.id.txt_hasil_object);
        Person person =getIntent().getParcelableExtra(EXTTRA_PERSON);
        String text =
                "Name:" + person.getName() +
                "\nEmail:" + person.getEmail() +
                "\nCity:" + person.getCity() +
                "\nAge:" + person.getAge() ;

        txtHasilObject.setText(text);
    }
}
