package com.dna.analise;

import com.dna.Dna;

import java.util.ArrayList;
import java.util.List;

public class ProcessaDNA {

    private static final String DNA_REGEX = "^[ATGC]*$";
    private int totalFitas;
    private int validas;
    private int invalidas;
    private List<Integer> invalidasPorLinha = new ArrayList<>();

    public void processar(List<Dna> dna) {
        for (Dna d : dna) {
            this.totalFitas++;
            if (!validarFita(d)) {
                d.setValido(false);
                this.invalidas++;
                this.invalidasPorLinha.add(this.totalFitas);
            }
            gerarFitaComplementar(d);
        }
    }

    private boolean validarFita(Dna dna) {
        return dna.getFita().matches(DNA_REGEX);
    }

    private void gerarFitaComplementar(Dna dna) {
        StringBuilder sb = new StringBuilder();
        for (char nucleotidio : dna.getFita().toUpperCase().toCharArray()) {
            switch (nucleotidio) {
                case 'A':
                    sb.append('T');
                    break;
                case 'T':
                    sb.append('A');
                    break;
                case 'G':
                    sb.append('C');
                    break;
                case 'C':
                    sb.append('G');
                    break;
                default:
                    dna.setValido(false);
            }
        }
        if (dna.isValido()) {
            this.validas++;
        }
        dna.setFitaComplementar(sb.toString());
    }

    public void printMetricas(String arquivo) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Arquivo : %s\n", arquivo));
        sb.append(String.format("o Total de fitas é : %d\n", this.totalFitas));
        sb.append(String.format("o Total de validas é : %d\n", this.validas));
        sb.append(String.format("o Total de invalidas é : %d\n", this.invalidas));
        sb.append(String.format("as linhas com fitas invalidas são : %s\n\n", this.invalidasPorLinha));
        System.out.println(sb);
    }
}
