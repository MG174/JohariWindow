/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author goryc
 */
@WebServlet(urlPatterns = {"/SubmitJohari"})
public class SubmitJohari extends HttpServlet {

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
            out.println("<title>Servlet SubmitJohari</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubmitJohari at " + request.getContextPath() + "</h1>");
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
        
        //list of selected personality traits (owner parto of johari)
        String[] johari_traits = request.getParameterValues("johari");
        
        String id_johari_window;
        
        HttpSession session = request.getSession();
        id_johari_window = (String) session.getAttribute("johari_window_id");
        
        
        for (int i = 0; i < johari_traits.length; i++) {
//            System.out.println(johari_traits[i]);
            
            try {

            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();


            // Create a SQL query to insert data into demo table
            PreparedStatement st = con.prepareStatement("INSERT INTO `johari_db`.`owner_table`(`id_johari_window_1`,`adjective`) VALUES(?,?);");

            st.setString(1, id_johari_window);
            st.setString(2, johari_traits[i]);
            
            // Execute the insert command using executeUpdate()
            // to make changes in database
            st.executeUpdate();


            // Close all the connections
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error happend: " + e.getMessage());
        }
        }
        
        
        RequestDispatcher requestDispatcher;
        request.setAttribute("johari_window_id", id_johari_window);
        requestDispatcher = request.getRequestDispatcher("/JohariSubmited.jsp");
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
