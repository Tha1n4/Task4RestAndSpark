package br.com.senai.sparkjava;

import com.google.gson.JsonElement;

public class TipoResposta {
    private StatusResposta status;
    private String mensagem;
    private JsonElement data;

    public TipoResposta(StatusResposta status) {
        this.status = status;
    }

    public TipoResposta(StatusResposta status, String message) {
        this.status = status;
        this.mensagem = message;
    }

    public TipoResposta(StatusResposta status, JsonElement data) {
        this.status = status;
        this.data = data;
    }

    public StatusResposta getStatus() {
        return status;
    }

    public void setStatus(StatusResposta status) {
        this.status = status;
    }

    public String getMessage() {
        return mensagem;
    }

    public void setMessage(String message) {
        this.mensagem = message;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }
}
