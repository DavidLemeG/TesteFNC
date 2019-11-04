package com.cadastro.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.ProcessBuilder.Redirect.Type;

public class PacienteModel {

    private int _id;
    private String _nome;
    private String _cpf;
    private String _email;

    public int getId() {
        return this._id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getNome() {
        return this._nome;
    }

    public void setNome(String nome) {
        this._nome = nome;
    }

    public String getCpf() {
        return this._cpf;
    }

    public void setCpf(String cpf) {
        this._cpf = cpf;
    }

    public String getEmail() {
        return this._email;
    }

    public void setEmail(String email) {
        this._email = email;
    }

}


