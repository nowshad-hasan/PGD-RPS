/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.CourseInfo;
import DAO.DBConnection;
import DAO.SessionInfo;
import DAO.UserInfo;
import entity.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nowshad
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DBConnection dbConnection;
    private Connection connection;

    private PrintWriter printWriter;

    public LoginServlet() {
        super();
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String userEmail = request.getParameter("email");
        String password = request.getParameter("password");

        UserInfo userInfo = new UserInfo();
//        SessionInfo sessionInfo=new SessionInfo();
        boolean result = userInfo.authinticateUser(userEmail, password);
        String roleUser = userInfo.roleOfUser(userEmail);
        System.out.println("My Role:" + roleUser);

//                    request.setAttribute("courses", courses);
//              RequestDispatcher rd=request.getRequestDispatcher("courses.jsp");  
//        rd.include(request, response);
        if (result) {
            session.setAttribute("mySession", "MySession");
//         response.sendRedirect("home_admin.jsp");
            request.setAttribute("role", roleUser);
            SessionInfo sessionInfo = new SessionInfo();
            session.setAttribute("sessionYear", sessionInfo.getSessionYear());
            session.setAttribute("registrationRequest", userInfo.getRegistrationRequest());
            session.setAttribute("registrationStatus", sessionInfo.getRegistrationStatus());

            System.out.print("I am a " + roleUser);
            if (roleUser.equals("admin")) {
                System.out.println("I am a aerten");
//                     System.out.println("I am a admin");
//                     request.setAttribute("role", roleUser);
//                            RequestDispatcher requestDispatcher=request.getRequestDispatcher("home_admin.jsp");
//        requestDispatcher.include(request, response);
                request.setAttribute("nameOfUser", userInfo.nameOfUser(userEmail));

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("home_admin.jsp");
                requestDispatcher.forward(request, response);

            } else if (roleUser.equals("teacher")) {
                System.out.println(userEmail);

                String nameOfUser = userInfo.nameOfUser(userEmail);
                System.out.println("sjf,: " + nameOfUser);
                session.setAttribute("nameOfUser", nameOfUser);

                CourseInfo courseInfo = new CourseInfo();

                try {
                    List<Course> courses = courseInfo.teacherCourseList(userEmail);
                    session.setAttribute("myCourses", courses);
                    System.out.println("dkufhvls " + courses.size());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //    session.setAttribute(nameOfUser, result);

//                     request.setAttribute("role", roleUser);
//                     System.out.println("I am a teacher");
//                     RequestDispatcher requestDispatcher=request.getRequestDispatcher("home_teacher.jsp");
//        requestDispatcher.include(request, response);
                RequestDispatcher rd = request.getRequestDispatcher("home_teacher.jsp");
                rd.include(request, response);
            } else if (roleUser.equals("staff")) {
                System.out.println(userEmail);

                String nameOfUser = userInfo.nameOfUser(userEmail);
                System.out.println("sjf,: " + nameOfUser);
                session.setAttribute("nameOfUser", nameOfUser);

                RequestDispatcher rd = request.getRequestDispatcher("home_staff.jsp");
                rd.include(request, response);
            }

//            RequestDispatcher rd = request.getRequestDispatcher("home_teacher.jsp");
//            rd.include(request, response);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home_admin.jsp");
//            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }

    }

}
