package br.com.digital.innovation.one.Threads;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExemplo {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1,100000).forEach(num -> fatorial(num)); //Serial Stream
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Serial: " + (fim-inicio));


        inicio = System.currentTimeMillis();
        IntStream.range(1,100000).parallel().forEach(num -> fatorial(num)); //Pararel Stream
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Parallel: " + (fim-inicio));

        List<String> nomes = Arrays.asList("Joao","Pedro","Oliveira","Mequetrefe");
        nomes.parallelStream().forEach(System.out::println);
    }

    public static long fatorial(long num) {
        int fat = 1;

        for(long i = 2; i <= num; i++) {
            fat*=i;
        }

        return fat;
    }
}
