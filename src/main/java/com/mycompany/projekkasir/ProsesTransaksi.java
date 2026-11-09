/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
public class ProsesTransaksi {

    public void prosesTransaksi(
            Kasir kasir,
            Pelanggan pelanggan) {

        if (kasir == null || pelanggan == null) {
            System.out.println(
                "Transaksi gagal: data objek tidak lengkap."
            );
            return;
        }

        if (!kasir.getId().equals(pelanggan.getId())) {
            System.out.println(
                "Transaksi gagal: ID pelanggan tidak cocok."
            );
            return;
        }

        System.out.println("\n===== PROSES TRANSAKSI =====");

        System.out.println(
            "Nama pelanggan: " + pelanggan.getNama()
        );

        System.out.println(
            "ID pelanggan: " + pelanggan.getId()
        );

        System.out.println(
            "Jenis pembayaran: " + kasir.getJenisPembayaran()
        );

        System.out.println(
            "Total pembayaran: Rp" + kasir.getHarga()
        );

        System.out.println(
            "Transaksi berhasil diproses."
        );
    }
}