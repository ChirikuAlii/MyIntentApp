package com.example.chiriku711.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    Button btnPindahAcitivty , btnPindahActivityData , btnPindahWithPojo ,btnDialPhone , btnPindahWithResult;
    private TextView tvResult;
    private int REQUEST_CODE = 0;

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

        btnPindahWithResult = findViewById(R.id.btn_pindah_activity_for_result);
        btnPindahWithResult.setOnClickListener(this);


        tvResult = findViewById(R.id.txt_hasil);


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
                break;

            case R.id.btn_pindah_activity_for_result:
                Intent resultIntent = new Intent (MainActivity.this ,MoveActivityWithResult.class);
               startActivityForResult(resultIntent,REQUEST_CODE);
               break;



        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveActivityWithResult.RESULT_CODE ){
                int selectedValue = data.getIntExtra(MoveActivityWithResult.EXTRA_SELECTED_VALUE,0);
                tvResult.setText("Hasil:" + selectedValue);
            }
        }
    }
}

