/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastro.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/**
 *
 * @author david
 */
public class PacienteModelSerializer implements JsonSerializer<PacienteModel> {

    @Override
    public JsonElement serialize(PacienteModel paciente, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.add("id", new JsonPrimitive(paciente.getId()));
        result.add("nome", new JsonPrimitive(paciente.getNome()));

        if (paciente.getCpf() != null) {
            result.add("cpf", new JsonPrimitive(paciente.getCpf()));
        }

        if (paciente.getEmail() != null) {
            result.add("email", new JsonPrimitive(paciente.getEmail()));
        }

        return result;
    }
}
