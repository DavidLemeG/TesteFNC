/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastro.controllers;

import com.cadastro.models.ProcedimentoModel;
import com.cadastro.persistence.Repository;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class ProcedimentoController {
      public ArrayList<ProcedimentoModel> list() {
        return Repository.Procedimentos;
    }

    public void save(ProcedimentoModel procedimento) {
        if (procedimento.getId() == 0) {
            int maiorIdQueJaTemos = this.getMaxProcedimentoId();            
            procedimento.setId(maiorIdQueJaTemos + 1);
            
            Repository.Procedimentos.add(procedimento);
        } else {
            for (int i = 0; i < Repository.Procedimentos.size(); i++) {
                if (procedimento.getId() == Repository.Procedimentos.get(i).getId()) {
                    Repository.Procedimentos.set(i, procedimento);
                }
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < Repository.Procedimentos.size(); i++) {
            if (id == Repository.Procedimentos.get(i).getId()) {
                Repository.Procedimentos.remove(i);
            }
        }
    }

    private int getMaxProcedimentoId() {
        int maxId = 0;

        for (int i = 0; i < Repository.Procedimentos.size(); i++) {
            if (maxId < Repository.Procedimentos.get(i).getId()) {
                maxId = Repository.Procedimentos.get(i).getId();
            }
        }
        
        return maxId;
    }
    
    
}
