package com.dna;

import com.dna.analise.TarefaValidar;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        File path = new File("arquivosDNA");
        File[] files = path.listFiles();
        assert files != null;
        for (File file : files) {
            executor.submit(new TarefaValidar(file.getAbsolutePath(), ("validados/" + file.getName())));
        }
        // saida
        // o Total de fitas é : %d
        // o Total de validas é : %d
        // o Total de invalidas é : %d
        // as fitas invalidas são : []



        executor.shutdown();
    }
}