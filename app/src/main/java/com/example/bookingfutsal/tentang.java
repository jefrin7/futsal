package com.example.bookingfutsal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class tentang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setLogo(R.drawable.aboutbutton);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
