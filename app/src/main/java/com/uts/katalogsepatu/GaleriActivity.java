package com.uts.katalogsepatu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.uts.katalogsepatu.sepatu.Sepatu;

public class GaleriActivity extends AppCompatActivity {

    List<Sepatu> sepatus;
    int indeksTampil = 0;
    String merekSepatu;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txMerek,txTipe,txHarga,txDeskripsi,txJudul;
    ImageView ivFotoSepatu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_sepatu);
        Intent intent = getIntent();
        merekSepatu = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        sepatus = DataProvider.getHpsByTipe(this,merekSepatu);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> sepatuPertama());
        btnTerakhir.setOnClickListener(view -> sepatuTerakhir());
        btnSebelumnya.setOnClickListener(view -> sepatuSebelumnya());
        btnBerikutnya.setOnClickListener(view -> sepatuBerikutnya());

        txMerek = findViewById(R.id.txMerek);
        txTipe = findViewById(R.id.txTipe);
        txHarga = findViewById(R.id.txHarga);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoSepatu = findViewById(R.id.gambarSepatu);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macama Sepetu "+merekSepatu);
    }


    private void tampilkanProfil() {
        Sepatu k = sepatus.get(indeksTampil);
        Log.d("KANTOR","Menampilkan kantor "+k.getMerek());
        txMerek.setText(k.getMerek());
        txTipe.setText(k.getTipe());
        txHarga.setText(k.getHarga());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoSepatu.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void sepatuPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void sepatuTerakhir() {
        int posAkhir = sepatus.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void sepatuBerikutnya() {
        if (indeksTampil == sepatus.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void sepatuSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}
