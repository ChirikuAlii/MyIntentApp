package com.example.chiriku711.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    Button btnPindahAcitivty , btnPindahActivityData , btnPindahWithPojo ,btnDialPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindahAcitivty = findViewById(R.id.btn_pindah_activity);
        btnPindahAcitivty.setOnClickListener(this);

        btnPindahActivityData=findViewById(R.id.btn_pindah_activity_with_data);
        btnPindahActivityData.setOnClickListener(this);

        btnPindahWithPojo = findViewById(R.id.btn_pindah_activity_pojo);
        btnPindahWithPojo.setOnClickListener(this);

        btnDialPhone = findViewById(R.id.btn_pindah_dial);
        btnDialPhone.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pindah_activity:
                Intent moveIntent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(moveIntent);
                break;

            case R.id.btn_pindah_activity_with_data:
               Intent moveWithData = new Intent(MainActivity.this , MoveActivity.class);
               moveWithData.putExtra(MoveActivity.EXTRA_NAME,"Chiriku7");
               startActivity(moveWithData);
               break;

            case R.id.btn_pindah_activity_pojo:
                Intent moveWithPojo = new Intent(MainActivity.this , MoveWithObjectActivity.class);
                //buat object person
                Person person = new Person();

                //input datanya
                person.setName("Chiriku");
                person.setEmail("Chiriku.ali.rhmat@gmail.com");
                person.setAge(20);
                person.setCity("Palu");

                //key gunakan Static dari kelas tujuan
                moveWithPojo.putExtra(MoveWithObjectActivity.EXTTRA_PERSON , person);
                startActivity(moveWithPojo);
                break;

            case R.id.btn_pindah_dial:
                String phoneNumber = "082191913449";
                Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dial);



        }
    }
}
