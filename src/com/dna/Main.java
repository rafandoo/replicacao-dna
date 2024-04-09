package com.dna;

import com.dna.analise.TarefaValidar;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        File path = new File("arquivosDNA");
        File[] files = path.listFiles();
        assert files != null;
        for (File file : files) {
            executor.execute(new TarefaValidar(file.getAbsolutePath(), ("validados/" + file.getName())));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}