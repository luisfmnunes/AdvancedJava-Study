package br.com.digital.innovation.one.Java11;

public class StringBlankExemplo {
    public static void main(String[] args) {
        String espaco = "";
        System.out.println(espaco != null || espaco.length() == 0 || espaco.chars().allMatch(c -> c == ' ')); //Sem Java 11
        System.out.println(espaco.isBlank()); // Java 11
    }

}
