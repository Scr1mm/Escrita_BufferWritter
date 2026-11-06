package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Desafio_3 {
    public static void main(String[] args) {

        int totalCriticos = 0;

        try {
            BufferedReader leitor = new BufferedReader(
                    new FileReader("hosts.csv"));

            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("inventario_desafio3.csv"));

        
            BufferedWriter escritorCriticos = new BufferedWriter(
                    new FileWriter("hosts_criticos.csv"));

            String linha = leitor.readLine();
            String novoCabecalho = linha + ",criticidade";

            escritor.write(novoCabecalho);
            escritor.newLine();

            escritorCriticos.write(novoCabecalho); 
            escritorCriticos.newLine();

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

                String registro = host + "," + ip + "," + so + "," + criticidade;

               
                escritor.write(registro);
                escritor.newLine();

                
                if (criticidade.equals("Alta")) {
                    escritorCriticos.write(registro);
                    escritorCriticos.newLine();
                    totalCriticos++;
                }
            }

            leitor.close();
            escritor.close();
            escritorCriticos.close(); 

            System.out.println("Desafio 3: inventario_desafio3.csv gerado com sucesso!");
            System.out.println("Desafio 3: hosts_criticos.csv gerado com "
                    + totalCriticos + " host(s) critico(s).");

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
