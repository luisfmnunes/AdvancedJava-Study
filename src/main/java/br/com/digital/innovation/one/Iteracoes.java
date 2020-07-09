package br.com.digital.innovation.one;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

    public static void main(String[] args) {
        String[] nomes = {"Joao","Paulo","Oliveira","Santos","Instrutor", "Java","Joao"};
        Integer[] numeros = {1,2,3,4,5};
        imprimirNomesFiltrados(nomes);
        imprimirNomesStream(nomes);

        imprimirTodosNomes(nomes);
        imprimirTodosNomesStream(nomes);

        //Integer[] dobro = retornarDobro(numeros);
        Integer[] dobro = retornarDobroStream(numeros);

    }

    public static void imprimirNomesFiltrados(String... nomes) {
        String nomesParaImprimir = "";
        for (int i=0; i < nomes.length; i++) {
            if (nomes[i].equals("Joao")){
                nomesParaImprimir += "" + nomes[i];
            }
        }

        System.out.println("Nomes do for: " + nomesParaImprimir);
    }

    public static void imprimirNomesStream(String... nomes) {
       System.out.println("Nomes do Stream: " + Arrays.stream(nomes).filter(nome -> nome == "Joao").collect(Collectors.joining()));
    }

    public static void imprimirTodosNomes(String... nomes) {
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Imprimindo pelo for: " + nomes[i]);
        }
    }

    public static void imprimirTodosNomesStream(String... nomes) {
        Stream.of(nomes).forEach(System.out::println);
    }

    public static Integer[] retornarDobro(Integer... valores) {
        Integer[] retorno;
        retorno = (Integer[]) Array.newInstance(Integer.class,valores.length);

        for (int i = 0; i < valores.length; i++ ) {
            retorno[i] = valores[i]*2;
            System.out.println("Imprimindo por For: " + retorno[i]);
        }

        return retorno;
    }

    public static Integer[] retornarDobroStream(Integer... valores) {
        List<Integer> retorno = Stream.of(valores)
                .map(valor -> + valor * 2)
                .collect(Collectors.toList());
        retorno.forEach(valor -> System.out.println("Imprimindo por Stream: " + valor));

        Integer[] retornoArray = retorno.toArray(new Integer[retorno.size()]);

        return retornoArray;
    }
}
