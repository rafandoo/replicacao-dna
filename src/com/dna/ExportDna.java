package com.dna;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class ExportDna {

    private String path;

    public ExportDna(String path) {
        this.path = path;
    }

    public void export(List<Dna> dna) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(this.path), false));
            PrintWriter pw = new PrintWriter(bw);
            for (Dna d : dna) {
                pw.println(d.toExport());
            }
            pw.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
