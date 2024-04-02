package com.dna.analise;

import com.dna.Dna;
import com.dna.ExportDna;
import com.dna.analise.ProcessaDNA;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TarefaValidar implements Runnable {

    private String path;
    private List<Dna> dna;
    private String exportPath;

    public TarefaValidar(String path, String exportPath) {
        this.path = path;
        this.dna = new ArrayList<>();
        this.exportPath = exportPath;
    }

    @Override
    public void run() {
        Scanner sc;
        ProcessaDNA pdna = new ProcessaDNA();
        ExportDna edna = new ExportDna(exportPath);
        try {
            sc = new Scanner(new FileReader(this.path));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                this.dna.add(new Dna(line, this.path));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pdna.complementar(this.dna);
        pdna.validar(this.dna);
        edna.export(this.dna);
    }
}
