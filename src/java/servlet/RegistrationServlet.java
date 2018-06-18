/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.DBConnection;
import DAO.UserInfo;
import com.sun.corba.se.spi.servicecontext.ServiceContext;
import com.sun.net.httpserver.HttpContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
public class RegistrationServlet extends HttpServlet {

    private DBConnection dbConnection;
    private Connection connection;

    private String userName, userEmail, userPassword;
    private int roleID;

    private PrintWriter printWriter;

    public RegistrationServlet() {
        super();
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserInfo userInfo = new UserInfo();

        String actionName = request.getParameter("actionName");

        if (actionName.equals("registration")) {

            userName = request.getParameter("name");
            userEmail = request.getParameter("email");

            if (userInfo.checkUser(userEmail)) {
                request.setAttribute("registrationStatus", "registered");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("registration.jsp");
                requestDispatcher.forward(request, response);
            } else if (userInfo.checkUserValidation(userEmail)) {
                request.setAttribute("registrationStatus", "rejected");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("registration.jsp");
                requestDispatcher.forward(request, response);
            } else {

                userPassword = request.getParameter("password");
                roleID = Integer.parseInt(request.getParameter("actingRole"));

                session.setAttribute("userNameReg", userName);
                session.setAttribute("userEmailReg", userEmail);
                session.setAttribute("userPasswordReg", userPassword);
                session.setAttribute("roleIDReg", roleID);
                session.setAttribute("confirmationCode", userInfo.confirmationCodeEmail(userEmail));

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("confirmationCode.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if (actionName.equals("confirmation")) {

            if (session.getAttribute("confirmationCode").equals(request.getParameter("codeConfirmation"))) {
                String userName = (String) session.getAttribute("userNameReg");
                String userEmail = (String) session.getAttribute("userEmailReg");
                String userPass = (String) session.getAttribute("userPasswordReg");
                int userRoleID = (int) session.getAttribute("roleIDReg");
                
                System.out.println("userName "+userName+" userEmail "+userEmail+" userPass "+userPass+" userRoleID "+userRoleID);
                
                if (userInfo.registerUserTemporary(userName, userEmail, userPass, userRoleID)) {
                    request.setAttribute("validateEmailMessage", "validateEmailSuccess");
                } else {
                    request.setAttribute("validateEmailMessage", "validateEmailFailure");
                }
            } else {
                request.setAttribute("validateEmailMessage", "validateEmailFailure");
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("registration.jsp");
            requestDispatcher.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        userName = request.getParameter("name");
        userEmail = request.getParameter("email");
        userPassword = request.getParameter("password");
        roleID = Integer.parseInt(request.getParameter("actingRole"));

        System.out.println("role " + roleID);

        UserInfo userInfo = new UserInfo();
        userInfo.sendEmail(userEmail);

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        context.setAttribute("userName", userName);
        context.setAttribute("userEmail", userEmail);
        context.setAttribute("userPassword", userPassword);
        context.setAttribute("roleID", roleID);

        printWriter = response.getWriter();
        printWriter.println("Please follow the link in your email");

    }

}
