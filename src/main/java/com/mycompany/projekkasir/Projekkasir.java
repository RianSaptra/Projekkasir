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
import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;

public class Projekkasir {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Kasir> daftarKasir = new ArrayList<>();
        HashMap<String, Kasir> dataKasir = new HashMap<>();

        try {
            simpanTransaksi("G001", "Andi", 1,
                    daftarKasir, dataKasir);

            simpanTransaksi("G002", "Budi", 2,
                    daftarKasir, dataKasir);

            simpanTransaksi("G003", "Citra", 1,
                    daftarKasir, dataKasir);

            simpanTransaksi("G004", "Dina", 2,
                    daftarKasir, dataKasir);

        } catch (DataTidakValidException e) {
            System.out.println("Error data awal: " + e.getMessage());

        } finally {
            System.out.println("Inisialisasi data selesai.");
        }

        int pilihan = 0;

        do {
            System.out.println("\n================================");
            System.out.println("         SISTEM KASIR GYM");
            System.out.println("================================");
            System.out.println("1. Tampilkan semua data transaksi");
            System.out.println("2. Tambah transaksi");
            System.out.println("3. Cari pelanggan berdasarkan ID");
            System.out.println("4. Tampilkan semua data HashMap");
            System.out.println("5. Keluar");
            System.out.println("================================");

            try {
                System.out.print("Pilih menu: ");
                pilihan = input.nextInt();
                input.nextLine();

            } catch (InputMismatchException e) {
                System.out.println(
                    "Error: Menu harus diisi dengan angka!"
                );

                input.nextLine();
                pilihan = 0;

            } finally {
                System.out.println("Pemeriksaan input menu selesai.");
            }

            switch (pilihan) {

                case 1:
                    tampilkanSemuaData(daftarKasir);
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

                        simpanTransaksi(
                            id, nama, jenis,
                            daftarKasir, dataKasir
                        );

                        System.out.println(
                            "Transaksi berhasil ditambahkan!"
                        );

                    } catch (InputMismatchException e) {
                        System.out.println(
                            "Error: Jenis pembayaran harus berupa angka!"
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
                            "Masukkan ID pelanggan yang dicari: "
                        );

                        String idCari = input.nextLine();

                        Kasir hasil = cariData(idCari, dataKasir);

                        System.out.println("\nData ditemukan:");
                        hasil.tampilkanData();

                    } catch (DataTidakValidException e) {
                        System.out.println(
                            "Error pencarian: " + e.getMessage()
                        );

                    } finally {
                        System.out.println(
                            "Proses pencarian selesai."
                        );
                    }
                    break;

                case 4:
                    tampilkanHashMap(dataKasir);
                    break;

                case 5:
                    System.out.println(
                        "Program kasir gym selesai."
                    );
                    break;

                case 0:
                    System.out.println(
                        "Silakan masukkan pilihan menu yang valid."
                    );
                    break;

                default:
                    System.out.println(
                        "Menu tidak tersedia!"
                    );
            }

        } while (pilihan != 5);

        input.close();
    }

    public static void simpanTransaksi(
            String id,
            String nama,
            int jenis,
            ArrayList<Kasir> daftarKasir,
            HashMap<String, Kasir> dataKasir)
            throws DataTidakValidException {

        if (id.trim().isEmpty()) {
            throw new DataTidakValidException(
                "ID pelanggan tidak boleh kosong!"
            );
        }

        if (nama.trim().isEmpty()) {
            throw new DataTidakValidException(
                "Nama pelanggan tidak boleh kosong!"
            );
        }

        if (dataKasir.containsKey(id)) {
            throw new DataTidakValidException(
                "ID pelanggan sudah terdaftar!"
            );
        }

        Kasir kasirBaru;

        if (jenis == 1) {
            kasirBaru = new KasirHarian(id, nama);

        } else if (jenis == 2) {
            kasirBaru = new KasirMember(id, nama);

        } else {
            throw new DataTidakValidException(
                "Jenis pembayaran tidak valid!"
            );
        }

        daftarKasir.add(kasirBaru);
        dataKasir.put(id, kasirBaru);

        kasirBaru.prosesPembayaran();
    }

    public static Kasir cariData(
            String id,
            HashMap<String, Kasir> dataKasir)
            throws DataTidakValidException {

        if (id.trim().isEmpty()) {
            throw new DataTidakValidException(
                "ID pencarian tidak boleh kosong!"
            );
        }

        if (!dataKasir.containsKey(id)) {
            throw new DataTidakValidException(
                "Data pelanggan dengan ID " + id
                + " tidak ditemukan!"
            );
        }

        return dataKasir.get(id);
    }

    public static void tampilkanSemuaData(
            ArrayList<Kasir> daftarKasir) {

        if (daftarKasir.isEmpty()) {
            System.out.println("Belum ada data transaksi.");
            return;
        }

        System.out.println("\n======= DAFTAR TRANSAKSI =======");

        for (Kasir kasir : daftarKasir) {

            kasir.tampilkanData();

            if (kasir instanceof Pembayaran) {
                Pembayaran pembayaran = (Pembayaran) kasir;
                pembayaran.cetakBuktiPembayaran();
            }

            if (kasir instanceof Keanggotaan) {
                Keanggotaan keanggotaan = (Keanggotaan) kasir;
                keanggotaan.cekStatusKeanggotaan();
            }

            System.out.println("--------------------------------");
        }

        System.out.println("Jumlah transaksi: "
                + daftarKasir.size());

        System.out.println("Total pendapatan: Rp"
                + hitungPendapatan(daftarKasir));
    }

    public static void tampilkanHashMap(
            HashMap<String, Kasir> dataKasir) {

        if (dataKasir.isEmpty()) {
            System.out.println("HashMap masih kosong.");
            return;
        }

        System.out.println("\n======= DATA HASHMAP =======");

        for (Map.Entry<String, Kasir> data
                : dataKasir.entrySet()) {

            System.out.println("Key (ID): " + data.getKey());
            System.out.println(
                "Value (Nama): " + data.getValue().getNama()
            );

            System.out.println(
                "Jenis: " + data.getValue().getJenisPembayaran()
            );

            System.out.println(
                "Harga: Rp" + data.getValue().getHarga()
            );

            System.out.println("--------------------------------");
        }

        System.out.println("Jumlah data HashMap: "
                + dataKasir.size());
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
