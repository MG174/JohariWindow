/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.JohariDatabase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author goryc
 */
@WebServlet(urlPatterns = {"/ResultsJohariWindow"})
public class ResultsJohariWindow extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultsJohariWindow</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResultsJohariWindow at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        
        String johari_window_id = request.getParameter("johari_window_id");
        
        JohariDatabase johari_db = new JohariDatabase();
        
        ArrayList<String> arena_traits = johari_db.getArena(johari_window_id);
        ArrayList<String> facade_traits = johari_db.getFacade(johari_window_id);
        ArrayList<String> blindspot_traits = johari_db.getBlindspot(johari_window_id);
        int unknown_amount = johari_db.getUnknownAmount(johari_window_id);
        
        
        
        RequestDispatcher requestDispatcher;
        request.setAttribute("johari_window_id", johari_window_id);
        request.setAttribute("arena_traits", String.join(", ", arena_traits));
        request.setAttribute("facade_traits", String.join(", ", facade_traits));
        request.setAttribute("blindspot_traits", String.join(", ", blindspot_traits));
        request.setAttribute("unknown_amount", unknown_amount);
        requestDispatcher = request.getRequestDispatcher("/JohariResults.jsp");
        requestDispatcher.forward(request, response);
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
