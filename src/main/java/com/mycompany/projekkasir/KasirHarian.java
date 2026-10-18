/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
public class KasirHarian extends Kasir implements Pembayaran {

    private static final double HARGA_HARIAN = 20000;

    public KasirHarian(String nama) {
        super(nama);
        this.harga = HARGA_HARIAN;
    }

    @Override
    public String getJenisPembayaran() {
        System.out.println("Jenis pembayaran: Gym Harian");
        return "Gym Harian";
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Status: Tiket Harian Aktif");
    }

    @Override
    public void cetakBuktiPembayaran() {
        System.out.println(
            "Bukti pembayaran harian untuk "
            + getNama() + " sebesar Rp" + getHarga()
        );
    }
}
