/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
public class KasirMember extends Kasir {
    private static final double HARGA_MEMBER = 150000;
    private int jumlahMember;

    public KasirMember(String nama) {
        super(nama);
        this.harga = HARGA_MEMBER;
        this.jumlahMember = 1;
    }

    public int getJumlahMember() {
        return jumlahMember;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Jenis : Member Bulanan");
        System.out.println("Status: Member Aktif Aguuuuy");
    }
}
