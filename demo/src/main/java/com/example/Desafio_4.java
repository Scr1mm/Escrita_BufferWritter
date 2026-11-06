package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Desafio_4 {
    public static void main(String[] args) {
        
        String dataAuditoria = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        try {
            BufferedReader leitor = new BufferedReader(
                    new FileReader("hosts.csv"));

            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("inventario_desafio4.csv"));

            String linha = leitor.readLine();
            escritor.write(linha + ",criticidade,data_auditoria");
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

                escritor.write(
                        host + "," +
                        ip + "," +
                        so + "," +
                        criticidade + "," +
                        dataAuditoria);   
                escritor.newLine();
            }

            leitor.close();
            escritor.close();

            System.out.println("Desafio 4: inventario_desafio4.csv gerado em "
                    + dataAuditoria + "!");

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
