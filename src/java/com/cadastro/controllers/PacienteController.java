/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastro.controllers;

import com.cadastro.models.PacienteModel;
import com.cadastro.persistence.Repository;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class PacienteController {

    public ArrayList<PacienteModel> list() {
        return Repository.Pacientes;
    }

    public void save(PacienteModel paciente) {
        if (paciente.getId() == 0) {
            int maiorIdQueJaTemos = this.getMaxPacienteId();            
            paciente.setId(maiorIdQueJaTemos + 1);
            
            Repository.Pacientes.add(paciente);
        } else {
            for (int i = 0; i < Repository.Pacientes.size(); i++) {
                if (paciente.getId() == Repository.Pacientes.get(i).getId()) {
                    Repository.Pacientes.set(i, paciente);
                }
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < Repository.Pacientes.size(); i++) {
            if (id == Repository.Pacientes.get(i).getId()) {
                Repository.Pacientes.remove(i);
            }
        }
    }

    private int getMaxPacienteId() {
        int maxId = 0;

        for (int i = 0; i < Repository.Pacientes.size(); i++) {
            if (maxId < Repository.Pacientes.get(i).getId()) {
                maxId = Repository.Pacientes.get(i).getId();
            }
        }
        
        return maxId;
    }
}
