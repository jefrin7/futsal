package com.example.bookingfutsal;

class DataFilter {

    private String namapemboking;
    private String tanggalbooking;
    private String jambooking;
    private String biayabooking;
    private String lapangan;
    private String keterangan;

    DataFilter(String nama, String tanggal, String jam, String biaya, String lapangan, String keterangan1) {
        this.namapemboking = nama;
        this.tanggalbooking = tanggal;
        this.jambooking = jam;
        this.biayabooking = biaya;
        this.lapangan = lapangan;
        this.keterangan = keterangan1;
    }

    public String getNamapemboking() {
        return namapemboking;
    }

    public String getTanggalbooking() {
        return tanggalbooking;
    }

    public String getJambooking() {
        return jambooking;
    }

    public String getBiayabooking() { return biayabooking; }

    public String getLapangan() { return lapangan; }

    public String getKeterangan() { return keterangan; }
}