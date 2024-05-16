package com.hederdavid.consultafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosModelos {
    @JsonAlias("modelos")
    private List<ModeloVeiculo> modelos;
    @JsonAlias("anos")
    private List<ModeloVeiculo> anos;

    public List<ModeloVeiculo> getAnos() {
        return anos;
    }

    public void setAnos(List<ModeloVeiculo> anos) {
        this.anos = anos;
    }

    public List<ModeloVeiculo> getModelos() {
        return modelos;
    }

    public void setModelos(List<ModeloVeiculo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString() {
        return "DadosModelos{" +
                "modelos=" + modelos +
                ", anos=" + anos +
                '}';
    }
}
