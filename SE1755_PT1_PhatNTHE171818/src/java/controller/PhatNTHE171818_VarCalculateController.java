package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class PhatNTHE171818_VarCalculateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int numVar = Integer.parseInt(request.getParameter("numVar"));

        List<Double> arrVar = new ArrayList<>();
        List<String> arrOp = new ArrayList<>();

        //Get and store variable value
        for (int i = 1; i <= numVar; i++) {
            String varString = request.getParameter("x" + i + "");
            if (i != numVar) {
                String opString = request.getParameter("operations" + i + "");
                arrOp.add(opString);
            }
            Double x;
            try {
                x = Double.parseDouble(varString);
                arrVar.add(x);
            } catch (NumberFormatException e) {
            }

        }

        
        String resultString = null;
        double resultDouble = 0;

        //Calculate using var array and op array
        for (int i = 0; i < arrVar.size(); i++) {
            if (i == 0) {
                resultDouble = arrVar.get(i);
                resultString = arrVar.get(i) + " ";
            } else {
                resultString += arrVar.get(i) + " ";
            }
            if (i < arrOp.size()) {
                resultString += arrOp.get(i) + " ";
                if (arrOp.get(i).compareTo("+") == 0) {
                    resultDouble += arrVar.get(i + 1);
                } else {
                    resultDouble -= arrVar.get(i + 1);
                }
            }
        }

        request.setAttribute("numVar", numVar);
        request.setAttribute("arrVar", arrVar);
        request.setAttribute("arrOp", arrOp);
        request.setAttribute("resultString", resultString);
        request.setAttribute("resultNum", resultDouble);
        request.getRequestDispatcher("PhatNTHE171818_index2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }
}
