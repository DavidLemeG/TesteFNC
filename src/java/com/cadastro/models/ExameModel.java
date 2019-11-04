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
public class ExameModel {
    
    private int _id;
    private String _paciente;
    private String _procedimento;
    private String _date;
    private String _entrega;
    
    public int getId() {
      return this._id;
    }

    public void setId(int id) {
        this._id = id;
    }
    
    public String getPaciente() {
      return this._paciente;
    }

    public void setPaciente(String paciente) {
        this._paciente = paciente;
    }

    public String getProcedimento() {
        return this._procedimento;
    }

    public void setProcedimento(String procedimento) {
        this._procedimento = procedimento;
    }

    public String getDate() {
        return this._date;
    }

    public void setDate(String date) {
        this._date = date;
    }

    public String getEntrega() {
        return this._entrega;
    }

    public void setEntrega(String entrega) {
        this._entrega = entrega;
    }
    
}
