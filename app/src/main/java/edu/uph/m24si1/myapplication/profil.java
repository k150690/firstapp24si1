package edu.uph.m24si1.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class profil extends AppCompatActivity {
    // 1. Deklarasi variabel
    private EditText edtNamaHewan, edtSpesies, edtUsia, edtBerat;
    private Button btnSimpan, btnBersihkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        // 2. findViewById biasa
        edtNamaHewan = findViewById(R.id.edtNamaHewan);
        edtSpesies = findViewById(R.id.edtSpesies);
        edtUsia = findViewById(R.id.edtUsia);
        edtBerat = findViewById(R.id.edtBerat);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnBersihkan = findViewById(R.id.btnBersihkan);

        // 3. Tombol Simpan
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ambil string input
                String nama = edtNamaHewan.getText().toString();
                String spesies = edtSpesies.getText().toString();
                String strUsia = edtUsia.getText().toString();
                String strBerat = edtBerat.getText().toString();

                // Cek kosong pake if biasa
                if (nama.isEmpty()) {
                    edtNamaHewan.setError("Jangan kosong!");
                    return;
                }
                if (spesies.isEmpty()) {
                    edtSpesies.setError("Jangan kosong!");
                    return;
                }
                if (strUsia.isEmpty()) {
                    edtUsia.setError("Jangan kosong!");
                    return;
                }
                if (strBerat.isEmpty()) {
                    edtBerat.setError("Jangan kosong!");
                    return;
                }

                // Ubah ke angka buat validasi batas
                int usia = Integer.parseInt(strUsia);
                int berat = Integer.parseInt(strBerat);

                // Batasan angka pake if-else standar
                if (usia <= 0 || usia >= 30) {
                    edtUsia.setError("Usia salah!");
                    return;
                }
                if (berat <= 0 || berat >= 100) {
                    edtBerat.setError("Berat salah!");
                    return;
                }

                // Kalau sukses munculin Toast
                Toast.makeText(profil.this, "Data Disimpan!", Toast.LENGTH_SHORT).show();
            }
        });

        // 4. Tombol Bersihkan
        btnBersihkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNamaHewan.setText("");
                edtSpesies.setText("");
                edtUsia.setText("");
                edtBerat.setText("");
            }
        });
    }
}