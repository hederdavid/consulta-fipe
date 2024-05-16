package com.hederdavid.consultafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModeloVeiculo {

    @JsonAlias("codigo")
    private String codigo;
    @JsonAlias("nome")
    private String nome;


    @Override
    public String toString() {
        return "Código: " + codigo + "   Marca: " + nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
