package edu.uph.m24si1.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView txvNama;
    private Button btnKeluar;
    private LinearLayout llPersegi, llSegitiga, llLingkaran, llKeluar;
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
        llLingkaran = findViewById(R.id.llLingkaran);
        llSegitiga = findViewById(R.id.llSegitiga);
        llPersegi = findViewById(R.id.llPersegi);
        llKeluar = findViewById(R.id.llKeluar);
        btnKeluar = findViewById(R.id.btnKeluar);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //alert
//                Toast toast = Toast.makeText(view.getContext(),
//                        "Terima Kasih",Toast.LENGTH_LONG);
//                toast.show();
//                finish();
                // 1. Instantiate an AlertDialog.Builder with its constructor.

                ArrayList selectedItems = new ArrayList();  // Where we track the selected items
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                // Set the dialog title.
                builder.setTitle(R.string.dialogname)
                        // Specify the list array, the items to be selected by default (null for
                        // none), and the listener through which to receive callbacks when items
                        // are selected.
                        .setMultiChoiceItems(R.array.planet, null,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which,
                                                        boolean isChecked) {
                                        if (isChecked) {
                                            // If the user checks the item, add it to the selected
                                            // items.
                                            selectedItems.add(which);
                                        } else if (selectedItems.contains(which)) {
                                            // If the item is already in the array, remove it.
                                            selectedItems.remove(which);
                                        }
                                    }
                                })
                        // Set the action buttons
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // User taps OK, so save the selectedItems results
                                // somewhere or return them to the component that opens the
                                // dialog.

                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                builder.show();
            }
        });
        llKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // finish();
                // finishAffinity();
                ArrayList selectedItems = new ArrayList();  // Where we track the selected items
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                // Set the dialog title.
                builder.setTitle(R.string.dialogname)
                        // Specify the list array, the items to be selected by default (null for
                        // none), and the listener through which to receive callbacks when items
                        // are selected.
                        .setMultiChoiceItems(R.array.planet, null,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which,
                                                        boolean isChecked) {
                                        if (isChecked) {
                                            // If the user checks the item, add it to the selected
                                            // items.
                                            selectedItems.add(which);
                                        } else if (selectedItems.contains(which)) {
                                            // If the item is already in the array, remove it.
                                            selectedItems.remove(which);
                                        }
                                    }
                                })
                        // Set the action buttons
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // User taps OK, so save the selectedItems results
                                // somewhere or return them to the component that opens the
                                // dialog.

                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
            }
        });

        llPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PersegiActivity.class);
                startActivity(intent);
            }
        });
        txvNama = findViewById(R.id.txvNama);
//        txvNama.setText("Halo Budi!!!!!!!!");
//        txvNama.setTextSize(18);
//        for(int i =10;i>0;i--){
//            txvNama.setText(" "+i+" ");
//            Log.d("Cek nilai I"," "+i+" ");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}