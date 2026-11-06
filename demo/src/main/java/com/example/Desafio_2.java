package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Desafio_2 {
    public static void main(String[] args) {

        int totalWindows = 0;
        int totalLinux = 0;
        int totalMac = 0;
        int totalOutros = 0;

        try {
            BufferedReader leitor = new BufferedReader(
                    new FileReader("hosts.csv"));

            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("inventario_desafio2.csv"));

            String linha = leitor.readLine();
            escritor.write(linha + ",criticidade");
            escritor.newLine();

            while ((linha = leitor.readLine()) != null) {

                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",");
                String host = dados[0];
                String ip = dados[1];
                String so = dados[2];

                String criticidade;
                if (so.contains("Kali")) {
                    criticidade = "Alta";
                } else if (so.contains("Ubuntu")
                        || so.contains("Debian")
                        || so.contains("Rocky")) {
                    criticidade = "Baixa";
                } else {
                    criticidade = "Media";
                }

           
                String soMinusculo = so.toLowerCase();

                if (soMinusculo.contains("windows")) {
                    totalWindows++;
                } else if (soMinusculo.contains("linux")
                        || soMinusculo.contains("ubuntu")
                        || soMinusculo.contains("debian")
                        || soMinusculo.contains("rocky")
                        || soMinusculo.contains("kali")
                        || soMinusculo.contains("centos")
                        || soMinusculo.contains("fedora")) {
                    totalLinux++;
                } else if (soMinusculo.contains("mac")) {
                    totalMac++;
                } else {
                    totalOutros++;
                }

                escritor.write(
                        host + "," +
                        ip + "," +
                        so + "," +
                        criticidade);
                escritor.newLine();
            }

            leitor.close();
            escritor.close();

            System.out.println("Desafio 2: inventario_desafio2.csv gerado com sucesso!");

            
            System.out.println();
            System.out.println(" Resumo de Sistemas Operacionais ");
            System.out.println("Windows: " + totalWindows);
            System.out.println("Linux:   " + totalLinux);
            System.out.println("macOS:   " + totalMac);
            if (totalOutros > 0) {
                System.out.println("Outros:  " + totalOutros);
            }
            System.out.println("Total:   "
                    + (totalWindows + totalLinux + totalMac + totalOutros));

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
