/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
public class Kasir {
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

    public void prosesPembayaran() {
        totalTransaksi++;
    }

    public void prosesPembayaran(int jumlah) {
        totalTransaksi += jumlah;
    }

    public void tampilkanData() {
        System.out.println("Nama  : " + this.nama);
        System.out.println("Harga : Rp" + this.harga);
    }

    public static int getTotalTransaksi() {
        return totalTransaksi;
    }
}
