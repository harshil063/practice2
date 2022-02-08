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


public class index extends HttpServlet {

    @EJB BookBeanLocal stateless;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet index</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Show details</h1>");
            out.println("<h3><a href='add_boocat_servlet'>Add Book Category</a></h3>");
            out.println("<h3><a href='add_boocat_servlet'>Add Book</a></h3>");
            out.println("<table>");
            out.println("<tr><th>SR No.</th><th>Category</th><th>Update</th><th>Delete</th></tr>");
            Collection<Tblbookcategory> ctgs = stateless.ViewBookcat();
            int i=1;
            for(Tblbookcategory ctg:ctgs)
            {
                out.println("<tr><td>" + i +"</td><td>" +ctg.getBookcatName()+"</td><td><a href='edit_bookcat_servlet?bookcat_id="+ctg.getBookcatId()+"'>Update</a></td><td><a href='remove_bookcat_servlet?bookcat_id="+ctg.getBookcatId()+"'>Delete</a></td></tr>");
                i++;
            }
            out.println("</table> <br/><br/>");
            
            out.println("<table>");
//            book add no code
            out.println("</table>");
            out.println("</center>");
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
