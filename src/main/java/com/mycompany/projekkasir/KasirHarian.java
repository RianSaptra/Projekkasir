/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
public class KasirHarian extends Kasir {
    private static final double HARGA_HARIAN = 20000;
    private int jumlahHarian;

    public KasirHarian(String nama) {
        super(nama);
        this.harga = HARGA_HARIAN;
        this.jumlahHarian = 1;
    }

    public int getJumlahHarian() {
        return jumlahHarian;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Jenis : Gym Harian");
    }
}
