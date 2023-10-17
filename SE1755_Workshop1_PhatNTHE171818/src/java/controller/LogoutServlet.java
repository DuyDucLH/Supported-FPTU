/*
 * DuyDuc94
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author duy20
 */
public class LogoutServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //PrintWriter out = response.getWriter();
    //request.setCharacterEncoding("UTF-8");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        request.getSession().setAttribute("username", null);
        response.sendRedirect("index.html");
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogoutServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogoutServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }   
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
