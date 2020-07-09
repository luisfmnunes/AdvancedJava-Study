package br.com.digital.innovation.one;

import java.util.function.Predicate;

public class Predicados {

    //Predicates fazem um teste de validação retornando um boolean do resultado.
    public static void main(String[] args) {
        Predicate<String> estaVazio = valor -> valor.length() != 0 ? false : true; //implementando a lambda
        Predicate<String> estaVazioMetodoReferencia = String::isEmpty; //passando método por referência
        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("João"));
        System.out.println(estaVazioMetodoReferencia.test("o"));
    }
}
