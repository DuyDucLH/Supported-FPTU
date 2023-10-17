package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PhatNTHE171818_CalculateController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numVarString = request.getParameter("numVar");
        String msgErr = null;
        boolean accept = false;
        int numVar;
        
        try {
            numVar = Integer.parseInt(numVarString);
            if (numVar <= 0) {
                msgErr = "n must be > 0, please input again!";
            } else {
                accept = true;
            }
        } catch (NumberFormatException e) {
            msgErr = "n must be integer!";
        }
        
        request.setAttribute("numVar", numVarString);
        if(accept){
            request.getRequestDispatcher("PhatNTHE171818_index2.jsp").forward(request, response);
        }else{
            request.setAttribute("msgErr", msgErr);
            request.getRequestDispatcher("PhatNTHE171818_index.jsp").forward(request, response);
        }
    }    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
