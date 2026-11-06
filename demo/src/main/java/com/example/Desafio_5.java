package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Desafio_5 {
    public static void main(String[] args) {

        try {
            BufferedReader leitor = new BufferedReader(
                    new FileReader("hosts.csv"));

            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("inventario_desafio5.csv"));

            String linha = leitor.readLine();
            escritor.write(linha + ",criticidade,risco");
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

                int risco;
                switch (criticidade) {
                    case "Alta":
                        risco = 9;
                        break;
                    case "Media":
                        risco = 5;
                        break;
                    case "Baixa":
                        risco = 2;
                        break;
                    default:
                        risco = 1;
                }

                escritor.write(
                        host + "," +
                        ip + "," +
                        so + "," +
                        criticidade + "," +
                        risco);
                escritor.newLine();
            }

            leitor.close();
            escritor.close();

            System.out.println("Desafio 5: inventario_desafio5.csv gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
