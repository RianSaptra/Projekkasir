/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 * 
 *
 * @author RaynSaptra
 */
public class KasirMember extends Kasir
        implements Pembayaran, Keanggotaan {

    private static final double HARGA_MEMBER = 150000;

    public KasirMember(String id, String nama) {
        super(id, nama);
        this.harga = HARGA_MEMBER;
    }

    @Override
    public String getJenisPembayaran() {
        System.out.println("Jenis pembayaran: Member Bulanan");
        return "Member Bulanan";
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Status: Member Aktif");
    }

    @Override
    public void cetakBuktiPembayaran() {
        System.out.println(
            "Bukti pembayaran member untuk "
            + getNama() + " sebesar Rp" + getHarga()
        );
    }

    @Override
    public void cekStatusKeanggotaan() {
        System.out.println(
            "Status keanggotaan "
            + getNama() + ": AKTIF"
        );
    }
}
