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
public class PhatNTHE171818_SecondPage extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //PrintWriter out = response.getWriter();
    //request.setCharacterEncoding("UTF-8");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
            out.print("<p>Hello " + username + "</p>");
            out.print("<form action=\"PhatNTHE171818SecondPage\" method=\"post\">\n"
                    + " <input type=\"text\" name=\"text\" > <br/>\n"
                    + " <input type=\"number\" name=\"number\" > <br/>\n"
                    + " <input type=\"radio\" id=\"radio1\" name=\"radio\" value=\"radio1\">\n"
                    + " <label for=\"radio1\">radio1</label><br>\n"
                    + " <input type=\"radio\" id=\"radio2\" name=\"radio\" value=\"radio2\">\n"
                    + " <label for=\"radio2\">radio2</label><br>\n"
                    + " <input type=\"radio\" id=\"radio3\" name=\"radio\" value=\"radio3\">\n"
                    + " <label for=\"radio3\">radio3</label><br>\n"
                    + " <input type=\"checkbox\" id=\"checkbox1\" name=\"checkbox\" value=\"checkbox1\">\n"
                    + " <label for=\"checkbox1\">checkbox1</label><br>\n"
                    + " <input type=\"checkbox\" id=\"checkbox2\" name=\"checkbox\" value=\"checkbox2\">\n"
                    + " <label for=\"checkbox2\">checkbox2</label><br>\n"
                    + " <input type=\"checkbox\" id=\"checkbox3\" name=\"checkbox\" value=\"checkbox3\">\n"
                    + " <label for=\"checkbox3\">checkbox3</label><br>\n"
                    + " <input type=\"date\" name=\"date\"> <br/><br/>\n"
                    + " <input type=\"submit\" value=\"Submit\">\n"
                    + "</form>\n"
                    + "<form action=\"logout\" method=\"post\">\n"
                    + " <input type=\"submit\" value=\"Logout\" >\n"
                    + "</form>\n");
        } else {
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
            out.print("<p>Hello " + username + ", you have given the following information:</p>");
            out.print("<p>- Input 1: " + request.getParameter("text") + "</p>");
            out.print("<p>- Input 2: " + request.getParameter("number") + "</p>");
            out.print("<p>- Input 3: " + request.getParameter("radio") + "</p>");
            out.print("<p>- Input 4: ");
            for (String s : request.getParameterValues("checkbox")) {
                out.print(s + ", ");
            }
            out.print("</p>");
            out.print("<p>- Input 5: " + request.getParameter("date") + "</p>");
        } else {
            response.sendRedirect("index.html");
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
            out.println("<title>Servlet PhatNTHE171818_SecondPage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PhatNTHE171818_SecondPage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
