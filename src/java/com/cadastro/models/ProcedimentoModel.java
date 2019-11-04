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
import java.lang.ProcessBuilder.Redirect.Type;

/**
 *
 * @author david
 */
public class ProcedimentoModel {
    
    private int _id;
    private String _ex;
    private String _dia;
    
    public int getId() {
        return this._id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getEx() {
        return this._ex;
    }

    public void setEx(String ex) {
        this._ex = ex;
    }

    public String getDia() {
        return this._dia;
    }

    public void setDia(String dia) {
        this._dia = dia;
    }

    
}
