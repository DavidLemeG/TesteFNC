/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastro.controllers;

import com.cadastro.models.ExameModel;
import com.cadastro.persistence.Repository;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class ExameController {
     public ArrayList<ExameModel> list() {
        return Repository.Exames;
    }

    public void save(ExameModel exame) {
        if (exame.getId() == 0) {
            int maiorIdQueJaTemos = this.getMaxExameId();            
            exame.setId(maiorIdQueJaTemos + 1);
            
            Repository.Exames.add(exame);
        } else {
            for (int i = 0; i < Repository.Exames.size(); i++) {
                if (exame.getId() == Repository.Exames.get(i).getId()) {
                    Repository.Exames.set(i, exame);
                }
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < Repository.Exames.size(); i++) {
            if (id == Repository.Exames.get(i).getId()) {
                Repository.Exames.remove(i);
            }
        }
    }

    private int getMaxExameId() {
        int maxId = 0;

        for (int i = 0; i < Repository.Exames.size(); i++) {
            if (maxId < Repository.Exames.get(i).getId()) {
                maxId = Repository.Exames.get(i).getId();
            }
        }
        
        return maxId;
    }
}
