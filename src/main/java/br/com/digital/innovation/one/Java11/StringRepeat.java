package br.com.digital.innovation.one.Java11;

public class StringRepeat {

    public static void main(String[] args) {
        String nome = "Joao";
        repeatImperativo(nome);
        repeatJava11(nome);
    }

    public static void repeatJava11(String nome) {
        System.out.println(nome.repeat(10));
    }

    public static void repeatImperativo(String nome) {
        String aux = "";

        for (int i = 0; i < 10 ; i++) {
            aux+=nome;
        }

        System.out.println(aux);
    }
}
