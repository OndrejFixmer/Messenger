package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String jmeno = "";
        String zprava = "";
        String dalsizprava = "";
        boolean proc = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader("Masáže"));
            String nextLine = br.readLine();
            while (nextLine != null) {
                dalsizprava += nextLine + "\n";
                nextLine = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Moc nekoukej");
        }

        System.out.println("Zadej Jmeno:");
        jmeno = sc.nextLine();
        System.out.println("----------------");
        System.out.println(dalsizprava);
        System.out.println("----------------");
        System.out.println(jmeno + " Nova Zprava: ");
        System.out.println("----------------");

        while (proc) {
            zprava = sc.nextLine();
            if (zprava.equals("!konec")) {
                break;
            }

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("Masáže", true));
                bw.write(jmeno + ": " + zprava);
                bw.newLine();
                bw.close();

            } catch (IOException e) {
                System.out.println("Tak si retard??! Aha sorry, moje chyba. anyways, resetni program");
            }
        }
    }
}

