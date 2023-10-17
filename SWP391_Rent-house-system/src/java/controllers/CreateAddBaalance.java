/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dal.PaymentDAO;
import dal.TransactionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import models.Transaction;


@WebServlet(name="CreateAddBaalance", urlPatterns={"/depositmoney"})
public class CreateAddBaalance extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet CreateAddBaalance</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateAddBaalance at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 
    private String getCurrentDate(){
        long timeInMillis = System.currentTimeMillis();
    Calendar cal1 = Calendar.getInstance();
    cal1.setTimeInMillis(timeInMillis);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy     hh:mm:ss a");
    String date=dateFormat.format(cal1.getTime());
    return date;
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       try{
            int userID=1;
        String bankNumber=request.getParameter("bankNumber");
        String amount=request.getParameter("amount");
        int amountI=Integer.parseInt(amount);
        int status=1;
        String date=getCurrentDate();
        Transaction t= new Transaction(userID, date, amountI, bankNumber, status);
        TransactionDAO transactionDAO=new TransactionDAO();
        transactionDAO.createTransaction(t);  
        PrintWriter out = response.getWriter();
        out.println("Add success");
       }catch(Exception e ){
           request.setAttribute("err",e.getMessage());
       }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
