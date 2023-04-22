package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import dao.DataAccess;
import javax.servlet.RequestDispatcher;


public class AllProduct extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setAttribute("AllProducr",DataAccess.getAll());
            RequestDispatcher rd = request.getRequestDispatcher("AllProduct.jsp");
            rd.forward(request,response);
        }       
    }
}
