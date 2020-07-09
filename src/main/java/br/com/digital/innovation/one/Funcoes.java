package br.com.digital.innovation.one;

import java.util.function.Function;

public class Funcoes {

    public static void main(String[] args) {

        //Functions executam uma função que recebem um tipo (T) como parâmetro de entrada e retornam um tipo (R) especificado como segundo parâmetro.

        Function<String,String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        Function<String,Integer> converteStringParaDobroDoInteiro = string -> Integer.parseInt(string) * 2;
        System.out.println(retornarNomeAoContrario.apply("Luís Felipe"));
        System.out.println(converteStringParaDobroDoInteiro.apply("20"));
    }
}
