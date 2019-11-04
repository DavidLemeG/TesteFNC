package com.cadastro.routes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cadastro.controllers.PacienteController;
import com.cadastro.models.PacienteModel;
import com.cadastro.models.PacienteModelSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.lang.ProcessBuilder.Redirect.Type;
import static java.net.Proxy.Type.HTTP;
import java.util.ArrayList;

public class PacienteRoutes extends HttpServlet {

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

        PacienteController controller = new PacienteController();

        ArrayList<PacienteModel> pacientes = controller.list();

        java.lang.reflect.Type listType = new TypeToken<ArrayList<PacienteModel>>() {
        }.getType();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(PacienteModel.class, new PacienteModelSerializer())
                .create();

        try (PrintWriter out = response.getWriter()) {
            out.print(gson.toJson(pacientes, listType));
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

        int idPaciente = 0;
        
        if(request.getParameter("id") != null) {
            idPaciente = Integer.parseInt(request.getParameter("id"));
        }
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");


        PacienteModel paciente = new PacienteModel();
        paciente.setId(idPaciente);
        paciente.setNome(nome);
         paciente.setCpf(cpf);
        paciente.setEmail(email);

        PacienteController controller = new PacienteController();

        controller.save(paciente);
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