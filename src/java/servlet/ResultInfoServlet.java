/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.CourseInfo;
import DAO.ResultInfo;
import entity.Course;
import entity.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nowshad
 */
public class ResultInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String actionName = request.getParameter("actionName");
        int registrationID = Integer.parseInt(request.getParameter("registrationID"));

        System.out.println("Action " + actionName + "Registration ID " + registrationID);
        CourseInfo courseInfo = new CourseInfo();
        ResultInfo resultInfo = new ResultInfo();
        //   List<Course> registrationInfo = new ArrayList<Course>();
        try {

            List<Course> registrationInfo = courseInfo.courseListByRegistrationID(registrationID);
            List<Result> resultInfoByCourse = resultInfo.resultListByRegistrationID(registrationID);
          //  System.out.printl n("Course Name "+registrationInfo.);

            //  System.out.println("All Registration Info "+courseInfo.courseListByRegistrationID(registrationID));
            request.setAttribute("registrationInfo", registrationInfo);
            request.setAttribute("resultInfoByCourse", resultInfoByCourse);
            request.setAttribute("registrationID", registrationID);
            if (actionName.equals("editResult")) {
                RequestDispatcher rd = request.getRequestDispatcher("editCourseResult.jsp");
                rd.forward(request, response);
            } else if (actionName.equals("showResult")) {
                //System.out.println("adsrtewr");
                RequestDispatcher rd = request.getRequestDispatcher("showCourseResult.jsp");
                rd.forward(request, response);
            } else if (actionName.equals("editResultPersonal")) {

                RequestDispatcher rd = request.getRequestDispatcher("editCourseResultPersonal.jsp");
                rd.forward(request, response);
            } else if (actionName.equals("showResultPersonal")) {

                RequestDispatcher rd = request.getRequestDispatcher("showCourseResultPersonal.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int session = Integer.parseInt(request.getParameter("session"));
        int courseID = Integer.parseInt(request.getParameter("courseID"));

        try {
            ResultInfo resultInfo = new ResultInfo();
            List<Result> results = resultInfo.resultList(session, courseID);
            System.out.println("size of student: " + results.size());
            request.setAttribute("results", results);
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.include(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
