/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
public class Pelanggan {

    private String id;
    private String nama;

    public Pelanggan(String id, String nama) {
        this.id = id;
        this.nama = nama;

        System.out.println(
            "Objek pelanggan berhasil dibuat: " + nama
        );
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanPelanggan() {
        System.out.println("ID Pelanggan: " + id);
        System.out.println("Nama Pelanggan: " + nama);
    }
}