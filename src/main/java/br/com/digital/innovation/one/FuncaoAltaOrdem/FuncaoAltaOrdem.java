package br.com.digital.innovation.one.FuncaoAltaOrdem;

public class FuncaoAltaOrdem {

    public static void main (String[] args) {
        Calculo soma = (a,b) -> a + b;
        Calculo subtrair = (a,b) -> a - b;
        Calculo multiplicar = (a,b) -> a * b;
        Calculo dividir = (a,b) -> a/b;
        System.out.println(executarOperacao(soma,1,3));
        System.out.println(executarOperacao(subtrair, 10, 8));
        System.out.println(executarOperacao(multiplicar, 3, 5));
        System.out.println(executarOperacao(dividir, 25,5));
    }

    public static int executarOperacao(Calculo calculo, int a, int b) { //função de alta ordem: recebe uma função como parâmetro ou retorna uma função
        return calculo.calculo(a,b);
    }
}

@FunctionalInterface
interface Calculo {
    public int calculo(int a ,int b);
}
