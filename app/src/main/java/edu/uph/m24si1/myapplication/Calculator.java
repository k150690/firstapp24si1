package edu.uph.m24si1.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {
    private EditText edtnmbrP, edtnmbrK;
    private Button tmbh, krg, kli, bgi;
    private TextView txthasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtnmbrP = findViewById(R.id.edtnmbrP);
        edtnmbrK = findViewById(R.id.edtnmbrK);
        tmbh = findViewById(R.id.tmbh);
        krg = findViewById(R.id.krg);
        kli = findViewById(R.id.kli);
        bgi = findViewById(R.id.bgi);
        txthasil = findViewById(R.id.txthasil);
        tmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nilaipertama, nilaikedua, tambah;
                nilaipertama = Integer.parseInt(edtnmbrP.getText().toString());
                nilaikedua = Integer.parseInt(edtnmbrK.getText().toString());
                tambah = nilaipertama + nilaikedua;
                txthasil.setText(" "+ tambah);
            }
        });

        krg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nilaipertama, nilaikedua, kurang;
                nilaipertama = Integer.parseInt(edtnmbrP.getText().toString());
                nilaikedua = Integer.parseInt(edtnmbrK.getText().toString());
                kurang = nilaipertama - nilaikedua;
                txthasil.setText(" "+ kurang);
            }
        });

        kli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nilaipertama, nilaikedua, kali;
                nilaipertama = Integer.parseInt(edtnmbrP.getText().toString());
                nilaikedua = Integer.parseInt(edtnmbrK.getText().toString());
                kali = nilaipertama * nilaikedua;
                txthasil.setText(" "+ kali);
            }
        });

        bgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nilaipertama, nilaikedua, bagi;
                nilaipertama = Integer.parseInt(edtnmbrP.getText().toString());
                nilaikedua = Integer.parseInt(edtnmbrK.getText().toString());
                bagi = nilaipertama / nilaikedua;
                txthasil.setText(" "+ bagi);
            }
        });

    }
}