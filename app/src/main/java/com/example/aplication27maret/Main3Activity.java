package com.example.aplication27maret;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

   @BindView(R.id.txtNama)
   TextView txtNama;
   @BindView(R.id.txtNpm)
   TextView txtNpm;
   @BindView(R.id.txtNA)
   TextView txtNA;
   @BindView(R.id.txtGrade)
   TextView txtGrade;

   String strnama, strnpm, strna, strgrade;
   double Nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);

        Intent getData = getIntent();
        strnpm =getData.getStringExtra("Npm");
        strnama =getData.getStringExtra("Nama");
        strna =getData.getStringExtra("Nilai");
        strgrade = getData.getStringExtra("Grade");


        txtNpm.setText("NPM           : " + strnpm);
        txtNama.setText("Nama         : " + strnama);
        txtNA.setText("Nilai Akhir  : " + strna);

        Nilai = Double.parseDouble(strna);


        if (Nilai >=80 && Nilai <=100) {
        txtGrade.setText("Grade            : A");
      }else if(Nilai >=65 && Nilai <=79){
          txtGrade.setText("Grade          : B");
      }else if (Nilai >=60 && Nilai <=64){
          txtGrade.setText("Grade          : C");
      }else if (Nilai >=40 && Nilai <=69 ){
          txtGrade.setText("Grade          : D");
      }else {
          txtGrade.setText("Grade          : E");
      }


    }
}
