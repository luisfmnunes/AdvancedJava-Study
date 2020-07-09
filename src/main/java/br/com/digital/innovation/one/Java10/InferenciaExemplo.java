package br.com.digital.innovation.one.Java10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class InferenciaExemplo {

    //private var joao = new String("joão"); ERRO: var não pode ser criada a nível de classe, somente em escopo local

    //public void print(var nome); ERRO: var não pode ser usado como parâmetro
    //var soma; soma = 0; ERRO: var não pode ser utilizado em variáveis locais não inicializadas, a inferência ocorre no momento da definição da variável.

    public static void main(String[] args) {
        connectAndPrintURLJavaOracle();
    }

    public static void connectAndPrintURLJavaOracle(){

        try{
            var url = new URL("https://docs.oracle.com/javase/10/language/");
            var urlConnection = url.openConnection();
            try(var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void testar(String nome, String sobrenome) {
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int... numeros) {
        int soma;
        if(numeros.length > 0) {
            soma = 0;
            for(var numero: numeros){
                soma+=numero;
            }

            System.out.println(soma);
        }

    }
}
