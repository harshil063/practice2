/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.BookBeanLocal;
import entity.Tblbookcategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Harshil
 */
public class edit_bookcat_servlet extends HttpServlet {

    @EJB BookBeanLocal stateless;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet edit_bookcat_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if(request.getMethod().equals("POST")){
                stateless.UpdateBookcat(Integer.parseInt(request.getParameter("bookcat_id")),request.getParameter("bookcatname"));
                response.sendRedirect("index");
            }
            Collection<Tblbookcategory> ctg = stateless.ViewBookcatById(Integer.parseInt(request.getParameter("bookcat_id")));
            
            out.println("<center><form action='' method='post'>");
            out.println("<h1>Update Category</h1>");
            for(Tblbookcategory bc: ctg)
            {
            out.println("<input type='text' name='bookcatname' value='"+ bc.getBookcatName() +"' />");
            out.println("<button type='submit' name='submit'>Update</button>");
            }
            out.println("</form></center>");
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
        processRequest(request, response);
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
