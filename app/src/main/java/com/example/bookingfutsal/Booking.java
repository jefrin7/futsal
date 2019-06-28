package com.example.bookingfutsal;

public class Booking {
    String idbooking;
    String nama;
    String jammain;
    String lapangan;
    String biaya;
    String keterangan;


    public Booking(String idbooking, String nama, String jammain, String lapangan, String biaya, String keterangan) {
        this.idbooking = idbooking;
        this.nama = nama;
        this.jammain = jammain;
        this.lapangan = lapangan;
        this.biaya = biaya;
        this.keterangan = keterangan;
    }

    public String getIdbooking() {
        return idbooking;
    }

    public String getNama() {
        return nama;
    }

    public String getJammain() {
        return jammain;
    }

    public String getLapangan() {
        return lapangan;
    }

    public String getBiaya() {
        return biaya;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public Booking (){ }  ;
}

