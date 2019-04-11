package com.example.aplication27maret;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.edNpm)
    EditText edNpm;
    @BindView(R.id.edNama)
    EditText edNama;
    @BindView(R.id.edTugas)
    EditText edTugas;
    @BindView(R.id.edQuiz)
    EditText edQuiz;
    @BindView(R.id.edUTS)
    EditText edUTS;
    @BindView(R.id.edUAS)
    EditText edUAS;

    String strnpm, strnama;
    double dbltugas, dblkuis, dbluts, dbluas, dblnilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);

        Intent getData = getIntent();
        strnpm =getData.getStringExtra("Npm");
        strnama =getData.getStringExtra("Nama");

        edNpm.setText(strnpm);
        edNama.setText(strnama);
    }

    @OnClick(R.id.btnSubmit)
    void btnSubmit(){
        dbltugas = Double.parseDouble(edTugas.getText().toString());
        dblkuis = Double.parseDouble(edQuiz.getText().toString());
        dbluts = Double.parseDouble(edUTS.getText().toString());
        dbluas = Double.parseDouble(edUAS.getText().toString());

        dblnilai = (dbltugas + dblkuis + dbluts +dbluas) / 4 ;

        Toast.makeText(getApplicationContext(), String.valueOf(dblnilai),
                Toast.LENGTH_LONG).show();

     Intent a = new Intent(Main2Activity.this, Main3Activity.class);
        a.putExtra("Npm", strnpm);
        a.putExtra("Nama", strnama);
        a.putExtra("Nilai", String.valueOf(dblnilai));
     startActivity(a);
     finish();

    }
}

