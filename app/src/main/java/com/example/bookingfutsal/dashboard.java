package com.example.bookingfutsal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void btnTambahData(View v){
        Intent intent = new Intent(dashboard.this, input.class);
        startActivity(intent);

    }
    public void btnViewData (View view){
        Intent intent = new Intent(dashboard. this, showdata.class);
        startActivity(intent);
    }

    public void btnLogout(View v){
        Intent intent = new Intent(dashboard.this, LoginActivity.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "LOGOUT SUKSES",
                Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}
