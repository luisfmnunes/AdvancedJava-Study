package br.com.digital.innovation.one.Java11;

import java.util.function.Function;

public class InferenciaLambda {

    public static void main(String[] args) {
        Function<Integer,Double> metade = numero -> numero/2.0;

        System.out.println(metade.apply(981345203));
    }
}
