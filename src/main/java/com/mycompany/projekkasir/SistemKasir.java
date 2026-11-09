package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SistemKasir {

    private ArrayList<Kasir> daftarKasir;
    private HashMap<String, Pelanggan> dataPelanggan;

    private Fasilitas fasilitas;

    public SistemKasir() {
        daftarKasir = new ArrayList<>();
        dataPelanggan = new HashMap<>();

        fasilitas = new Fasilitas("Gym Sehat");

        System.out.println("Sistem kasir berhasil dibuat.");
    }

    public void tambahPelanggan(Pelanggan pelanggan)
            throws DataTidakValidException {

        if (pelanggan == null) {
            throw new DataTidakValidException(
                "Objek pelanggan tidak boleh kosong!"
            );
        }

        if (pelanggan.getId().trim().isEmpty()
                || pelanggan.getNama().trim().isEmpty()) {
            throw new DataTidakValidException(
                "ID dan nama pelanggan wajib diisi!"
            );
        }

        if (dataPelanggan.containsKey(pelanggan.getId())) {
            throw new DataTidakValidException(
                "ID pelanggan sudah terdaftar!"
            );
        }

        dataPelanggan.put(
            pelanggan.getId(), pelanggan
        );

        System.out.println(
            "Pelanggan berhasil dimasukkan ke sistem."
        );
    }

    public void tambahTransaksi(Kasir kasir)
            throws DataTidakValidException {

        if (kasir == null) {
            throw new DataTidakValidException(
                "Objek transaksi tidak boleh kosong!"
            );
        }

        if (!dataPelanggan.containsKey(kasir.getId())) {
            throw new DataTidakValidException(
                "Pelanggan harus didaftarkan terlebih dahulu!"
            );
        }

        for (Kasir data : daftarKasir) {
            if (data.getId().equals(kasir.getId())) {
                throw new DataTidakValidException(
                    "Transaksi untuk ID ini sudah terdaftar!"
                );
            }
        }

        daftarKasir.add(kasir);
        kasir.prosesPembayaran();

        System.out.println(
            "Transaksi berhasil disimpan ke ArrayList."
        );
    }

    public Pelanggan cariPelanggan(String id)
            throws DataTidakValidException {

        if (!dataPelanggan.containsKey(id)) {
            throw new DataTidakValidException(
                "Pelanggan tidak ditemukan!"
            );
        }

        return dataPelanggan.get(id);
    }

    public void tampilkanDaftarTransaksi() {

        if (daftarKasir.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\n===== DAFTAR TRANSAKSI =====");

        for (Kasir kasir : daftarKasir) {

            kasir.tampilkanData();

            if (kasir instanceof Pembayaran) {
                Pembayaran pembayaran = (Pembayaran) kasir;
                pembayaran.cetakBuktiPembayaran();
            }

            if (kasir instanceof Keanggotaan) {
                Keanggotaan keanggotaan =
                        (Keanggotaan) kasir;
                keanggotaan.cekStatusKeanggotaan();
            }

            System.out.println("-----------------------------");
        }

        System.out.println(
            "Jumlah transaksi: " + daftarKasir.size()
        );

        System.out.println(
            "Total pendapatan: Rp" + hitungPendapatan()
        );
    }

    public void tampilkanDaftarPelanggan() {

        if (dataPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan.");
            return;
        }

        System.out.println("\n===== DATA PELANGGAN HASHMAP =====");

        for (Map.Entry<String, Pelanggan> data
                : dataPelanggan.entrySet()) {

            System.out.println("Key ID: " + data.getKey());

            System.out.println(
                "Value Nama: " + data.getValue().getNama()
            );

            System.out.println("-----------------------------");
        }

        System.out.println(
            "Jumlah pelanggan: " + dataPelanggan.size()
        );
    }

    public double hitungPendapatan() {

        double total = 0;

        for (Kasir kasir : daftarKasir) {
            total += kasir.getHarga();
        }

        return total;
    }

    public Fasilitas getFasilitas() {
        return fasilitas;
    }

    public int getJumlahPelanggan() {
        return dataPelanggan.size();
    }

    public int getJumlahTransaksi() {
        return daftarKasir.size();
    }
}