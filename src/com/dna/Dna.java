package com.dna;

public class Dna {

    private String fitaOriginal;
    private String fitaComplementar;
    private String arquivoOriginal;
    private boolean valido;

    public Dna(String fitaOriginal, String arquivoOriginal) {
        this.fitaOriginal = fitaOriginal;
        this.arquivoOriginal = arquivoOriginal;
        this.valido = false;
    }

    public String getFita() {
        return this.fitaOriginal;
    }

    public void setFita(String fitaOriginal) {
        this.fitaOriginal = fitaOriginal;
    }

    public String getFitaComplementar() {
        return fitaComplementar;
    }

    public void setFitaComplementar(String fitaComplementar) {
        this.fitaComplementar = fitaComplementar;
    }

    public String getArquivoOriginal() {
        return this.arquivoOriginal;
    }

    public void setArquivoOriginal(String arquivoOriginal) {
        this.arquivoOriginal = arquivoOriginal;
    }

    public boolean isValido() {
        return this.valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String toExport() {
        return String.format("%s%s", (this.isValido() ? "" : "FITA INVALIDA - "), this.getFitaComplementar());
    }
}
