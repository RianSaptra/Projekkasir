/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
import java.util.ArrayList;

public class Fasilitas {

    private String namaGym;
    private ArrayList<String> daftarFasilitas;

    public Fasilitas(String namaGym) {
        this.namaGym = namaGym;
        this.daftarFasilitas = new ArrayList<>();

        daftarFasilitas.add("Area Fitness");
        daftarFasilitas.add("Ruang Ganti");
        daftarFasilitas.add("Kamar Mandi");
        daftarFasilitas.add("Area Kardio");

        System.out.println("Komponen fasilitas gym berhasil dibuat.");
    }

    public void tampilkanFasilitas() {
        System.out.println("\n===== FASILITAS GYM =====");
        System.out.println("Nama Gym: " + namaGym);

        for (String fasilitas : daftarFasilitas) {
            System.out.println("- " + fasilitas);
        }
    }
}