package br.com.digital.innovation.one.Recursividade;

import java.util.HashMap;
import java.util.Map;

public class FatorialMemoization {

    static Map<Integer,Integer> memoization = new HashMap<>();

    public static void main(String[] args) {
        long I = System.nanoTime();
        System.out.println(fatorialComMemoization(15));
        long F = System.nanoTime();
        System.out.println("Tempo Fatorial 1: " + (F-I));

        I = System.nanoTime();
        System.out.println(fatorialComMemoization(15));
        F = System.nanoTime();
        System.out.println("Tempo Fatorial 2: " + (F-I));
    }

    public static int fatorialComMemoization(Integer value) {
        if ( value == 1 ) {
            return value;
        } else {
            if (memoization.containsKey(value)) {
                return memoization.get(value);
            } else {
                int result = fatorialComMemoization( value - 1 ) * value;
                memoization.put(value,result);
                return result;
            }
        }
    }
}
