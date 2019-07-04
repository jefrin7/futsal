package com.example.bookingfutsal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLData;

public class input extends AppCompatActivity {

    EditText editTextNama;
    EditText editTexttanggalmain;
    EditText editTextbiaya1;
    EditText editTextketer;
    EditText editTextjammain1;
    Spinner spinlapangan;
    Button tambahbooking;
    Button resetAllForm;
    Button lihatData;

    //Variable Untuk Inisialisasi Database DBdatasurce
    private DBDataSource dbDataSource;
    private SqliteHelper dbHelper;
    private String setnamabooking, settanggal, setjam, setlapangan, setbiaya,  setketerangan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        dbHelper = new SqliteHelper(this);
        editTextNama = (EditText) findViewById(R.id.nama_pembooking);
        editTexttanggalmain = (EditText) findViewById(R.id.tanggalmain);
        editTextjammain1 = (EditText) findViewById(R.id.jammain);
        editTextketer = (EditText) findViewById(R.id.keterangan);
        editTextbiaya1 = (EditText) findViewById(R.id.biaya);

        spinlapangan = (Spinner) findViewById(R.id.spinner_lapangan);
        tambahbooking = (Button) findViewById(R.id.buttontambah);
        resetAllForm = (Button) findViewById(R.id.button_reset_form);
        lihatData = (Button) findViewById(R.id.btnlihatdata);

        dbDataSource = new DBDataSource(getBaseContext());

        tambahbooking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO Auto-generated method stub
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into booking(nama, tgl, jam, lapngan, biaya, keterangan) values('" +
                            editTextNama.getText().toString() + "','" +
                            editTexttanggalmain.getText().toString() + "','" +
                            editTextjammain1.getText().toString() + "','" +
                            editTextbiaya1.getText().toString() + "','" +
                            editTextketer.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Berhasil di booking", Toast.LENGTH_LONG).show();
                    utama.ma.RefreshList();
                    clearAllForm();
                    finish();
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
        editTexttanggalmain.getText().clear();
        editTextjammain1.getText().clear();
        editTextketer.getText().clear();
        editTextbiaya1.getText().clear();
        spinlapangan.setSelection(0);

    }
    //Berisi Statement-Statement Untuk Mendapatkan Input Dari User
    private void setData(){
        setnamabooking = editTextNama.getText().toString();
        settanggal = editTexttanggalmain.getText().toString();
        setjam = editTextjammain1.getText().toString();
        setlapangan = spinlapangan.getSelectedItem().toString();
        setbiaya = editTextbiaya1.getText().toString();
        setketerangan = editTextketer.getText().toString();
    }

}

