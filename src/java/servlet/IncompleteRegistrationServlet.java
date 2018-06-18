/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nowshad Hasan
 */
public class IncompleteRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sessionYear = request.getParameter("sessionYear");
        String nextPage = request.getParameter("nextPage");
        int sessionID = Integer.parseInt(request.getParameter("sessionID"));

        request.setAttribute("sessionYear", sessionYear);
        request.setAttribute("sessionID", sessionID);
        if (nextPage.equals("course")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("course_registration.jsp");
            requestDispatcher.forward(request, response);
        } else if (nextPage.equals("student")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("student_registration.jsp");
            requestDispatcher.forward(request, response);
        } else if (nextPage.equals("result")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("result_registration.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
