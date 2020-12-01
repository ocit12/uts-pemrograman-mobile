package com.uts.katalogsepatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnSport,btnKantor,btnPesta;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnKantor = findViewById(R.id.btn_buka_kantor);
        btnPesta = findViewById(R.id.btn_buka_pesta);
        btnSport = findViewById(R.id.btn_buka_sport);
        btnSport.setOnClickListener(view -> bukaGaleri("Sport"));
        btnPesta.setOnClickListener(view -> bukaGaleri("Pesta"));
        btnKantor.setOnClickListener(view -> bukaGaleri("Kantor"));
    }

    private void bukaGaleri(String merekHp) {
        Log.d("MAIN","Buka activity kantor");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, merekHp);
        startActivity(intent);
    }

}