package br.com.screenmatch.principal;

import java.io.FileWriter;

public class Teste {

    public static void main(String[] args) {

                try {
                    FileWriter writer = new FileWriter("arquivo");

                    writer.write("Hello");
                    writer.close();
                    writer.write(" World!");
                    writer.close();
                } catch (Exception e) {
                    System.out.println("Erro!");
                }

    }
}
