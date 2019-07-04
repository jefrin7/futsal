package com.example.bookingfutsal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class showdata extends AppCompatActivity {

    DBDataSource dbHelper;
    EditText editTextNama;
    EditText editTexttanggalmain;
    EditText editTextbiaya1;
    EditText editTextketer;
    EditText editTextjammain1;
    Spinner spinlapangan;
    Button tambahbooking;
    Button resetAllForm;
    Button lihatData;

    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdata_layout);
        dbHelper = new DBDataSource(this);
        editTextNama = (EditText) findViewById(R.id.nama_pembooking);
        editTexttanggalmain = (EditText) findViewById(R.id.tanggalmain);
        editTextjammain1 = (EditText) findViewById(R.id.jammain);
        editTextketer = (EditText) findViewById(R.id.keterangan);
        editTextbiaya1 = (EditText) findViewById(R.id.biaya);
        spinlapangan = (Spinner) findViewById(R.id.spinner_lapangan);
        tambahbooking = (Button) findViewById(R.id.buttontambah);
        resetAllForm = (Button) findViewById(R.id.button_reset_form);
        lihatData = (Button) findViewById(R.id.btnlihatdata);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = ((SQLiteDatabase) db).rawQuery("SELECT * FROM booking WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            editTextNama.setText(cursor.getString(0).toString());
            editTexttanggalmain.setText(cursor.getString(1).toString());
            editTextjammain1.setText(cursor.getString(2).toString());
            editTextbiaya1.setText(cursor.getString(3).toString());
            editTextketer.setText(cursor.getString(4).toString());
        }
    }
}