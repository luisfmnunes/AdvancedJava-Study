package br.com.digital.innovation.one;

import java.util.function.Supplier;

public class Supridores {

    //Supridores, retornam um Tipo especificado pelo generics sem receber parâmetros.

    public static void main(String[] args) {
        Supplier<Pessoa> suppliers = () -> new Pessoa(); // ou usa o método referência Pessoa::new

        System.out.println(suppliers.get());
    }
}


class Pessoa {

    private String nome;
    private Integer idade;

    public Pessoa() {
        nome = "Luís Felipe";
        idade = 25;
    }
    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + " - Idade: " + idade;
    }
}