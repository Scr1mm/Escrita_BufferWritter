package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Desafio_1 {
    public static void main(String[] args) {

        try {
            BufferedReader leitor = new BufferedReader(
                    new FileReader("hosts.csv"));

            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("inventario_desafio1.csv"));

     
            String linha = leitor.readLine();
            escritor.write(linha + ",criticidade,status");
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

                
                String status;
                String soMinusculo = so.toLowerCase();

                if (soMinusculo.contains("windows")) {
                    status = "Online";
                } else if (soMinusculo.contains("linux")
                        || soMinusculo.contains("ubuntu")
                        || soMinusculo.contains("debian")
                        || soMinusculo.contains("rocky")
                        || soMinusculo.contains("kali")
                        || soMinusculo.contains("centos")
                        || soMinusculo.contains("fedora")) {
                    status = "Em Monitoramento";
                } else {
                    status = "Nao Definido"; 
                }

                escritor.write(
                        host + "," +
                        ip + "," +
                        so + "," +
                        criticidade + "," +
                        status);
                escritor.newLine();
            }

            leitor.close();
            escritor.close();

            System.out.println("Desafio 1: inventario_desafio1.csv gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
