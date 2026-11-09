/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Projekkasir {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        SistemKasir sistem = new SistemKasir();
        ProsesTransaksi proses = new ProsesTransaksi();

        try {
            Pelanggan p1 = new Pelanggan("G001", "Andi");
            Pelanggan p2 = new Pelanggan("G002", "Budi");
            Pelanggan p3 = new Pelanggan("G003", "Citra");
            Pelanggan p4 = new Pelanggan("G004", "Dina");

            sistem.tambahPelanggan(p1);
            sistem.tambahPelanggan(p2);
            sistem.tambahPelanggan(p3);
            sistem.tambahPelanggan(p4);

            Kasir k1 = new KasirHarian("G001", "Andi");
            Kasir k2 = new KasirMember("G002", "Budi");
            Kasir k3 = new KasirHarian("G003", "Citra");
            Kasir k4 = new KasirMember("G004", "Dina");

            sistem.tambahTransaksi(k1);
            sistem.tambahTransaksi(k2);
            sistem.tambahTransaksi(k3);
            sistem.tambahTransaksi(k4);

            proses.prosesTransaksi(k1, p1);
            proses.prosesTransaksi(k2, p2);
            proses.prosesTransaksi(k3, p3);
            proses.prosesTransaksi(k4, p4);

        } catch (DataTidakValidException e) {
            System.out.println("Error: " + e.getMessage());
        }

        int pilihan = 0;

        do {
            System.out.println("\n==================================");
            System.out.println("          SISTEM KASIR GYM");
            System.out.println("==================================");
            System.out.println("1. Tampilkan semua transaksi");
            System.out.println("2. Tambah transaksi");
            System.out.println("3. Cari pelanggan berdasarkan ID");
            System.out.println("4. Tampilkan daftar pelanggan");
            System.out.println("5. Tampilkan fasilitas gym");
            System.out.println("6. Tampilkan total pendapatan");
            System.out.println("7. Keluar");
            System.out.println("==================================");

            try {
                System.out.print("Pilih menu: ");
                pilihan = input.nextInt();
                input.nextLine();

            } catch (InputMismatchException e) {
                System.out.println(
                    "Error: Pilihan harus berupa angka!"
                );

                input.nextLine();
                pilihan = 0;
            }

            switch (pilihan) {

                case 1:
                    sistem.tampilkanDaftarTransaksi();
                    break;

                case 2:
                    try {
                        System.out.print("Masukkan ID pelanggan: ");
                        String id = input.nextLine();

                        System.out.print("Masukkan nama pelanggan: ");
                        String nama = input.nextLine();

                        System.out.println("\nJenis pembayaran:");
                        System.out.println("1. Gym Harian - Rp20.000");
                        System.out.println("2. Member Bulanan - Rp150.000");

                        System.out.print("Pilih jenis pembayaran: ");
                        int jenis = input.nextInt();
                        input.nextLine();

                        if (jenis != 1 && jenis != 2) {
                            System.out.println(
                                "Jenis pembayaran tidak valid!"
                            );
                            break;
                        }

                        Pelanggan pelangganBaru =
                                new Pelanggan(id, nama);

                        sistem.tambahPelanggan(pelangganBaru);

                        Kasir kasirBaru;

                        if (jenis == 1) {
                            kasirBaru =
                                    new KasirHarian(id, nama);
                        } else {
                            kasirBaru =
                                    new KasirMember(id, nama);
                        }

                        sistem.tambahTransaksi(kasirBaru);

                        proses.prosesTransaksi(
                            kasirBaru, pelangganBaru
                        );

                        System.out.println(
                            "Transaksi berhasil ditambahkan!"
                        );

                    } catch (InputMismatchException e) {
                        System.out.println(
                            "Error: Input harus berupa angka!"
                        );
                        input.nextLine();

                    } catch (DataTidakValidException e) {
                        System.out.println(
                            "Error: " + e.getMessage()
                        );

                    } finally {
                        System.out.println(
                            "Proses penambahan transaksi selesai."
                        );
                    }
                    break;

                case 3:
                    try {
                        System.out.print(
                            "Masukkan ID pelanggan: "
                        );

                        String idCari = input.nextLine();

                        Pelanggan hasil =
                                sistem.cariPelanggan(idCari);

                        System.out.println("\nData ditemukan:");
                        hasil.tampilkanPelanggan();

                    } catch (DataTidakValidException e) {
                        System.out.println(
                            "Error: " + e.getMessage()
                        );
                    }
                    break;

                case 4:
                    sistem.tampilkanDaftarPelanggan();
                    break;

                case 5:
                    sistem.getFasilitas().tampilkanFasilitas();
                    break;

                case 6:
                    System.out.println(
                        "Jumlah transaksi: "
                        + sistem.getJumlahTransaksi()
                    );

                    System.out.println(
                        "Total pendapatan: Rp"
                        + sistem.hitungPendapatan()
                    );
                    break;

                case 7:
                    System.out.println(
                        "Program kasir gym selesai."
                    );
                    break;

                case 0:
                    System.out.println(
                        "Silakan masukkan pilihan yang valid."
                    );
                    break;

                default:
                    System.out.println(
                        "Menu tidak tersedia!"
                    );
            }

        } while (pilihan != 7);

        input.close();
    }
}