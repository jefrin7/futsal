package com.example.bookingfutsal;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Update extends AppCompatActivity {
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
    private SqliteHelper dbDataSource;
    SqliteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_layout);

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

        dbDataSource = new SqliteHelper(getBaseContext());

        tambahbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata(no, nama, tgl, jam, lapngan, biaya, keterangan) values('" +
                        editTextNama.getText().toString() + "','" +
                        editTexttanggalmain.getText().toString() + "','" +
                        editTextjammain1.getText().toString() + "','" +
                        editTextbiaya1.getText().toString() + "','" +
                        editTextketer.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil di booking", Toast.LENGTH_LONG).show();
                utama.ma.RefreshList();
                finish();
            }

        });
    }
}
