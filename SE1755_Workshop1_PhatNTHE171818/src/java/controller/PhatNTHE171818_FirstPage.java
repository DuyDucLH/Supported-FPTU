/*
 * DuyDuc94
 */
package controller;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author duy20
 */
public class PhatNTHE171818_FirstPage extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String xPassword = this.getInitParameter(username);
        
        if(xPassword!=null && xPassword.compareTo(password) == 0){
            request.getSession().setAttribute("username", username);
            response.sendRedirect("PhatNTHE171818SecondPage");
        }else{
            out.print("<form action=\"PhatNTHE171818FirstPage\" method=\"post\">");
            out.print("<input type=\"text\" name=\"username\" required> <br/>");
            out.print("<input type=\"password\" name=\"password\" required>");
            out.print("<p>name and password are not correct</p>");
            out.print("<input type=\"submit\" name=\"name\" value=\"Login\">");
            out.print("<input type=\"reset\" name=\"name\" value=\"Reset\" >");
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PhatNTHE171818_FirstPage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PhatNTHE171818_FirstPage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
