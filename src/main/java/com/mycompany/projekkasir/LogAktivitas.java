/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekkasir;

/**
 *
 * @author RaynSaptra
 */
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LogAktivitas {

    private static final String NAMA_FILE = "log_aktivitas.txt";

    public static void catatLog(String aktivitas) {

        try (FileWriter writer =
                new FileWriter(NAMA_FILE, true)) {

            writer.write(aktivitas + System.lineSeparator());

            System.out.println(
                "Log aktivitas berhasil disimpan."
            );

        } catch (IOException e) {
            System.out.println(
                "Gagal menyimpan log: " + e.getMessage()
            );
        }
    }

    public static void tampilkanLog() {

        File file = new File(NAMA_FILE);

        if (!file.exists()) {
            System.out.println("File log belum tersedia.");
            return;
        }

        try (Scanner scanner =
                new Scanner(new FileReader(file))) {

            System.out.println("\n===== RIWAYAT AKTIVITAS =====");

            if (!scanner.hasNextLine()) {
                System.out.println("Belum ada aktivitas.");
                return;
            }

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            System.out.println(
                "Gagal membaca log: " + e.getMessage()
            );
        }
    }
}