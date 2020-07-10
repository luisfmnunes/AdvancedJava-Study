package br.com.digital.innovation.one.Java11;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionExemplo {
    public static void main(String[] args) {
        //Collection<String> nomes = Arrays.asList("Joao", "Paulo", "Oliveira", "Santos");
        Collection<String> nomes = List.of("Joao", "Paulo", "Oliveira", "Santos"); //Java 11

        System.out.println(nomes);
    }
}
