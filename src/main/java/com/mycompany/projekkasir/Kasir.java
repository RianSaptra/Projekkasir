/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
public abstract class Kasir {
    private String nama;
    protected double harga;
    protected static int totalTransaksi = 0;

    public Kasir(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public abstract String getJenisPembayaran();

    public void prosesPembayaran() {
        totalTransaksi++;
        System.out.println("Pembayaran berhasil.");
    }

    public void prosesPembayaran(int jumlah) {
        totalTransaksi += jumlah;
        System.out.println(
            "Berhasil memproses " + jumlah + " transaksi."
        );
    }

    public void tampilkanData() {
        System.out.println("Nama  : " + nama);
        System.out.println("Harga : Rp" + harga);
        System.out.println("Jenis : " + getJenisPembayaran());
    }

    public static int getTotalTransaksi() {
        return totalTransaksi;
    }
}
