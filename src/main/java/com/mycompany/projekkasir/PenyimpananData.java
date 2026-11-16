/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class PenyimpananData {

    private static final String NAMA_FILE = "data_kasir.ser";

    public static void simpanData(SistemKasir sistem) {

        try (FileOutputStream file =
                new FileOutputStream(NAMA_FILE);

             ObjectOutputStream output =
                new ObjectOutputStream(file)) {

            output.writeObject(sistem);

            System.out.println(
                "Data berhasil disimpan ke file "
                + NAMA_FILE
            );

            LogAktivitas.catatLog(
                "Data sistem kasir berhasil disimpan."
            );

        } catch (IOException e) {
            System.out.println(
                "Gagal menyimpan data: " + e.getMessage()
            );
        }
    }

    public static SistemKasir muatData() {

        try (FileInputStream file =
                new FileInputStream(NAMA_FILE);

             ObjectInputStream input =
                new ObjectInputStream(file)) {

            SistemKasir sistem =
                    (SistemKasir) input.readObject();

            System.out.println(
                "Data berhasil dimuat dari file "
                + NAMA_FILE
            );

            LogAktivitas.catatLog(
                "Data sistem kasir berhasil dimuat."
            );

            return sistem;

        } catch (FileNotFoundException e) {
            System.out.println(
                "File penyimpanan belum tersedia."
            );

        } catch (EOFException e) {
            System.out.println(
                "File penyimpanan kosong."
            );

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(
                "Gagal memuat data: " + e.getMessage()
            );
        }

        return null;
    }
}