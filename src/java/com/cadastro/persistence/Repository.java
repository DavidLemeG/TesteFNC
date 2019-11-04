/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastro.persistence;

import com.cadastro.models.PacienteModel;
import com.cadastro.models.ProcedimentoModel;
import com.cadastro.models.ExameModel;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Repository {

    public static ArrayList<PacienteModel> Pacientes = new ArrayList<>();
    public static ArrayList<ProcedimentoModel> Procedimentos = new ArrayList<>();
    public static ArrayList<ExameModel> Exames = new ArrayList<>();
}
