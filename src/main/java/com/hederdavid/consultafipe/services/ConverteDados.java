package com.hederdavid.consultafipe.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverteDados implements IConverteDados {

    @Override
    public <T> List<T> obterDados(String json, TypeReference<List<T>> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T obterDados(String json, Class<T> classe) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
