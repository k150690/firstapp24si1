package edu.uph.m24si1.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menu extends AppCompatActivity {
    private LinearLayout llWelcome, llMenu;
    private Button btnProfil, btnPakan, btnDokter, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        llWelcome = findViewById(R.id.llWelcome);
        llMenu = findViewById(R.id.llMenu);
        btnProfil = findViewById(R.id.btnProfil);
        btnPakan = findViewById(R.id.btnPakan);
        btnDokter = findViewById(R.id.btnDokter);
        btnLogout = findViewById(R.id.btnLogout);

        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), profil.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Buat Builder untuk AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(menu.this);

                // 2. Set Judul dan Pesan Pop-up
                builder.setTitle("Konfirmasi Keluar");
                builder.setMessage("Apakah kamu yakin ingin logout?");

                // 3. Atur Tombol "YES" (Aksi kalau jadi keluar)
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Pindah kembali ke halaman LoginActivity
                        Intent intent = new Intent(menu.this, trial.class);
                        startActivity(intent);
                        finish(); // Tutup halaman menu supaya ga bisa di-back
                    }
                });

                // 4. Atur Tombol "NO" (Aksi kalau gak jadi/batal)
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Tutup pop-up saja dan kembali ke halaman menu
                        dialogInterface.dismiss();
                    }
                });

                // 5. MEMUNCULKAN ALERT DIALOG-NYA (Jangan sampai lupa baris ini!)
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}