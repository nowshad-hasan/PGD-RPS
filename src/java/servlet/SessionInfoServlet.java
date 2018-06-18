/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.CourseInfo;
import DAO.SessionInfo;
import entity.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nowshad Hasan
 */
public class SessionInfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        int sessionID = Integer.parseInt(request.getParameter("sessionID"));
        System.out.println("From GET Syllabus " + sessionID);
        String pageName = request.getParameter("pageName");
        System.out.println("Page Name " + request.getParameter("pageName"));

        try {
            CourseInfo courseInfo = new CourseInfo();
            SessionInfo sessionInfo = new SessionInfo();
            // SessionInfo sessionInfo=new SessionInfo();
            List<Course> courses = courseInfo.courseListBySessionYear(sessionID);
            String sessionYear = sessionInfo.getSessionYear(sessionID);
            System.out.println("Session Year PrintPreview" + sessionYear);
            session.setAttribute("sessionYearPrintPreview", sessionYear);
            System.out.println("dkufhvls " + courses.size());
            //    System.out.println("Session Year List Size "+sessionInfo.getSessionYear());
            session.setAttribute("coursesBySession", courses);
            session.setAttribute("FullSyllabusPrintPreview", courses);
            request.setAttribute("courses", courses);
            System.out.println("jasdrhkltjw");
            //  session.setAttribute("sessionYear", sessionInfo.getSessionYear());
            if (pageName.equals("FullSyllabus")) {
                RequestDispatcher rd = request.getRequestDispatcher("FullSyllabus.jsp");
                rd.forward(request, response);
            } else if (pageName.equals("result")) {
                RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
                rd.forward(request, response);
            }

            // request.getRequestDispatcher("course.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
