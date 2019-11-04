package com.cadastro.routes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cadastro.controllers.ProcedimentoController;
import com.cadastro.models.ProcedimentoModel;
import com.cadastro.models.ProcedimentoModelSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.lang.ProcessBuilder.Redirect.Type;
import static java.net.Proxy.Type.HTTP;
import java.util.ArrayList;

public class ProcedimentoRoutes extends HttpServlet {

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

       ProcedimentoController controller = new ProcedimentoController();

        ArrayList<ProcedimentoModel> procedimentos = controller.list();

        java.lang.reflect.Type listType = new TypeToken<ArrayList<ProcedimentoModel>>() {
        }.getType();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ProcedimentoModel.class, new ProcedimentoModelSerializer())
                .create();

        try (PrintWriter out = response.getWriter()) {
            out.print(gson.toJson(procedimentos, listType));
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

        int idProcedimento = 0;
        
        if(request.getParameter("id") != null) {
            idProcedimento = Integer.parseInt(request.getParameter("id"));
        }
        
        String ex = request.getParameter("ex");
        String dia = request.getParameter("dia");

        ProcedimentoModel procedimento = new ProcedimentoModel();
        procedimento.setId(idProcedimento);
        procedimento.setEx(ex);
        procedimento.setDia(dia);

        ProcedimentoController controller = new ProcedimentoController();

        controller.save(procedimento);
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