package br.com.senai.sparkjava;

public enum StatusResposta {
    SUCCESSO("Successo"), ERRO("Ocorreu um erro");

    final private String situacao;

    StatusResposta(String situacao) {
        this.situacao = situacao;
    }

    public String getStatus() {
        return situacao;
    }

}
