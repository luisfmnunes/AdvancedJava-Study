package br.com.digital.innovation.one;

import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {

        //Consumer não tem retorno

        Consumer<String> imprimirUmaFrase = System.out::println;
        Consumer<String> imprimirUmaFrase2 = frase -> System.out.println(frase);
        imprimirUmaFrase.accept("Hello World");
    }
}
