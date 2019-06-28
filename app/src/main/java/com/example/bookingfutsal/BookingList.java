package com.example.bookingfutsal;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookingList extends ArrayAdapter<Booking> {

    private Activity context;
    private List<Booking> BookingList;

    public BookingList(Activity context, List<Booking> bookingList) {

        super(context, R.layout.showdata_layout, bookingList);
        this.context = context;
        this.BookingList = bookingList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.showdata_layout, null, true);

        TextView textViewNama = (TextView) listViewItem.findViewById(R.id.showpembooking);
        TextView textViewJammain = (TextView) listViewItem.findViewById(R.id.showjam);
        TextView textViewLapangan = (TextView) listViewItem.findViewById(R.id.showlapangan);
        TextView textViewBiaya = (TextView) listViewItem.findViewById(R.id.showbiaya);
        TextView textViewKeterangan = (TextView) listViewItem.findViewById(R.id.showketerangan);

        Booking booking = BookingList.get(position);

        textViewNama.setText(booking.getNama());
        textViewLapangan.setText("Jenis : "+booking.getLapangan());
        textViewBiaya.setText("Rp. : " +booking.getBiaya());
        textViewJammain.setText("Pukul : " +booking.getJammain());
        textViewKeterangan.setText("Keterangan :"+booking.getKeterangan());

        return listViewItem;
    }
}
