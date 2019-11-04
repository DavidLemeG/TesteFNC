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
public class ExameModelSerializer implements JsonSerializer<ExameModel> {

    @Override
    public JsonElement serialize(ExameModel exame, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.add("id", new JsonPrimitive(exame.getId()));
        result.add("paciente", new JsonPrimitive(exame.getPaciente()));
        result.add("procedimento", new JsonPrimitive(exame.getProcedimento()));

        if (exame.getDate() != null) {
            result.add("date", new JsonPrimitive(exame.getDate()));
        }

        if (exame.getEntrega() != null) {
            result.add("entrega", new JsonPrimitive(exame.getEntrega()));
        }

        return result;
    }
    
}
