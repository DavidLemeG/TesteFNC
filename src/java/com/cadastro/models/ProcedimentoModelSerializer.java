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
public class ProcedimentoModelSerializer implements JsonSerializer<ProcedimentoModel> {

    @Override
    public JsonElement serialize(ProcedimentoModel procedimento, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.add("id", new JsonPrimitive(procedimento.getId()));
        result.add("ex", new JsonPrimitive(procedimento.getEx()));

        if (procedimento.getDia() != null) {
            result.add("dia", new JsonPrimitive(procedimento.getDia()));
        }
        return result;
    }
}
    

