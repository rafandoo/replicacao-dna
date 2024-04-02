package com.dna.analise;

import com.dna.Dna;

import java.util.List;

public class ProcessaDNA {

    public void validar(Dna dna) {
        dna.setValido(validarFita(dna));
    }

    public void validar(List<Dna> dna) {
        for (Dna d : dna) {
            d.setValido(validarFita(d));
        }
    }

    private boolean validarFita(Dna dna) {
        int adenina = 0, timina = 0, guanina = 0, citosina = 0;

        for (char nucleotidio : dna.getFita().toUpperCase().toCharArray()) {
            switch (nucleotidio) {
                case 'A':
                    adenina++;
                    break;
                case 'T':
                    timina++;
                    break;
                case 'G':
                    guanina++;
                    break;
                case 'C':
                    citosina++;
                    break;
                default:
                    return false;
            }
        }
//        return adenina == timina && guanina == citosina;
        return true;
    }

    public void complementar(Dna dna) {
        dna.setFitaComplementar(gerarFitaComplementar(dna));
    }

    public void complementar(List<Dna> dna) {
        for (Dna d : dna) {
            d.setFitaComplementar(gerarFitaComplementar(d));
        }
    }

    private String gerarFitaComplementar(Dna dna) {
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
            }
        }
        return sb.toString();
    }
}
