/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nowshad
 */
public class ValidateUserServlet extends HttpServlet {

    private PrintWriter printWriter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        String userName = (String) context.getAttribute("userName");
        String userEmail = (String) context.getAttribute("userEmail");
        String userPassword = (String) context.getAttribute("userPassword");
        int roleID = (int) context.getAttribute("roleID");

        printWriter = response.getWriter();
        printWriter.println("userName: " + userName + " userEmail: " + userEmail + " userPassword: " + userPassword);

        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.registerUser(userName, userEmail, userPassword, roleID);
        if (result) {
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserInfo userInfo = new UserInfo();

        String userName = (String) request.getParameter("userName");
        String userEmail = (String) request.getParameter("userEmail");
        String userPassword = (String) request.getParameter("userPass");
        int roleID = (int) Integer.parseInt(request.getParameter("userRoleID"));
        String actionName = request.getParameter("actionName");

        if (actionName.equals("acceptAction")) {

            boolean result = userInfo.registerUser(userName, userEmail, userPassword, roleID);

            if (result) {
                userInfo.sendSuccessEmail(userEmail);

                if (userInfo.deleteUserRegistrationRequest(userEmail)) {
                    request.setAttribute("RegistrationSuccessMeassage", "RegistrationSuccess");
                } else {
                    request.setAttribute("RegistrationSuccessMeassage", "RegistrationFailure");
                }
            } else {
                request.setAttribute("RegistrationSuccessMeassage", "RegistrationFailure");
            }

        } else {
            
            if (userInfo.invalidateRegistrationEmail(userEmail)) {
                userInfo.sendRejectionEmail(userEmail);
                
                request.setAttribute("RejectionEmailSuccessMeassage", "RejectionSuccess");
                
            } else {
                request.setAttribute("RejectionEmailSuccessMeassage", "RejectionFailure");

            }
        }
        session.setAttribute("registrationRequest", userInfo.getRegistrationRequest());
        //request.setAttribute("sdr", 2534);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegistrationRequest.jsp");
        requestDispatcher.forward(request, response);

        //printWriter = response.getWriter();
        //printWriter.println("userName: " + userName + " userEmail: " + userEmail + " userPassword: " + userPassword);
    }

}
