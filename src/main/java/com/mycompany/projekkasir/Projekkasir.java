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

        daftarKasir.add(new KasirHarian("Andi"));
        daftarKasir.add(new KasirMember("Budi"));
        daftarKasir.add(new KasirHarian("Citra"));
        daftarKasir.add(new KasirMember("Dina"));

        for (Kasir kasir : daftarKasir) {
            kasir.prosesPembayaran();
        }

        int pilihan;

        do {
            System.out.println("\n================================");
            System.out.println("        SISTEM KASIR GYM");
            System.out.println("================================");
            System.out.println("1. Tampilkan semua data");
            System.out.println("2. Tambah transaksi");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n======= DATA KASIR =======");

                    for (Kasir kasir : daftarKasir) {
                        kasir.tampilkanData();

                        if (kasir instanceof Pembayaran) {
                            Pembayaran pembayaran =
                                    (Pembayaran) kasir;
                            pembayaran.cetakBuktiPembayaran();
                        }

                        if (kasir instanceof Keanggotaan) {
                            Keanggotaan keanggotaan =
                                    (Keanggotaan) kasir;
                            keanggotaan.cekStatusKeanggotaan();
                        }

                        System.out.println(
                            "--------------------------------"
                        );
                    }

                    System.out.println("Total transaksi: "
                            + Kasir.getTotalTransaksi());

                    System.out.println("Total pendapatan: Rp"
                            + hitungPendapatan(daftarKasir));
                    break;

                case 2:
                    System.out.print("Masukkan nama: ");
                    String nama = input.nextLine();

                    System.out.println("1. Gym Harian - Rp20.000");
                    System.out.println("2. Member Bulanan - Rp150.000");
                    System.out.print("Pilih jenis pembayaran: ");

                    int jenis = input.nextInt();
                    input.nextLine();

                    Kasir kasirBaru;

                    if (jenis == 1) {
                        kasirBaru = new KasirHarian(nama);
                    } else if (jenis == 2) {
                        kasirBaru = new KasirMember(nama);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                        break;
                    }

                    kasirBaru.prosesPembayaran();
                    daftarKasir.add(kasirBaru);

                    System.out.println(
                        "Transaksi berhasil ditambahkan!"
                    );
                    break;

                case 3:
                    System.out.println("Program kasir selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 3);

        input.close();
    }

    public static double hitungPendapatan(
            ArrayList<Kasir> daftarKasir) {

        double total = 0;

        for (Kasir kasir : daftarKasir) {
            total += kasir.getHarga();
        }

        return total;
    }
}
