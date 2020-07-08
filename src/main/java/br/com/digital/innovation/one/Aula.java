package br.com.digital.innovation.one;

public class Aula {

    public static void main(String[] args){
        Funcao1 funcao1 = valor -> {
            String nomeComPrefixoSenhor = "Sr. " + valor;
            System.out.println(nomeComPrefixoSenhor);
        };

        funcao1.gerar("Caquí");
    }
}

interface Funcao1 {
    void gerar(String valor);
}
