package br.com.senai.sparkjava;

public class Usuario {

    private String id;
    private String nome;
    private String email;

    public Usuario(String id, String firstName, String email) {
        super();
        this.id = id;
        this.nome = firstName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return nome;
    }

    public void setFirstName(String firstName) {
        this.nome = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(getEmail()).toString();
    }
}
