/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Projekkasir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Kasir> daftarKasir = new ArrayList<>();

        int jumlahMember = 0;
        int jumlahHarian = 0;
        double totalPendapatan = 0;

        System.out.println("======================================");
        System.out.println("          SISTEM KASIR GYM");
        System.out.println("======================================");

        System.out.print("Masukkan jumlah orang : ");
        int jumlahOrang = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= jumlahOrang; i++) {

            System.out.println("\nOrang ke-" + i);

            System.out.print("Nama : ");
            String nama = input.nextLine();

            System.out.println("Pilihan:");
            System.out.println("1. Harian  - Rp20.000");
            System.out.println("2. Member  - Rp150.000");
            System.out.print("Pilih : ");
            int pilihan = input.nextInt();
            input.nextLine();

            Kasir kasir;

            if (pilihan == 1) {
                kasir = new KasirHarian(nama);
                jumlahHarian++;
            } else if (pilihan == 2) {
                kasir = new KasirMember(nama);
                jumlahMember++;
            } else {
                System.out.println("Pilihan tidak tersedia.");
                i--;
                continue;
            }

            kasir.prosesPembayaran();
            daftarKasir.add(kasir);

            totalPendapatan += kasir.getHarga();

            System.out.println("Pembayaran berhasil!");
        }

        System.out.println("\n======================================");
        System.out.println("             DATA KASIR");
        System.out.println("======================================");

        for (Kasir kasir : daftarKasir) {
            kasir.tampilkanData();
            System.out.println("--------------------------------------");
        }

        System.out.println("Jumlah Member Bulanan : " + jumlahMember);
        System.out.println("Jumlah Gym Harian     : " + jumlahHarian);
        System.out.println("Total Orang           : "
                + Kasir.getTotalTransaksi());
        System.out.println("Total Pendapatan      : Rp"
                + totalPendapatan);

        System.out.println("======================================");

        input.close();
    }
}
