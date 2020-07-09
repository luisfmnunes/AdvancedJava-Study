package br.com.digital.innovation.one.Threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FuturoExemplo {

    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {

        Casa casa = new Casa(new Quarto());
        casa.obterAfazeresDaCasa().forEach( atividade -> pessoasParaExecutarAtividade.execute(() -> {
            try {
                atividade.realizar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        pessoasParaExecutarAtividade.shutdown();
    }


}

class Casa{
    private  List<Comodo> comodos;

    Casa(Comodo... comodos) {this.comodos = Arrays.asList(comodos);}

    List<Atividade> obterAfazeresDaCasa() {
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo,atividades) -> {
                   pivo.addAll(atividades);
                   return pivo;
                });
    }
}

interface Atividade{
    String realizar() throws InterruptedException;
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {
    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
                this::getArrumarACama,
                this::varrerOQuarto,
                this::arrumarGuardaRoupa
        );
    }

    private String arrumarGuardaRoupa() throws InterruptedException {
        String message = "arrumar o guarda roupa";
        Thread.sleep(4000);
        System.out.println(message);
        return message;
    }

    private String varrerOQuarto() throws InterruptedException {
        String message = "varrer o quarto";
        Thread.sleep(2500);
        System.out.println(message);
        return message;
    }

    private String getArrumarACama() throws InterruptedException {
        String message = "Arrumar a cama";
        Thread.sleep(1000);
        System.out.println(message);
        return message;
    }
}