package br.com.digital.innovation.one.Threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FuturoExemplo2 {

    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {

        Casa casa = new Casa(new Quarto());
        List<? extends Future<String>> futuros = new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
                .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
                    try {
                        return atividade.realizar();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }))
                .collect(Collectors.toList()));


        while(true) {
            int numeroDeAtividadesNaoFinalizadas = 0;

            for (Future<?> futuro: futuros) {
                if (futuro.isDone()) {
                    try {
                        System.out.println("Parabéns você terminou de " + futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    numeroDeAtividadesNaoFinalizadas++;
                }
            }

            if(futuros.stream().allMatch(Future::isDone)) {
                break;
            }

            System.out.println("Número de Atividades não Finalizadas: " + numeroDeAtividadesNaoFinalizadas);
            Thread.sleep(500);
        }

        pessoasParaExecutarAtividade.shutdown();
    }


}

