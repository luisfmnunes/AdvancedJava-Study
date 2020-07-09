package br.com.digital.innovation.one.Threads;

public class ThreadExemplo {

    public static void main(String[] args) {

        GeradorPDF iniciarGerarPdf = new GeradorPDF();
        BarraDeCarregamento barraDeCarregamento = new BarraDeCarregamento(iniciarGerarPdf);

        iniciarGerarPdf.start();
        barraDeCarregamento.start();

        /* Exemplo para entender o funcionamento
        Thread thread = new Thread(new BarraDeCarregamento2());
        Thread thread2 = new Thread(new BarraDeCarregamento3());

        thread.start();
        thread2.start();

        System.out.println("Nome da Thread: " + thread.getName());
        System.out.println("Nome da Thread: " + thread2.getName());
        */
    }
}

class GeradorPDF extends Thread {
    @Override
    public void run() {

        try {
            System.out.println("Iniciar geração de PDF:");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento extends Thread {
    private Thread iniciarGeradorPdf;

    public BarraDeCarregamento(Thread iniciarGeradorPdf) {
        this.iniciarGeradorPdf = iniciarGeradorPdf;
    }

    @Override
    public void run() {

        try {
            while(true) {
                Thread.sleep(500);
                if(!iniciarGeradorPdf.isAlive()) {
                    break;
                }

                System.out.println("Loading ...");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento2 implements Runnable { //Exemplo para conhecimento do funcionamento das Threads
    @Override
    public void run() {

        try {
            Thread.sleep(3000);
            System.out.println("rodei 2" );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class BarraDeCarregamento3 implements Runnable { //Exemplo para conhecimento do funcionamento das Threads
    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println("rodei 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}