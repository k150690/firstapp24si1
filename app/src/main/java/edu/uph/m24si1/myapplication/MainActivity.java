package edu.uph.m24si1.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvBiodata = findViewById(R.id.textBiodata);
        tvBiodata.setText(
                "Nama: Anastasia Wilim\n\n" +
                "NIM: 03081240051\n\n" +
                "Fakultas: Fakultas Artificial Intelligence and Data Science\n\n" +
                "Program Studi: Sistem Informasi\n\n" +
                "Konsentrasi: Artificial Intelligence"
        );
    }
}