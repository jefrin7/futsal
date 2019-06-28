package com.example.bookingfutsal;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class utama extends AppCompatActivity {

    ListView listViewArtist;

    List<Booking> bookingList;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_utama, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.home2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        listViewArtist = (ListView) findViewById(R.id.list_booking);
        bookingList = new ArrayList<>();

        }

    @Override
    protected void onStart() {
        super.onStart();

                BookingList adapter = new BookingList(utama.this, bookingList);
                listViewArtist.setAdapter(adapter);
            }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btnlogoutuser) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("LOGOUT");
            builder.setMessage("Apakah Anda Mau Logout?");
            builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(utama.this, LoginActivity.class);
                    startActivity(intent);
                    onBackPressed();


                }
            });

            builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
        if (id == R.id.btnkeluar) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("KELUAR");
            builder.setMessage("Apakah Anda Mau Keluar?");
            builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
//                    System.exit(0);

                }
            });

            builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            });
            builder.show();

        }
        return super.onOptionsItemSelected(item);
    }
}
