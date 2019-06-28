package com.example.bookingfutsal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class input extends AppCompatActivity {

    EditText editTextNama;
    EditText editTextbiaya1;
    EditText editTextketer;
    EditText editTextjammain1;
    Spinner spinlapangan;
    Button tambahbooking;
    Button resetbooking;
    Button resetAllForm;
    Button lihatData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        editTextNama = (EditText) findViewById(R.id.nama_pembooking);
        editTextjammain1 = (EditText) findViewById(R.id.jammain);
        editTextketer = (EditText) findViewById(R.id.keterangan);
        editTextbiaya1 = (EditText) findViewById(R.id.biaya);

        spinlapangan = (Spinner) findViewById(R.id.spinner_lapangan);
        tambahbooking = (Button) findViewById(R.id.buttontambah);
        resetbooking = (Button) findViewById(R.id.resetbooking) ;
        resetAllForm = (Button) findViewById(R.id.button_reset_form);
        lihatData = (Button) findViewById(R.id.btnlihatdata);

        tambahbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addbooking();

            }
        });

        resetbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearDeskripsi();
            }
        });

        resetAllForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllForm();
            }
        });

        lihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(input.this, showdata.class);
                startActivity(intent);
            }
        });
    }

    private void clearAllForm(){
        editTextNama.getText().clear();
        editTextjammain1.getText().clear();
        editTextketer.getText().clear();
        editTextbiaya1.getText().clear();
        spinlapangan.setSelection(0);

    }

    private void clearDeskripsi(){
        editTextjammain1.getText().clear();
    }

    private void addbooking(){
        String nama = editTextNama.getText().toString().trim();
        String jam = editTextjammain1.getText().toString().trim();
        String keterangan = editTextketer.getText().toString().trim();
        String biaya = editTextbiaya1.getText().toString().trim();
        String lap = spinlapangan.getSelectedItem().toString();

        if (!TextUtils.isEmpty(nama)||
                !TextUtils.isEmpty(nama)||
                !TextUtils.isEmpty(jam)||
                !TextUtils.isEmpty(keterangan)||
                !TextUtils.isEmpty(biaya)||
                !TextUtils.isEmpty(lap)
                ){
            Toast.makeText(this, "Data Bookingan Telah Di Inputkan", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Lengkapi Semua Data", Toast.LENGTH_SHORT).show();
        }
    }

}
