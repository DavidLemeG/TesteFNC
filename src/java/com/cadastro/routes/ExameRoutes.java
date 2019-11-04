/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastro.routes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cadastro.controllers.ExameController;
import com.cadastro.models.ExameModel;
import com.cadastro.models.ExameModelSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.lang.ProcessBuilder.Redirect.Type;
import static java.net.Proxy.Type.HTTP;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class ExameRoutes extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");

       ExameController controller = new ExameController();

        ArrayList<ExameModel> exames = controller.list();

        java.lang.reflect.Type listType = new TypeToken<ArrayList<ExameModel>>() {
        }.getType();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ExameModel.class, new ExameModelSerializer())
                .create();

        try (PrintWriter out = response.getWriter()) {
            out.print(gson.toJson(exames, listType));
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idExame = 0;
        
        if(request.getParameter("id") != null) {
            idExame = Integer.parseInt(request.getParameter("id"));
        }
        
        String paciente = request.getParameter("paciente");
        String procedimento = request.getParameter("procedimento");
        String date = request.getParameter("date");
        String entrega = request.getParameter("entrega"); 

        ExameModel exame = new ExameModel();
        exame.setId(idExame);
        exame.setPaciente(paciente);
        exame.setProcedimento(procedimento);
        exame.setDate(date);
        exame.setEntrega(entrega);

        ExameController controller = new ExameController();

        controller.save(exame);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}